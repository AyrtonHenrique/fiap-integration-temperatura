package com.fiap.integration.fiapintegrationmicroservice.repositories;

import com.fiap.integration.fiapintegrationmicroservice.models.Medicao;

import org.springframework.data.repository.CrudRepository;

public interface MedicoesRepository extends CrudRepository<Medicao,Long> {
    
}
