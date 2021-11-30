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



	public HistoriaClinica(int idHistorial, Date diaDeAdminision, LocalDateTime hora, Mascota mascota_id,
			MedicoVeterinario cedula_id, ConsultaMedica consulta_id) {
		super();
		this.idHistorial = idHistorial;
		this.diaDeAdminision = diaDeAdminision;
		this.hora = hora;
		this.mascota_id = mascota_id;
		this.cedula_id = cedula_id;
		this.consulta_id = consulta_id;
	}



	public int getIdHistorial() {
		return idHistorial;
	}



	public void setIdHistorial(int idHistorial) {
		this.idHistorial = idHistorial;
	}



	public Date getDiaDeAdminision() {
		return diaDeAdminision;
	}



	public void setDiaDeAdminision(Date diaDeAdminision) {
		this.diaDeAdminision = diaDeAdminision;
	}



	public LocalDateTime getHora() {
		return hora;
	}



	public void setHora(LocalDateTime hora) {
		this.hora = hora;
	}



	public Mascota getMascota_id() {
		return mascota_id;
	}



	public void setMascota_id(Mascota mascota_id) {
		this.mascota_id = mascota_id;
	}



	public MedicoVeterinario getCedula_id() {
		return cedula_id;
	}



	public void setCedula_id(MedicoVeterinario cedula_id) {
		this.cedula_id = cedula_id;
	}



	public ConsultaMedica getConsulta_id() {
		return consulta_id;
	}



	public void setConsulta_id(ConsultaMedica consulta_id) {
		this.consulta_id = consulta_id;
	}



	@Override
	public int hashCode() {
		return Objects.hash(idHistorial);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoriaClinica other = (HistoriaClinica) obj;
		return idHistorial == other.idHistorial;
	}



	@Override
	public String toString() {
		return "HistoriaClinica [idHistorial=" + idHistorial + ", diaDeAdminision=" + diaDeAdminision + ", hora=" + hora
				+ ", mascota_id=" + mascota_id + ", cedula_id=" + cedula_id + ", consulta_id=" + consulta_id + "]";
	}








}
