package com.fiap.integration.fiapintegrationmicroservice.modules;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.integration.fiapintegrationmicroservice.infra.rabbit.Producer;
import com.fiap.integration.fiapintegrationmicroservice.models.Medicao;
import com.fiap.integration.fiapintegrationmicroservice.repositories.DroneRepository;
import com.fiap.integration.fiapintegrationmicroservice.repositories.MedicoesRepository;
import com.fiap.integration.fiapintegrationmicroservice.viewModels.EmailProducerRequest;

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

    private static LocalDateTime _horaPrimeiroEventoAlerta;

    private static LocalDateTime _horaFimEnvioAlerta;

    private static boolean persiteTemperaturaUmidadeNivelAlerta = false;

    @Override
    public void Analisar(Medicao medicao) throws JsonProcessingException {
        // producer.send("temperatura capturada:" + medicao.getTemperatura() + " e
        // umidade:" + medicao.getUmidade());
        _droneRepository.save(medicao.getDrone());
        _medicoesRepository.save(medicao);

        if ((medicao.getTemperatura() >= 35 || medicao.getTemperatura() <= 0) || (medicao.getUmidade() <= 0.15)) {
            if(_horaFimEnvioAlerta == null || _horaPrimeiroEventoAlerta == null){
                iniciarAvalicaoUmMinuto(medicao);
                return;
            }

            if (_horaFimEnvioAlerta.isBefore(medicao.getDataAtualizacao()) && persiteTemperaturaUmidadeNivelAlerta) {
                notificar(medicao);
                persiteTemperaturaUmidadeNivelAlerta = false;
                return;
            }

            if (_horaFimEnvioAlerta.isAfter(medicao.getDataAtualizacao()) && !persiteTemperaturaUmidadeNivelAlerta) {
                iniciarAvalicaoUmMinuto(medicao);
                return;
            }

            if (!persiteTemperaturaUmidadeNivelAlerta && (_horaFimEnvioAlerta.isBefore(medicao.getDataAtualizacao()))) {
                iniciarAvalicaoUmMinuto(medicao);
            }
        } else {
            
            persiteTemperaturaUmidadeNivelAlerta = false;
        }

    }

    private void iniciarAvalicaoUmMinuto(Medicao medicao) {
        _horaPrimeiroEventoAlerta = medicao.getDataAtualizacao();
        _horaFimEnvioAlerta = _horaPrimeiroEventoAlerta.plusMinutes(1);
        persiteTemperaturaUmidadeNivelAlerta = true;
    }

    private void notificar(Medicao medicao) throws JsonProcessingException {
        EmailProducerRequest email = new EmailProducerRequest(medicao.getDrone().getId(),
                medicao.getTemperatura().toString(), medicao.getUmidade().toString());

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(email);

        producer.send(json);
    }

}
