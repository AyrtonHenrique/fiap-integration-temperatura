package com.fiap.integration.fiapintegrationmicroservice.repositories;

import com.fiap.integration.fiapintegrationmicroservice.models.Drone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
// @RepositoryRestResource(collectionResourceRel ="drones", path = "drones")
public interface DroneRepository extends JpaRepository<Drone, Long> {
    
}
