package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "especie_id")
	private List<Raza> raza_id;

	
	

	public Especie() {
	
	}


	public Especie(int especie_id, String nombreEspecie) {
		this.especie_id = especie_id;
		this.nombreEspecie = nombreEspecie;
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


	


	public List<Raza> getRaza_id() {
		return raza_id;
	}


	public void setRaza_id(List<Raza> raza_id) {
		this.raza_id = raza_id;
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

	private static Especie especie;

	public static List<Especie> serializeEspecie(List<Especie> especies) {
		List<Especie> especieList = new ArrayList<>();
		especies.forEach(
		e-> {
			especie = new Especie(e.getEspecie_id(),e.getNombreEspecie());
			especieList.add(especie);		
		});
		return especieList;

	}

	@Override
	public String toString() {
		return "Especie [especie_id=" + especie_id + ", nombreEspecie=" + nombreEspecie + "]";
	}


	
	


	
}
