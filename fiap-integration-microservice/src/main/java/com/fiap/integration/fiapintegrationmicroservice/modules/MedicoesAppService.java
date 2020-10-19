package com.fiap.integration.fiapintegrationmicroservice.modules;

import java.time.LocalDateTime;
import java.util.Date;

import com.fiap.integration.fiapintegrationmicroservice.infra.rabbit.Producer;
import com.fiap.integration.fiapintegrationmicroservice.models.Medicao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoesAppService implements IMedicoesAppService {

    // private static LocalDateTime dataExp = LocalDateTime.now().plusMinutes(1);
    @Autowired
    private Producer producer;

    @Override
    public void ObterMedicao(long idDrone) {
        // TODO Auto-generated method stub

    }

    @Override
    public void Analisar(Medicao medicao) {
        producer.send("temperatura capturada:" + medicao.getTemperatura() + " e umidade:" + medicao.getUmidade());
        if ((medicao.getTemperatura() >= 35 || medicao.getTemperatura() <= 0) || (medicao.getUmidade() <= 0.15)) {
            //enviar email
            producer.send("temperatura capturada:" + medicao.getTemperatura() + " e umidade:" + medicao.getUmidade());
        }
    }

}
