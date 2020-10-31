package com.fiap.integration.fiapintegrationmicroservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class FiapIntegrationMicroserviceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(FiapIntegrationMicroserviceApplication.class, args);
	}

}
