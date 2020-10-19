package com.fiap.integration.fiapintegrationmicroservice.viewModels;

import java.io.Serializable;
import java.util.Date;

public class MedicaoConsumerResponse implements Serializable {
    public long idDrone;
    public Float latitude;
    public Float longitude;
    public Float temperatura;
    public Float umidade;
    public Date dataAtualizacao;
    public boolean rastreamento;
}
