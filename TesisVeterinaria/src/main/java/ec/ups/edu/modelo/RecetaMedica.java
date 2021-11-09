package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

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
	private ConsultaMedica id_consultas_recetas;
	
	public RecetaMedica() {
	}
	public RecetaMedica(int idReceta, Date fecha, String rp, String prescripcion, ConsultaMedica id_consultas_recetas) {
		this.idReceta = idReceta;
		this.fecha = fecha;
		this.rp = rp;
		this.prescripcion = prescripcion;
		this.id_consultas_recetas = id_consultas_recetas;
	}
	public int getIdReceta() {
		return idReceta;
	}
	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getRp() {
		return rp;
	}
	public void setRp(String rp) {
		this.rp = rp;
	}
	public String getPrescripcion() {
		return prescripcion;
	}
	public void setPrescripcion(String prescripcion) {
		this.prescripcion = prescripcion;
	}
	public ConsultaMedica getId_consultas_recetas() {
		return id_consultas_recetas;
	}
	public void setId_consultas_recetas(ConsultaMedica id_consultas_recetas) {
		this.id_consultas_recetas = id_consultas_recetas;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idReceta);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecetaMedica other = (RecetaMedica) obj;
		return idReceta == other.idReceta;
	}
	@Override
	public String toString() {
		return "RecetaMedica [idReceta=" + idReceta + ", fecha=" + fecha + ", rp=" + rp + ", prescripcion="
				+ prescripcion + ", id_consultas_recetas=" + id_consultas_recetas + "]";
	}
   
	
}
