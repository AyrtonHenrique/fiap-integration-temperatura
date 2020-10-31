package br.com.fiap.integrationmicroservice.dto;

import java.time.LocalDateTime;
/**
 * POJO para envio dos dados do drone 
 * @author Sara Regina Pires 
 *              
 *              
 **/
public class DroneMedicoesCreateDTO {
	
	
	private String latitude;
	private String logitude;
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
		this.logitude = logitude;
		this.temperatura = temperatura;
		this.umidade = umidade;
		this.dataAtualizacao = dataAtualizacao;
		this.rastreamento = rastreamento;
	}

	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLogitude() {
		return logitude;
	}
	public void setLogitude(String logitude) {
		this.logitude = logitude;
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
	public void setUnidade(String umidade) {
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
