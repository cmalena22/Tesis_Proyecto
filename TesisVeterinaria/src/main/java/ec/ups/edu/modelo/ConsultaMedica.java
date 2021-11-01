package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ConsultaMedica
 *
 */
@Entity

public class ConsultaMedica implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idConsultaMedica;
	private String motivoConsulta;
	private char vacunacion; 
	private String producto;
	private char desparacitacion;
	private Date fechas;
	private String estadoReproductivo;
	private String procedencia;
	private String anamnesis;
	private String diagnostico;
	private String pronostico;
	private String observaciones;
	//foreing Keys
	//relacion historia-consulta
	@ManyToOne
	@JoinColumn
	private HistoriaClinica id_historia_consulta;
	
	//relacion consulta-constante fisiologicas
	@OneToOne(mappedBy = "id_consulta_constantes")
	private ConstantesFisiologicas constantesFisiologicas;
	
	//relacion consulta receta
	@OneToMany(mappedBy = "id_consultas_recetas")
	private Set<RecetaMedica> listaRecetaMedica;
	private static final long serialVersionUID = 1L;

	public ConsultaMedica() {
		super();
	}
   
}
