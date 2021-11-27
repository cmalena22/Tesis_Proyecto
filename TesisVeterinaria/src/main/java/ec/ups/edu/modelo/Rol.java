package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Rol
 *
 */
@Entity

public class Rol implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rol_id;
	private String descripcion;
	
	// Relacion Rol- Usuario
	@OneToOne(cascade=CascadeType.ALL, mappedBy ="usuarioId" )
	private Usuario usuario;
	
	
	public Rol() {
		
	}


	public Rol(int rol_id, String descripcion) {
		super();
		this.rol_id = rol_id;
		this.descripcion = descripcion;
	}


	public int getRol_id() {
		return rol_id;
	}


	public void setRol_id(int rol_id) {
		this.rol_id = rol_id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Override
	public int hashCode() {
		return Objects.hash(rol_id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rol other = (Rol) obj;
		return rol_id == other.rol_id;
	}


	@Override
	public String toString() {
		return "Rol [rol_id=" + rol_id + ", descripcion=" + descripcion + "]";
	}
	
	
   
}