package com.fiap.integration.fiapintegrationmicroservice.infra.rabbit;

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
    
    public Producer(Environment environment) {
		this.environment = environment;
		this.exchangeName = environment.getProperty("spring.rabbitmq.template.exchange");
		this.routingKey= environment.getProperty("spring.rabbitmq.template.routing-key");
    }
    
    public void send(String email) {
        rabbitTemplate.convertAndSend(exchangeName, routingKey, email);
    }
}
