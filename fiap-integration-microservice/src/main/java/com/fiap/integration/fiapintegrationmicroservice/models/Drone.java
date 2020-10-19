package com.fiap.integration.fiapintegrationmicroservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String Nome;

    public long getId() {
        return Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public void setId(long id) {
        this.Id = id;
    }

    public Drone(long id, String nome) {
        Id = id;
        Nome = nome;
    }
}
