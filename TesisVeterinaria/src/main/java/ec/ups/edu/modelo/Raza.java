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

	//Relacion especie - raza
	@ManyToOne
	@JoinColumn
	private Especie especie_id;
	
	public Raza() {
		
	}

	public Raza(int raza_id, String nombre, Especie especie_id) {
		this.raza_id = raza_id;
		this.nombre = nombre;
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
	public static List<Raza> serializeRaza(List<Raza> raza){
		List<Raza > razaList= new ArrayList<Raza>();
		raza.forEach(e->{
			Raza razas = new Raza(e.getRaza_id(), e.getNombre(), e.getEspecie_id());
			razaList.add(razas);
			
			
			
			
		});
		return razaList;
		
	}
	
	@Override
	public String toString() {
		return "Raza [raza_id=" + raza_id + ", nombre=" + nombre + ", especie_id=" + especie_id + "]";
	}

	
	
   
}
