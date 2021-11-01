package ec.ups.edu.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ConstantesFisiologicas
 *
 */
@Entity

public class ConstantesFisiologicas implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idConstante;
	private String peso;
	private String T;
	private String fCard;
	private String fRes;
	private String mucosas;
	private char Asa;
	private String turgenciaPiel;
	private int pulso;
	private String otras;
	private String estadoFisico;
	private String estadoMental;
	//foreing keys
	//relacion consulta constantes
	@OneToOne
	@JoinColumn
	private ConsultaMedica id_consulta_constantes;
	
	
	public ConstantesFisiologicas() {
		super();
	}
   
}
