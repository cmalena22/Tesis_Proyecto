package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Especie
 *
 */
@Entity

public class Especie implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int especie_id;
	private String nombreEspecie;
	//relacion especie-raza

	@OneToOne
	@JoinColumn
	private Raza razaId;
	
	
	//relacion especie mascota
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "especie_id")
	private Mascota mascota;
	

	public Especie() {
		super();
	}


	public Especie(int especie_id, String nombreEspecie, Raza razaId) {
		super();
		this.especie_id = especie_id;
		this.nombreEspecie = nombreEspecie;
		this.razaId = razaId;
	}


	public int getEspecie_id() {
		return especie_id;
	}


	public void setEspecie_id(int especie_id) {
		this.especie_id = especie_id;
	}


	public String getNombreEspecie() {
		return nombreEspecie;
	}


	public void setNombreEspecie(String nombreEspecie) {
		this.nombreEspecie = nombreEspecie;
	}


	public Raza getRazaId() {
		return razaId;
	}


	public void setRazaId(Raza razaId) {
		this.razaId = razaId;
	}


	public Mascota getMascota() {
		return mascota;
	}


	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}


	@Override
	public int hashCode() {
		return Objects.hash(especie_id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Especie other = (Especie) obj;
		return especie_id == other.especie_id;
	}


	@Override
	public String toString() {
		return "Especie [especie_id=" + especie_id + ", nombreEspecie=" + nombreEspecie + ", razaId=" + razaId + "]";
	}

	
	


	
}
