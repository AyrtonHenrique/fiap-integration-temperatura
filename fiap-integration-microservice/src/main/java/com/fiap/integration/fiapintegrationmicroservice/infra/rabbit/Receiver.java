package com.fiap.integration.fiapintegrationmicroservice.infra.rabbit;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.integration.fiapintegrationmicroservice.models.Drone;
import com.fiap.integration.fiapintegrationmicroservice.models.Medicao;
import com.fiap.integration.fiapintegrationmicroservice.modules.IMedicoesAppService;
import com.fiap.integration.fiapintegrationmicroservice.repositories.MedicoesRepository;
import com.fiap.integration.fiapintegrationmicroservice.viewModels.MedicaoConsumerResponse;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    private IMedicoesAppService _medicoesAppService;
    

    public Receiver(IMedicoesAppService appService, MedicoesRepository medicoesRepository) {
        _medicoesAppService = appService;
    }

    @RabbitListener(queues = { "queue.entrada" })
    public void receiveMessage(@Payload String message) throws JsonMappingException, JsonProcessingException {

        System.out.println("Received <" + message + ">");

        ObjectMapper mapper = new ObjectMapper();
        MedicaoConsumerResponse medicaoResponse = mapper.readValue(message, MedicaoConsumerResponse.class);

        Medicao med = new Medicao(new Drone(medicaoResponse.idDrone, ""), medicaoResponse.latitude,
                medicaoResponse.longitude, medicaoResponse.temperatura, medicaoResponse.umidade,
                medicaoResponse.dataAtualizacao, medicaoResponse.rastreamento);

        _medicoesAppService.Analisar(med);
    }

}