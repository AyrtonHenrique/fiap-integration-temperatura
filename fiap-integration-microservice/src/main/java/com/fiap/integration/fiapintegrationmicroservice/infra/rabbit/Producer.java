package com.fiap.integration.fiapintegrationmicroservice.infra.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
	private Environment environment;
    private String exchangeName;
    private String routingKey;
    
    private Queue queue;
    
    public Producer(Environment environment) {
		this.environment = environment;
		this.exchangeName = environment.getProperty("queue.email.nome");
		this.routingKey= environment.getProperty("queue.email.routing-key");
		this.queue = new Queue(exchangeName, true); 
    }
    
    public void send(String email) {
        rabbitTemplate.convertAndSend(exchangeName, routingKey, email);
    }
}
