package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ConstantesFisiologicasDetalle
 *
 */
@Entity

public class ConstantesFisiologicasDetalle implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int constante_idDetalle;
	private String valorAsignado;
	
	//Relacion Contstante id cab constante detalle
	@ManyToOne
	@JoinColumn
	private ConstantesFisiologicasCabecera constantesidCab;

	
	//Relacion constantes detalles consulta medica
	@ManyToOne
	@JoinColumn
	private ConsultaMedica consulta_id;

	
	

	public ConstantesFisiologicasDetalle() {
		super();
	}
   
}
