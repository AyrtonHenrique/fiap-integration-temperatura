package br.com.fiap.integrationmicroservice.dto;

public class DroneCreateUpdateDTO {
	
	private Long latitude;
	private Long logitude;
	private Double temperatura;
	private Double unidade;
	
	
	public Long getLatitude() {
		return latitude;
	}
	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}
	public Long getLogitude() {
		return logitude;
	}
	public void setLogitude(Long logitude) {
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
	
	

}
