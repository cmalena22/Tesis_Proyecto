package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Propietario
 *
 */
@Entity

public class Propietario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPropietario;
	private String direccion;
	private String propietario;
	private String telefono;
	private String cuidad;
//foreing keys
	//relacion propietario mascota
	@OneToMany(mappedBy = "id_mascota_propietario")
	private Set<Mascota>listMascotas;
	
	
	
	private static final long serialVersionUID = 1L;

	public Propietario() {
		super();
	}
   
}
