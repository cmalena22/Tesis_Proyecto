package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Raza
 *
 */
@Entity

public class Raza implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int raza_id;
	private String nombre;

	//
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "razaId")
	private Especie especie;

	
	public Raza() {
		
	}

	
	
	public Raza(int raza_id, String nombre) {
		super();
		this.raza_id = raza_id;
		this.nombre = nombre;
	}



	@Override
	public int hashCode() {
		return Objects.hash(raza_id);
	}

	
	
	public int getRaza_id() {
		return raza_id;
	}



	public void setRaza_id(int raza_id) {
		this.raza_id = raza_id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Especie getEspecie() {
		return especie;
	}



	public void setEspecie(Especie especie) {
		this.especie = especie;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Raza other = (Raza) obj;
		return raza_id == other.raza_id;
	}



	@Override
	public String toString() {
		return "Raza [raza_id=" + raza_id + ", nombre=" + nombre + "]";
	}
	
	
   
}
