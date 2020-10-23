package com.fiap.integration.fiapintegrationmicroservice.viewModels;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

public class MedicaoConsumerResponse implements Serializable {
    public long idDrone;
    public Float latitude;
    public Float longitude;
    public Float temperatura;
    public Float umidade;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    public LocalDateTime dataAtualizacao;

    public boolean rastreamento;
}
