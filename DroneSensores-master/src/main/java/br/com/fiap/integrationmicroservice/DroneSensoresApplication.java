package br.com.fiap.integrationmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DroneSensoresApplication {

	public static void main(String[] args) {
		System.getProperty("server.servlet.context-path", "/drone-app");
		SpringApplication.run(DroneSensoresApplication.class, args);
	}

}
