package com.fiap.integration.fiapintegrationmicroservice.modules;

import java.time.LocalDateTime;
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

    @Override
    public void Analisar(Medicao medicao) throws JsonProcessingException {
        //producer.send("temperatura capturada:" + medicao.getTemperatura() + " e umidade:" + medicao.getUmidade());
        if ((medicao.getTemperatura() >= 35 || medicao.getTemperatura() <= 0) || (medicao.getUmidade() <= 0.15)) {
            // enviar email
            EmailProducerRequest email = new EmailProducerRequest(medicao.getDrone().getId(),
                    medicao.getTemperatura().toString(), medicao.getUmidade().toString());

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(email);

            producer.send(json);
        }
        _droneRepository.save(medicao.getDrone());
        _medicoesRepository.save(medicao);
    }

   

}
