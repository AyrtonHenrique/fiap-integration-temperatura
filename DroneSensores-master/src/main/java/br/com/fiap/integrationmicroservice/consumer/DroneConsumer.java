package br.com.fiap.integrationmicroservice.consumer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fiap.integrationmicroservice.configuration.Configuracao;
import br.com.fiap.integrationmicroservice.dto.DroneDTO;


public class DroneConsumer {
	
    @Value("${queue.order.name}")
    private String orderQueue;
	
	public List<DroneDTO> receiveDrone() throws JsonParseException, JsonMappingException, IOException {
		
		List<DroneDTO> dadosDrone = new ArrayList<>();
        RabbitTemplate template = new RabbitTemplate(Configuracao.getConnection());

        while(true){
            try {
                byte[] body = template.receive(orderQueue).getBody();
                //System.out.println(new String(body));
                
                DroneDTO message = new ObjectMapper().readValue(body, DroneDTO.class);
                
                dadosDrone.add(message);
            } catch (NullPointerException ex){
                System.out.println("fila vazia!");
                break;
            }
        }
        return dadosDrone;
    }
		
	
	
}
