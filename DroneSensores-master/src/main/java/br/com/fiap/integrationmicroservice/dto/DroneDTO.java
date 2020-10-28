package br.com.fiap.integrationmicroservice.dto;

import java.time.LocalDateTime;
/**
 * POJO para envio dos dados do drone 
 * @author Sara Regina Pires 
 *              
 *              
 **/

public class DroneDTO {

	private long idDrone;
	private Double latitude;
	private Double longitude;
	private Double temperatura;
	private Double unidade;
	private LocalDateTime dataAtualizacao;
	private Boolean rastreamento;
	
	public DroneDTO(long idDrone, Double latitude, Double longitude, Double temperatura, Double unidade, LocalDateTime dataAtualizacao,
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
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
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