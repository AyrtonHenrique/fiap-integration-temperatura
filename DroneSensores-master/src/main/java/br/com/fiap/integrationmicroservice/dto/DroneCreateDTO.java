package br.com.fiap.integrationmicroservice.dto;

import java.time.LocalDateTime;
/**
 * POJO para envio dos dados do drone 
 * @author Sara Regina Pires 
 *              
 *              
 **/
public class DroneCreateDTO {
	
	private Double latitude;
	private Double longitude;
	private Double temperatura;
	private Double umidade;
	private LocalDateTime  dataAtualizacao;
	private Boolean rastreamento;
	
	
	
	public DroneCreateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DroneCreateDTO(long idDrone, Double latitude, Double longitude, Double temperatura, Double unidade,
			LocalDateTime  dataAtualizacao, Boolean rastreamento) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.temperatura = temperatura;
		this.umidade = unidade;
		this.dataAtualizacao = dataAtualizacao;
		this.rastreamento = rastreamento;
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
		return umidade;
	}
	public void setUnidade(Double unidade) {
		this.umidade = unidade;
	}
	public LocalDateTime  getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(LocalDateTime  dataAtualizacao) {
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
		return "DroneCreateDTO [latitude=" + latitude + ", longitude=" + longitude
				+ ", temperatura=" + temperatura + ", unidade=" + umidade + ", dataAtualizacao=" + dataAtualizacao
				+ ", rastreamento=" + rastreamento + "]";
	}

}
