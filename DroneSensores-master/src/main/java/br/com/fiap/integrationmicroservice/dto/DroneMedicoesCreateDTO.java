package br.com.fiap.integrationmicroservice.dto;
/**
 * POJO para envio dos dados do drone 
 * @author Sara Regina Pires 
 *              
 *              
 **/
public class DroneMedicoesCreateDTO {
	
	
	private String idDrone;
	private String latitude;
	private String longitude;
	private String temperatura;
	private String umidade;
	private String dataAtualizacao;
	private String rastreamento;
	
	public DroneMedicoesCreateDTO() {
	}

	public DroneMedicoesCreateDTO(String latitude, String logitude, String temperatura, String umidade,
			String dataAtualizacao, String rastreamento) {
		super();
		this.latitude = latitude;
		this.longitude = logitude;
		this.temperatura = temperatura;
		this.umidade = umidade;
		this.dataAtualizacao = dataAtualizacao;
		this.rastreamento = rastreamento;
	}

	public String getIdDrone() {
		return idDrone;
	}

	public void setIdDrone(String idDrone) {
		this.idDrone = idDrone;
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
	public void setUmidade(String umidade) {
		this.umidade = umidade;
	}

	public String getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(String dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getRastreamento() {
		return rastreamento;
	}

	public void setRastreamento(String rastreamento) {
		this.rastreamento = rastreamento;
	}
	
	

}
