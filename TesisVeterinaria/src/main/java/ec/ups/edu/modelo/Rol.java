package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
	@OneToMany(cascade=CascadeType.ALL, mappedBy ="rol_id" )
	private Set<Usuario> usuario = new HashSet<Usuario>();
	
	
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


	
	
	public Set<Usuario> getUsuario() {
		return usuario;
	}


	public void setUsuario(Set<Usuario> usuario) {
		this.usuario = usuario;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rol_id;
		return result;
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
		if (rol_id != other.rol_id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Rol [rol_id=" + rol_id + ", descripcion=" + descripcion + "]";
	}


   
}
