package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.Date;

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
	private Date fechaNac;
	private int edad;
	private String coloYSenalesParti;
	//Foreings Keys
	//relacion propietario mascota
	@ManyToOne
	@JoinColumn
	private Mascota id_mascota_propietario;
	//relacion historia clinica mascota
	@OneToOne
	@JoinColumn
	private HistoriaClinica id_historia_mascota;
	
	
	public Mascota() {
		super();
	}
   
}
