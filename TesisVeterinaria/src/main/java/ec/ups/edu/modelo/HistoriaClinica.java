package ec.ups.edu.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
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
	//relacion historial_mascota
	@OneToOne(mappedBy = "id_historia_mascota")
	private Mascota mascota;
	
	//relacion historia medico
	@OneToOne(mappedBy = "id_historia_medico")
	private MedicoVeterinario medicoVeterinario;
	
	//relacion historia consulta
	@OneToMany(mappedBy = "id_historia_consulta")
	private Set<ConsultaMedica> listaConsultaMedica;
	
	
	public HistoriaClinica() {
		super();
	}
   
}
