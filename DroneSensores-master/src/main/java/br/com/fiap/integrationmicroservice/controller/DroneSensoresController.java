package br.com.fiap.integrationmicroservice.controller;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.integrationmicroservice.dto.*;
import br.com.fiap.integrationmicroservice.service.DroneService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


/**
 * Classe controle com os Endpoints de envio dos dados e medicos do Drone. 
 * @author SaraRegina 
 *               
 *              
 **/

@RestController
@RequestMapping("/drone")
public class DroneSensoresController {

    
	private final Logger logger = LoggerFactory.getLogger(DroneSensoresController.class);
    private final DroneService droneService;
    
    
    public DroneSensoresController(DroneService droneService) {
        this.droneService = droneService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody DroneCreateDTO droneCreateDTO) {
        try {
        	        
        	Class<DroneCreateDTO> droneCreate  = DroneCreateDTO.class;
        	Field[] campos = droneCreate.getDeclaredFields();
        	
        	for (Field campo : campos) {
        		campo.setAccessible(true);
        		Object objeto = campo.get(droneCreateDTO);
        		if (objeto == null || objeto.equals("") ) {
        			logger.error("Post com o envio dados do drone - Favor preencher os dados");
        			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        			
        		} else {
        			droneService.send(droneCreateDTO);
        			logger.info("Post com o envio dados do drone - Dados Prechidos");
        			return new ResponseEntity<Void>(HttpStatus.OK);
        		}
        	}
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
   
    }
    
    
    
    @PostMapping("{id}/medicoes")
    public ResponseEntity<Void> createMedicoes(@PathVariable String id,  @RequestBody DroneMedicoesCreateDTO droneMedicoesCreateDTO){
        try {
        	Class<DroneMedicoesCreateDTO> droneCreate  = DroneMedicoesCreateDTO.class;
        	Field[] campos = droneCreate.getDeclaredFields();
        	DroneDTO drone = new DroneDTO();
        	
        	if (id.equals(null) ||id.equals("") ) {
        		drone.setIdDrone("");
        	} else { 
        		drone.setIdDrone(id);
        	}
        	
        	for (Field campo : campos) {
        		campo.setAccessible(true);
        		Object objeto = campo.get(droneMedicoesCreateDTO);
        		if (objeto == null || objeto.equals("")) {
        			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        		} else {
        			droneService.sendMedicoes(drone, droneMedicoesCreateDTO);
        			 logger.info("Dados de medicoes do drone enviado.");
        			return new ResponseEntity<Void>(HttpStatus.OK);
        		}
        	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
       
    }
} 
