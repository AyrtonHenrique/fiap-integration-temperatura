package br.com.fiap.integrationmicroservice.dto;

import java.time.LocalDateTime;

public class DroneDTO {

	private long idDrone;
	private Long latitude;
	private Long longitude;
	private Long temperatura;
	private Double unidade;
	private LocalDateTime dataAtualizacao;
	private Boolean rastreamento;
	
	public DroneDTO(long idDrone, Long latitude, Long longitude, Long temperatura, Double unidade, LocalDateTime dataAtualizacao,
			Boolean rastreamento) {
		super();
		this.idDrone = idDrone;
		this.latitude = latitude;
		this.longitude = longitude;
		this.temperatura = temperatura;
		this.unidade = unidade;
		this.dataAtualizacao = dataAtualizacao;
		this.rastreamento = rastreamento;
	}
	
	public DroneDTO() {
		// TODO Auto-generated constructor stub
	}

	public long getIdDrone() {
		return idDrone;
	}
	public void setIdDrone(long idDrone) {
		this.idDrone = idDrone;
	}
	public Long getLatitude() {
		return latitude;
	}
	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}
	public Long getLongitude() {
		return longitude;
	}
	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}
	public Long getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(Long temperatura) {
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

	@Override
	public String toString() {
		return "DroneDTO [idDrone=" + idDrone + ", latitude=" + latitude + ", longitude=" + longitude + ", temperatura="
				+ temperatura + ", unidade=" + unidade + ", dataAtualizacao=" + dataAtualizacao + ", rastreamento="
				+ rastreamento + ", getIdDrone()=" + getIdDrone() + ", getLatitude()=" + getLatitude()
				+ ", getLongitude()=" + getLongitude() + ", getTemperatura()=" + getTemperatura() + ", getUnidade()="
				+ getUnidade() + ", getDataAtualizacao()=" + getDataAtualizacao() + ", getRastreamento()="
				+ getRastreamento() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	} 

	
	
	
}