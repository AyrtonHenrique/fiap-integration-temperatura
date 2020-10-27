package br.com.fiap.integrationmicroservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.integrationmicroservice.dto.*;
import br.com.fiap.integrationmicroservice.produtor.DroneProdutor;
import br.com.fiap.integrationmicroservice.service.DroneService;

import org.springframework.http.HttpStatus;



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
			logger.info("");
		}
        logger.info("Envio de dados do drone");
    }
    
} 
//	  @GetMapping 
//	  public List<DroneDTO> getAllDrone(@RequestParam(required = false)	Integer numero)	  { 
//		  logger.info("Envio dados do drone atualizado"); 
//		  return droneService.findAll(numero); 
//	}
//	  
//	  @GetMapping("{id}") 
//	  public DroneDTO getMonitorDroneById(@PathVariable Long id){ 
//		  return droneService.findById(id); 
//	  }
//	  
//	  
//	  @PutMapping("{id}/medicoes") 
//	  public DroneDTO update(@PathVariable Long id,
//			  				 @RequestBody DroneCreateUpdateDTO productCreateUpdateDTO){ 
//		  return droneService.update(id, productCreateUpdateDTO); 
//	  	}
//	  
//	  @DeleteMapping("{id}")
//	  @ResponseStatus(HttpStatus.NO_CONTENT) 
//	  public void delete(@PathVariable Long id){ 
//		  droneService.delete(id); 
//	  }
//	  
//	  //GetAllDrones
//	  
//	  @GetMapping 
//	  public List<DroneMedicoesDTO> getAllDrones(){ 
//	    return droneService.getAllDrones(); 
//	  }
//	  
//	  //GetAllMonitoramentoByDroneId
//	  
//	  @GetMapping
//	  @ResponseStatus(HttpStatus.NO_CONTENT) 
//	  public DroneMedicoesDTO getAllMonitoramentoByDroneId(@PathVariable Long id) { 
//		  return droneService.getAllMonitoramentoByDroneId(id); }
//	 }
