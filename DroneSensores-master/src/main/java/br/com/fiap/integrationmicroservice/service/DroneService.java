package br.com.fiap.integrationmicroservice.service;

import org.springframework.stereotype.Service;
import br.com.fiap.integrationmicroservice.dto.DroneCreateDTO;


@Service
public interface DroneService  {
	
	 void send(DroneCreateDTO droneCreateDTO);
	
}
