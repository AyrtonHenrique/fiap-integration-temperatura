package br.com.fiap.integrationmicroservice.service;

import org.springframework.stereotype.Service;
import br.com.fiap.integrationmicroservice.dto.DroneCreateDTO;
import br.com.fiap.integrationmicroservice.dto.DroneDTO;
import br.com.fiap.integrationmicroservice.dto.DroneMedicoesCreateDTO;


@Service
public interface DroneService  {
	
	 void send(DroneCreateDTO droneCreateDTO);
	 void sendMedicoes(DroneDTO droneDTO, DroneMedicoesCreateDTO droneCreateMedicoes);
	
}
