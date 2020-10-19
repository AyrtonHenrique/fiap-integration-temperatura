package com.fiap.integration.fiapintegrationmicroservice.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_medicoes")
public class Medicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne()
    @JoinColumn(name = "id")
    private Drone drone;

    private Float latitude;
    private Float longitude;
    private Float temperatura;
    private Float umidade;
    private Date dataAtualizacao;
    private boolean rastreamento;

    public Drone getDrone() {
        return drone;
    }

    public boolean isRastreamento() {
        return rastreamento;
    }

    public void setRastreamento(boolean rastreamento) {
        this.rastreamento = rastreamento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Float getUmidade() {
        return umidade;
    }

    public void setUmidade(Float umidade) {
        this.umidade = umidade;
    }

    public Float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Float temperatura) {
        this.temperatura = temperatura;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Medicao(Drone drone, Float latitude, Float longitude, Float temperatura, Float umidade,
        Date dataAtualizacao, boolean rastreamento) {
        this.drone = drone;
        this.latitude = latitude;
        this.longitude = longitude;
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.dataAtualizacao = dataAtualizacao;
        this.rastreamento  = rastreamento;
    }
}
