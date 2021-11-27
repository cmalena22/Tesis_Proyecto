package ec.ups.edu.modelo;

import java.io.Serializable;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.Timer;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: HsitoriaClinica
 *
 */
@Entity

public class HistoriaClinica implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHistorial;
	private Date diaDeAdminision;
	private LocalDateTime  hora;
	//Foreing Keys

	//relacion mascota - historia
	@OneToOne
	@JoinColumn
	private Mascota mascota_id; 
	
	//relacion historia medico	
	
	@OneToOne
	@JoinColumn
	private MedicoVeterinario cedula_id;
	
	//relacion historia consulta
	@ManyToOne
	@JoinColumn
	private ConsultaMedica consulta_id;
	
	
	
	public HistoriaClinica() {
	}








}
