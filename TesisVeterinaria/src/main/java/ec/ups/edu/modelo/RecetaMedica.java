package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: RecetaMedica
 *
 */
@Entity

public class RecetaMedica implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReceta;
	private Date fecha;
	private String rp;
	private String prescripcion;
	private static final long serialVersionUID = 1L;
//foreing keys
	//relacon consulta medica receta
	@ManyToOne
	@JoinColumn
	private RecetaMedica id_consultas_recetas;
	public RecetaMedica() {
		super();
	}
   
}
