package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ConsultaMedica
 *
 */
@Entity

public class ConsultaMedica implements Serializable {
	private static final long serialVersionUID = 1L;

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
	
	@OneToMany(mappedBy = "consulta_id")
	private Set<HistoriaClinica> listaConsultaMedica;
	
	//Relacion consulta- constante fisio detalle	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "consulta_id")
	private Set<ConstantesFisiologicasDetalle> constantesFiologicasDetalle;
	
	
		
	//Relacion receta consult amedica
	@OneToMany(mappedBy = "recetaId")
	private Set<RecetaMedica> listreceta;
	
	
	public ConsultaMedica() { 
	}

	

	
   
}
