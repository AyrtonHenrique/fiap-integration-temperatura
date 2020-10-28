package com.fiap.integration.fiapintegrationmicroservice.controllers;

import java.util.List;
import java.util.Optional;

import com.fiap.integration.fiapintegrationmicroservice.models.Drone;
import com.fiap.integration.fiapintegrationmicroservice.repositories.DroneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/drones")
public class DronesController {

    @Autowired
    private DroneRepository _droneRepository;

    @GetMapping()
    public List<Drone> get() {
        List<Drone> aa = _droneRepository.findAll();
        return aa;
    }

    @GetMapping("/{id}")
    public Drone get(@PathVariable("id") Long id) {
        Optional<Drone> drone = _droneRepository.findById(id);
        if (drone.isPresent()) {
            return drone.get();
        }
        return null;
    }
}
