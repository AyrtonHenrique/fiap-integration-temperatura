package br.com.fiap.integrationmicroservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.integrationmicroservice.dto.*;
import br.com.fiap.integrationmicroservice.service.DroneService;

import org.springframework.http.HttpStatus;

/**
 * Classe de configuração para os arquivos 
 * 
 * @param 
 *              
 *              
 **/

@RestController
@RequestMapping("drone")
public class DroneSensoresController {

    private final Logger logger = LoggerFactory.getLogger(DroneSensoresController.class);
    private final DroneService droneService;
    
    
    public DroneSensoresController(DroneService droneService) {
        this.droneService = droneService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody DroneCreateDTO droneCreateDTO){
        try {
        	droneService.send(droneCreateDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Erro no envio dadaos do Drone");
		}
        logger.info("Envio de dados do Drone");
    }
    
    
    
    @PostMapping("{idDrone}/medicoes")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMedicoes(@RequestBody DroneMedicoesCreateDTO droneMedicoesCreateDTO){
        try {
        	droneService.sendMedicoes(droneMedicoesCreateDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Erro no envio de dados das medicoes  do Drone");
		}
        logger.info("Envio de dados de medicoes do drone");
    }
} 
