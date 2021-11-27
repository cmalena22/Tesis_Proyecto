package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ConstantesFisiologicas
 *
 */
@Entity

public class ConstantesFisiologicasCabecera implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int constantes_idCab;
	private String nombre;
	
	//Constante cabecera a constante detalle
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "constantesidCab")
	private Set<ConstantesFisiologicasDetalle> constantesFisiologicaDetalle;
	

	
}
