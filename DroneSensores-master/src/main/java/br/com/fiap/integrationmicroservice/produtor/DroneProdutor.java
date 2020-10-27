package br.com.fiap.integrationmicroservice.produtor;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.fiap.integrationmicroservice.configuration.Configuracao;
import br.com.fiap.integrationmicroservice.dto.DroneCreateDTO;


@Component
public class DroneProdutor {

    @Value("${queue.order.name}")
    private String orderQueue;
    
    
    public void sendDrone( DroneCreateDTO droneCreateDTO ) throws Exception {
    	
    	//Convertendo o objeto para Json
    	Gson gson = new Gson();
    	String dadosDrone = gson.toJson( droneCreateDTO );
        final String exchange = "drone.entrada";
        RabbitTemplate template = new RabbitTemplate(Configuracao.getConnection());
        template.convertAndSend(exchange, "drone_data", dadosDrone );
    }
	
}
