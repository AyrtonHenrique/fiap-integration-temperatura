package com.fiap.integration.fiapintegrationmicroservice.repositories;

import com.fiap.integration.fiapintegrationmicroservice.models.Drone;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneRepository extends JpaRepository<Drone, Long> {
    
}
