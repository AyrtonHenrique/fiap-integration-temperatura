package com.fiap.integration.fiapintegrationmicroservice.modules;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.integration.fiapintegrationmicroservice.infra.rabbit.Producer;
import com.fiap.integration.fiapintegrationmicroservice.models.Drone;
import com.fiap.integration.fiapintegrationmicroservice.models.Medicao;
import com.fiap.integration.fiapintegrationmicroservice.repositories.DroneRepository;
import com.fiap.integration.fiapintegrationmicroservice.repositories.MedicoesRepository;
import com.fiap.integration.fiapintegrationmicroservice.viewModels.EmailProducerRequest;
import com.fiap.integration.fiapintegrationmicroservice.viewModels.MedicaoConsumerResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoesAppService implements IMedicoesAppService {

    // private static LocalDateTime dataExp = LocalDateTime.now().plusMinutes(1);
    @Autowired
    private Producer producer;

    @Autowired
    private MedicoesRepository _medicoesRepository;

    @Autowired
    private DroneRepository _droneRepository;

    private static List<Evento> _eventoAlerta = new ArrayList<Evento>();

    @Override
    public void Analisar(MedicaoConsumerResponse medicaoResponse) throws JsonProcessingException {

        Drone drone = _droneRepository.save(new Drone(medicaoResponse.idDrone, ""));

        Medicao medicao = new Medicao(drone, medicaoResponse.latitude, medicaoResponse.longitude,
                medicaoResponse.temperatura, medicaoResponse.umidade, medicaoResponse.dataAtualizacao,
                medicaoResponse.rastreamento);

        _medicoesRepository.save(medicao);

        Optional<Drone> _drone = _droneRepository.findById(medicao.getDrone().getId());
        if (_drone.isPresent()) {
            if (!_drone.get().getMedicoes().isEmpty()) {
                medicao = _drone.get().getMedicoes().stream().findFirst().get();
            }
        }
        Long iddrone = medicao.getDrone().getId();
        Optional<Evento> evento = _eventoAlerta.stream().filter(e -> e.getIdDrone() == iddrone).findFirst();

        if ((medicao.getTemperatura() >= 35 || medicao.getTemperatura() <= 0) || (medicao.getUmidade() <= 0.15)) {

            if (_eventoAlerta.isEmpty() || !evento.isPresent()) {
                iniciarAvalicaoUmMinuto(medicao);
                return;
            }

            if (evento.get().getHoraFimEnvioAlerta().isBefore(medicao.getDataAtualizacao())
                    && evento.get().getPersiteTemperaturaUmidadeNivelAlerta()) {
                notificar(medicao);
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
