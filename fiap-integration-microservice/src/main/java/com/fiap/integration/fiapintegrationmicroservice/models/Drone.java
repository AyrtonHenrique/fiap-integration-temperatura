package com.fiap.integration.fiapintegrationmicroservice.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Drone {
    @Id
    private long Id;

    private String Nome;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "drone")
    @OrderBy("dataAtualizacao DESC")
    private Set<Medicao> Medicoes = new HashSet<>();

    public long getId() {
        return Id;
    }

    public Set<Medicao> getMedicoes() {
        return Medicoes;
    }

    public void setMedicoes(Set<Medicao> medicoes) {
        this.Medicoes = medicoes;
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
    public Drone() {
        super();
    }
    public Drone(long id, String nome) {
        Id = id;
        Nome = nome;
    }
}
