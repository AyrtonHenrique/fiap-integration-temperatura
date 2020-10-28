package br.com.fiap.integrationmicroservice.produtor;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.fiap.integrationmicroservice.configuration.Configuracao;
import br.com.fiap.integrationmicroservice.dto.DroneCreateDTO;
import br.com.fiap.integrationmicroservice.dto.DroneMedicoesCreateDTO;


@Component
public class DroneProdutor {
	
	private Environment environment;
	
	public DroneProdutor(Environment environment) {
		this.environment = environment;
	}

    public void sendDrone( DroneCreateDTO droneCreateDTO ) throws Exception {
    	//Convertendo o objeto para Json
    	Gson gson = new Gson();
    	String dadosDrone = gson.toJson( droneCreateDTO );
        RabbitTemplate template = new RabbitTemplate(Configuracao.getConnection());
        template.convertAndSend(environment.getProperty("spring.rabbitmq.exchange"), 
        		environment.getProperty("spring.rabbitmq.key"), dadosDrone );
    }
	
    
    public void sendDroneMedicoes( DroneMedicoesCreateDTO droneCreateDTO ) throws Exception {
    	//Convertendo o objeto para Json
    	Gson gson = new Gson();
    	String dadosDrone = gson.toJson( droneCreateDTO );
        RabbitTemplate template = new RabbitTemplate(Configuracao.getConnection());
        template.convertAndSend(environment.getProperty("spring.rabbitmq.exchange"), 
        		environment.getProperty("spring.rabbitmq.key"), dadosDrone );
    }
    
}
