package br.com.fiap.integrationmicroservice.dto;
/**
 * POJO para envio dos dados do drone 
 * @author Sara Regina Pires 
 *              
 *              
 **/

public class DroneDTO {

	private String idDrone;
	
	public DroneDTO(String idDrone) {
		super();
		this.idDrone = idDrone;
	}
	
	public DroneDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getIdDrone() {
		return idDrone;
	}
	public void setIdDrone(String idDrone) {
		this.idDrone = idDrone;
	}

	@Override
	public String toString() {
		return "DroneDTO [idDrone=" + idDrone + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof DroneDTO)) {
			return false;
		}
		DroneDTO other = (DroneDTO) obj;
		if (idDrone != other.idDrone) {
			return false;
		}
		return true;
	}

	
	
	
}