package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Especialidad
 *
 */
@Entity

public class Especialidad implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int especialidad_id;
	private String tipoEspecialidad;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "especialidad_id")
	private MedicoVeterinario medicoVeterinario;
	

	
	public Especialidad() {
		
	}
	
	


	public Especialidad(int especialidad_id, String tipoEspecialidad) {
		
		this.especialidad_id = especialidad_id;
		this.tipoEspecialidad = tipoEspecialidad;
	}



	public int getEspecialidad_id() {
		return especialidad_id;
	}




	public void setEspecialidad_id(int especialidad_id) {
		this.especialidad_id = especialidad_id;
	}




	public String getTipoEspecialidad() {
		return tipoEspecialidad;
	}




	public void setTipoEspecialidad(String tipoEspecialidad) {
		this.tipoEspecialidad = tipoEspecialidad;
	}




	public MedicoVeterinario getMedicoVeterinario() {
		return medicoVeterinario;
	}




	public void setMedicoVeterinario(MedicoVeterinario medicoVeterinario) {
		this.medicoVeterinario = medicoVeterinario;
	}




	@Override
	public int hashCode() {
		return Objects.hash(especialidad_id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Especialidad other = (Especialidad) obj;
		return especialidad_id == other.especialidad_id;
	}




	@Override
	public String toString() {
		return "Especialidad [especialidad_id=" + especialidad_id + ", tipoEspecialidad=" + tipoEspecialidad + "]";
	}
	
	
	
   
}
