package br.com.fiap.integrationmicroservice.produtor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.fiap.integrationmicroservice.configuration.Configuracao;
import br.com.fiap.integrationmicroservice.dto.DroneCreateDTO;
import br.com.fiap.integrationmicroservice.dto.DroneDTO;
import br.com.fiap.integrationmicroservice.dto.DroneMedicoesCreateDTO;

/**
 * Classe com a implemtações dos envio dos dados do Drone.  
 * @author Sara Regina Pires 
 *              
 *              
 **/
@Component
public class DroneProdutor {
	
	private final Logger logger = LoggerFactory.getLogger(DroneProdutor.class);
	private Environment environment;
		
	public DroneProdutor(Environment environment) {
		this.environment = environment;
	}

    public void sendDrone( DroneCreateDTO droneCreateDTO ) throws Exception {
    	//Convertendo o objeto para Json
    	Gson gson = new Gson();
    	String dadosDrone = gson.toJson( droneCreateDTO );
        RabbitTemplate template = new RabbitTemplate(Configuracao.getConnection());
        //template.convertAndSend(routingKey, message, messagePostProcessor);
        //template.c
        template.convertAndSend(environment.getProperty("spring.rabbitmq.exchange"), environment.getProperty("spring.rabbitmq.key"), dadosDrone );
        
    }
	
    
    public void sendDroneMedicoes( DroneDTO droneDTO, DroneMedicoesCreateDTO droneCreateDTO ) throws Exception {
    	//Convertendo o objeto para Json
    	Gson gson = new Gson();
    	String idDrone = gson.toJson( droneDTO );
    	String dadosDrone = gson.toJson( droneCreateDTO );
        RabbitTemplate template = new RabbitTemplate(Configuracao.getConnection());
        template.convertAndSend(environment.getProperty("spring.rabbitmq.exchange"), environment.getProperty("spring.rabbitmq.key"),  idDrone + "\n" + dadosDrone );
    }
    
}
