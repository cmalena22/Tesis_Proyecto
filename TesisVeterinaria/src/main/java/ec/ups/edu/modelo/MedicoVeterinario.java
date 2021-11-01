package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: MedicoVeterinario
 *
 */
@Entity

public class MedicoVeterinario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private int cedulaId;
	private String nombres;
	private String apellidos;
	private String correo;
	private String direccion;
	private Date fechaNac;
	private String celular;
	private String titulo;
	private String especialidad;
	//foreing keys
	//relacion historia clinica medico
	@OneToOne
	@JoinColumn
	private HistoriaClinica id_historia_medico;
	public MedicoVeterinario() {
		super();
	}
   
}
