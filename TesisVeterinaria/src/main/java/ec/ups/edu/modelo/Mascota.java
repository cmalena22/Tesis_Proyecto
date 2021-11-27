package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Mascota
 *
 */
@Entity

public class Mascota implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_mascota;
	private String nombre;
	private String especie;
	private String raza;
	private String sexo;
	private String fechaNac;
	private String edad;
	private String coloYSenalesParti;
	//Foreings Keys
	//relacion historia mascota
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "mascota_id")
	private  HistoriaClinica historiaClinica;
	
	
	
	//relacion propiertario mascota
	@ManyToOne
	@JoinColumn
	private Propietario id_mascota_propietario;
	
	//relacion especia mascota
	
	@OneToOne
	@JoinColumn
	private Especie especie_id;
	
	public Mascota() {
	}

	
}
