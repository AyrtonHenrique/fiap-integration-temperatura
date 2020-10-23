package com.fiap.integration.fiapintegrationmicroservice.repositories;

import com.fiap.integration.fiapintegrationmicroservice.models.Medicao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoesRepository extends JpaRepository<Medicao,Long> {
    
}
