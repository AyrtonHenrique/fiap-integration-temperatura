package br.com.fiap.integrationmicroservice.dto;

import java.util.List;

public class DroneMedicoesDTO {
	
	private long id;
	private String nome;
	private List<DroneDTO> medicoes;
	
	public DroneMedicoesDTO(long id, String nome, List<DroneDTO> medicoes) {
		super();
		this.id = id;
		this.nome = nome;
		this.medicoes = medicoes;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<DroneDTO> getMedicoes() {
		return medicoes;
	}
	public void setMedicoes(List<DroneDTO> medicoes) {
		this.medicoes = medicoes;
	}
	@Override
	public String toString() {
		return "DroneMedicoesDTO [id=" + id + ", nome=" + nome + ", medicoes=" + medicoes + "]";
	}
	
	
	

}
