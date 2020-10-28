package com.fiap.integration.fiapintegrationmicroservice.infra.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
 
    static final String queueName = "${queue.email.nome}";

    private Queue queue = new Queue(queueName, true);
 
    public void send(String email) {
        rabbitTemplate.convertAndSend(this.queue.getName(), email);
    }
}
