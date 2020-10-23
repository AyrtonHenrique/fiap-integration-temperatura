package com.fiap.integration.fiapintegrationmicroservice.modules;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fiap.integration.fiapintegrationmicroservice.models.Medicao;

import antlr.collections.List;

public interface IMedicoesAppService {
    
    void Analisar(Medicao medicao) throws JsonProcessingException;
}
