package com.fiap.integration.fiapintegrationmicroservice.modules;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fiap.integration.fiapintegrationmicroservice.viewModels.MedicaoConsumerResponse;


public interface IMedicoesAppService {
    
    void Analisar(MedicaoConsumerResponse medicao) throws JsonProcessingException;
}
