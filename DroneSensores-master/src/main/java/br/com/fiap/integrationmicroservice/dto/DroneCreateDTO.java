package br.com.fiap.integrationmicroservice.dto;
/**
 * POJO para envio dos dados do drone 
 * @author Sara Regina Pires 
 *              
 *              
 **/
public class DroneCreateDTO {
	
	private String latitude;
	private String longitude;
	private String temperatura;
	private String umidade;
	private String dataAtualizacao;
	private String rastreamento;
	
	
	
	public DroneCreateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DroneCreateDTO(String latitude, String longitude, String temperatura, String unidade,
			String  dataAtualizacao, String rastreamento) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.temperatura = temperatura;
		this.umidade = unidade;
		this.dataAtualizacao = dataAtualizacao;
		this.rastreamento = rastreamento;
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
	public String getUnidade() {
		return umidade;
	}
	public void setUnidade(String unidade) {
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
