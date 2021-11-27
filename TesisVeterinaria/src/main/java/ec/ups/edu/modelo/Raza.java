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
		super();
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
	
	
   
}
