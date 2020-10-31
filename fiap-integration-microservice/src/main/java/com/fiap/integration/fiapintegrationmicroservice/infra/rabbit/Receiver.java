package com.fiap.integration.fiapintegrationmicroservice.infra.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.integration.fiapintegrationmicroservice.modules.IMedicoesAppService;
import com.fiap.integration.fiapintegrationmicroservice.viewModels.MedicaoConsumerResponse;

@Component
public class Receiver {
    private IMedicoesAppService _medicoesAppService;
    private long numeroMensagensRecebidas = 0;
    private final Logger logger = LoggerFactory.getLogger(Receiver.class);
    
    public Receiver(IMedicoesAppService appService) {
        _medicoesAppService = appService;
    }

    @RabbitListener(queues = { "${queue.entrada.nome}" })
    public void receiveMessage(@Payload String message) throws JsonMappingException, JsonProcessingException {
    	String proximaMensagemRecebida = getProximaMensageRecebida();
    	logger.info(proximaMensagemRecebida + "Received < " + message + " >");	
    	logger.info(proximaMensagemRecebida + "Iniciando parse do payload enviado...");
        ObjectMapper mapper = new ObjectMapper();
        MedicaoConsumerResponse medicaoResponse = mapper.readValue(message, MedicaoConsumerResponse.class);
        logger.info(proximaMensagemRecebida + "Parse executadocom sucesso. Enviando mensagem para análise.");
        _medicoesAppService.Analisar(medicaoResponse);
        logger.info(proximaMensagemRecebida + "Análise de mensagem recebida concluída com sucesso.");
    }

	private String getProximaMensageRecebida() {
		this.numeroMensagensRecebidas++;
		return "[" + numeroMensagensRecebidas +"] ";
	}

}
