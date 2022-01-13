package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
	private String estado;

	// Relacion especie - raza
	@ManyToOne
	@JoinColumn
	private Especie especie_id;

	//relacion raza mascota
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "raza_id")
	private List<Mascota> mascota;
	
	public Raza() {

	}


	public Raza(int raza_id, String nombre, String estado, Especie especie_id) {
		super();
		this.raza_id = raza_id;
		this.nombre = nombre;
		this.estado = estado;
		this.especie_id = especie_id;
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

	public Especie getEspecie_id() {
		return especie_id;
	}

	public void setEspecie_id(Especie especie_id) {
		this.especie_id = especie_id;
	}
	
	

	public List<Mascota> getMascota() {
		return mascota;
	}

	public void setMascota(List<Mascota> mascota) {
		this.mascota = mascota;
	}
	
	

	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Override
	public int hashCode() {
		return Objects.hash(raza_id);
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

	private static Raza raza;

	public static List<Raza> serializeRaza(List<Raza> razas) {
		List<Raza> razaList = new ArrayList<>();
		razas.forEach(
		e-> {
			Especie especie = new Especie(e.getEspecie_id().getEspecie_id(), e.getEspecie_id().getNombreEspecie(),e.getEspecie_id().getEstado());

			raza = new Raza(e.getRaza_id(), e.getNombre(),e.getEstado(),especie);
			razaList.add(raza);

		});
		return razaList;

	}

	@Override
	public String toString() {
		return "Raza [raza_id=" + raza_id + ", nombre=" + nombre + ", especie_id=" + especie_id + "]";
	}

}
