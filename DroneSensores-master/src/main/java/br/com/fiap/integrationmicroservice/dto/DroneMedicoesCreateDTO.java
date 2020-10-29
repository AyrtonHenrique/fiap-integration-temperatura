package br.com.fiap.integrationmicroservice.dto;

import java.time.LocalDateTime;
/**
 * POJO para envio dos dados do drone 
 * @author Sara Regina Pires 
 *              
 *              
 **/
public class DroneMedicoesCreateDTO {
	
	
	private Long idDrone;
	private Double latitude;
	private Double logitude;
	private Double temperatura;
	private Double unidade;
	private LocalDateTime dataAtualizacao;
	private Boolean rastreamento;
	
	public DroneMedicoesCreateDTO() {
	}

	public DroneMedicoesCreateDTO(Double latitude, Double logitude, Double temperatura, Double unidade,
			LocalDateTime dataAtualizacao, Boolean rastreamento) {
		super();
		this.latitude = latitude;
		this.logitude = logitude;
		this.temperatura = temperatura;
		this.unidade = unidade;
		this.dataAtualizacao = dataAtualizacao;
		this.rastreamento = rastreamento;
	}

	


	public Long getIdDrone() {
		return idDrone;
	}

	public void setIdDrone(Long idDrone) {
		this.idDrone = idDrone;
	}

	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLogitude() {
		return logitude;
	}
	public void setLogitude(Double logitude) {
		this.logitude = logitude;
	}
	public Double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}
	public Double getUnidade() {
		return unidade;
	}
	public void setUnidade(Double unidade) {
		this.unidade = unidade;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Boolean getRastreamento() {
		return rastreamento;
	}

	public void setRastreamento(Boolean rastreamento) {
		this.rastreamento = rastreamento;
	}
	
	

}
