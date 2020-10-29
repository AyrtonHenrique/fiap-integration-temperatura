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
	
	public DroneDTO(long idDrone) {
		super();
		this.idDrone = idDrone;
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

	@Override
	public String toString() {
		return "DroneDTO [idDrone=" + idDrone + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idDrone ^ (idDrone >>> 32));
		return result;
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