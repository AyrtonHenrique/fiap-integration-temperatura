package com.fiap.integration.fiapintegrationmicroservice.modules;

import com.fiap.integration.fiapintegrationmicroservice.models.Medicao;

public interface IMedicoesAppService {
    void ObterMedicao(long idDrone);
    void Analisar(Medicao medicao);
}
