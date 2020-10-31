package com.fiap.integration.fiapintegrationmicroservice.modules;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.integration.fiapintegrationmicroservice.infra.rabbit.Producer;
import com.fiap.integration.fiapintegrationmicroservice.models.Drone;
import com.fiap.integration.fiapintegrationmicroservice.models.Medicao;
import com.fiap.integration.fiapintegrationmicroservice.repositories.DroneRepository;
import com.fiap.integration.fiapintegrationmicroservice.repositories.MedicoesRepository;
import com.fiap.integration.fiapintegrationmicroservice.viewModels.EmailProducerRequest;
import com.fiap.integration.fiapintegrationmicroservice.viewModels.MedicaoConsumerResponse;

@Service
public class MedicoesAppService implements IMedicoesAppService {

    @Autowired
    private Producer producer;

    @Autowired
    private MedicoesRepository _medicoesRepository;

    @Autowired
    private DroneRepository _droneRepository;
    private final Logger logger = LoggerFactory.getLogger(MedicoesAppService.class);
    private static List<Evento> _eventoAlerta = new ArrayList<Evento>();

    @Override
    public void Analisar(MedicaoConsumerResponse medicaoResponse) throws JsonProcessingException {

    	logger.info("Atualizando Drone no banco de dados");
        Drone drone = _droneRepository.save(new Drone(medicaoResponse.idDrone, ""));

        Medicao medicao = new Medicao(drone, medicaoResponse.latitude, medicaoResponse.longitude,
                medicaoResponse.temperatura, medicaoResponse.umidade, medicaoResponse.dataAtualizacao,
                medicaoResponse.rastreamento);
    	logger.info("Salvando nova Medição no banco de dados");
        _medicoesRepository.save(medicao);

        Optional<Drone> _drone = _droneRepository.findById(medicao.getDrone().getId());
        if (_drone.isPresent()) {
            if (!_drone.get().getMedicoes().isEmpty()) {
                medicao = _drone.get().getMedicoes().stream().findFirst().get();
            }
        }

    	logger.info("Iniciando validação de alertas de temperatura e umidade...");
        Long iddrone = medicao.getDrone().getId();
        Optional<Evento> evento = _eventoAlerta.stream().filter(e -> e.getIdDrone() == iddrone).findFirst();

        if ((medicao.getTemperatura() >= 35 || medicao.getTemperatura() <= 0) || (medicao.getUmidade() <= 0.15)) {
        	logger.info("Alerta de Temperatura e Umidade ATIVADO. Validando regras...");
            if (_eventoAlerta.isEmpty() || !evento.isPresent()) {
                iniciarAvalicaoUmMinuto(medicao);
                return;
            }

            if (evento.get().getHoraFimEnvioAlerta().isBefore(medicao.getDataAtualizacao())
                    && evento.get().getPersiteTemperaturaUmidadeNivelAlerta()) {
            	logger.info("Alerta de Temperatura e Pressão - NECESSIDADE DE ENVIO DE E-MAIL PARA GESTORES.");
            	logger.info("Alerta de Temperatura e Pressão - Temperatura ou Umidade fora dos limites aceitos no período de 1min.");
                notificar(medicao);
                logger.info("Alerta de Temperatura e Pressão - Solicitação de envio de EMAIL encaminhada.");
                _eventoAlerta.remove(evento.get());
                return;
            }

            if (evento.get().getHoraFimEnvioAlerta().isAfter(medicao.getDataAtualizacao())
                    && !evento.get().getPersiteTemperaturaUmidadeNivelAlerta()) {
                _eventoAlerta.remove(evento.get());
                iniciarAvalicaoUmMinuto(medicao);
                return;
            }

            if (!evento.get().getPersiteTemperaturaUmidadeNivelAlerta()
                    && (evento.get().getHoraFimEnvioAlerta().isBefore(medicao.getDataAtualizacao()))) {
                iniciarAvalicaoUmMinuto(medicao);
            }
        } else {
            if (evento.isPresent()) {
                _eventoAlerta.remove(evento.get());
            }
        }
    }

    private void iniciarAvalicaoUmMinuto(Medicao medicao) {
        _eventoAlerta.add(new Evento(medicao.getDataAtualizacao(), medicao.getDataAtualizacao().plusMinutes(1),
                medicao.getId(), true));
    }

    private void notificar(Medicao medicao) throws JsonProcessingException {

        EmailProducerRequest email = new EmailProducerRequest(medicao.getDrone().getId(),
                medicao.getTemperatura().toString(), medicao.getUmidade().toString());

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(email);

        producer.send(json);
    }

}
