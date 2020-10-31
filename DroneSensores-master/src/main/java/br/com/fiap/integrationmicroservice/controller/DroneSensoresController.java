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
 * Classe controle com os Endpoints de envio dos dados e medicoes do Drone. 
 * @author SaraRegina 
 *               
 *              
 **/

@RestController
@RequestMapping("/drone")
public class DroneSensoresController {

	private final Logger logger = LoggerFactory.getLogger(DroneSensoresController.class);
    private final DroneService droneService;
    private long mensagensRecebidas = 0; 
    
    public DroneSensoresController(DroneService droneService) {
        this.droneService = droneService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody DroneCreateDTO droneCreateDTO) {
    	String tokenNumeroMensagemRecebida = getProximaMensagemRecebida();
        try {
        	logger.info(tokenNumeroMensagemRecebida + "Nova medição recebida. Iniciando processamento.");
        	Class<DroneCreateDTO> droneCreate  = DroneCreateDTO.class;
        	Field[] campos = droneCreate.getDeclaredFields();
        	for (Field campo : campos) {
        		campo.setAccessible(true);
        		Object objeto = campo.get(droneCreateDTO);
        		if (objeto == null || objeto.equals("") ) {
        			logger.error(tokenNumeroMensagemRecebida + "Dados enviados inconsistentes. Cancelando processamento.");
        			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        		} 
        	}
        	logger.info(tokenNumeroMensagemRecebida + "Validação dos dados enviados concluída. Enviando dados para o RabbitMQ para processamento.");
			droneService.send(droneCreateDTO);
			logger.info(tokenNumeroMensagemRecebida + "Dados enviados com sucesso.");
			return new ResponseEntity<Void>(HttpStatus.OK);
		
        } catch (Exception e) {
        	logger.error(tokenNumeroMensagemRecebida + "Ocorreu um problema no processamento dos dados enviados", e);
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
 
    }
    
    
    
    private String getProximaMensagemRecebida() {
		this.mensagensRecebidas++;
		return "[" + this.mensagensRecebidas + "] ";
	}

	@PostMapping("{id}/medicoes")
    public ResponseEntity<Void> createMedicoes(@PathVariable String id,  @RequestBody DroneMedicoesCreateDTO droneMedicoesCreateDTO){
		String tokenNumeroMensagemRecebida = getProximaMensagemRecebida();
		try {
			logger.info(tokenNumeroMensagemRecebida + "Nova medição recebida. Iniciando processamento.");
        	Class<DroneMedicoesCreateDTO> droneCreate  = DroneMedicoesCreateDTO.class;
        	Field[] campos = droneCreate.getDeclaredFields();
        	for (Field campo : campos) {
        		campo.setAccessible(true);
        		Object objeto = campo.get(droneMedicoesCreateDTO);
        		if (objeto == null || (objeto.equals("") && id.equals("0")) ) {
        			logger.error(tokenNumeroMensagemRecebida + "Dados enviados inconsistentes. Cancelando processamento.");
        			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        		} 
        	}		
        	if (id == null || id.equals("") ) {
				droneMedicoesCreateDTO.setIdDrone("");
			} else { 
				droneMedicoesCreateDTO.setIdDrone(id);
			}
        	logger.info(tokenNumeroMensagemRecebida + "Validação dos dados enviados concluída. Enviando dados de medição para o RabbitMQ para processamento.");
			droneService.sendMedicoes(droneMedicoesCreateDTO);
			logger.info(tokenNumeroMensagemRecebida + "Dados de medição enviados com sucesso.");
			return new ResponseEntity<Void>(HttpStatus.OK);
	
        } catch (Exception e) {
        	logger.error(tokenNumeroMensagemRecebida + "Ocorreu um problema no processamento dos dados enviados", e);
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
       
    }
} 
