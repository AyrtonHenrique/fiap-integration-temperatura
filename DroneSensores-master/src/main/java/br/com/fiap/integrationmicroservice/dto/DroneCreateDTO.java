package br.com.fiap.integrationmicroservice.dto;

import org.springframework.lang.NonNull;

/**
 * POJO para envio dos dados do drone
 * 
 * @author Sara Regina Pires
 * 
 * 
 **/
public class DroneCreateDTO {

	private Long idDrone;
	@NonNull
	private String latitude;
	@NonNull
	private String longitude;
	@NonNull
	private String temperatura;
	@NonNull
	private String umidade;
	@NonNull
	private String dataAtualizacao;
	@NonNull
	private String rastreamento;

	public DroneCreateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdDrone() {
		return idDrone;
	}

	public void setIdDrone(Long idDrone) {
		this.idDrone = idDrone;
	}

	public DroneCreateDTO(String latitude, String longitude, String temperatura, String umidade,
			String  dataAtualizacao, String rastreamento, Long iddrone) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.temperatura = temperatura;
		this.umidade = umidade;
		this.dataAtualizacao = dataAtualizacao;
		this.rastreamento = rastreamento;
		this.idDrone  = iddrone;
	}
	
	
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}
	public String getUmidade() {
		return umidade;
	}
	public void setUmidade(String unidade) {
		this.umidade = unidade;
	}
	public String  getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(String  dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	public String getRastreamento() {
		return rastreamento;
	}
	public void setRastreamento(String rastreamento) {
		this.rastreamento = rastreamento;
	}
	
	@Override
	public String toString() {
		return "DroneCreateDTO [latitude=" + latitude + ", longitude=" + longitude
				+ ", temperatura=" + temperatura + ", unidade=" + umidade + ", dataAtualizacao=" + dataAtualizacao
				+ ", rastreamento=" + rastreamento + "]";
	}

}
