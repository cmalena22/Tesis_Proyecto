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



	
}
