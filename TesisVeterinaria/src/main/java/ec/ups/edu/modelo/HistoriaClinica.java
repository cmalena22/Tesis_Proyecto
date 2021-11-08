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
	//relacion historial_mascota
	
	
	@OneToOne
	@JoinColumn
	private Mascota id_historia_mascota;
	
	//relacion historia medico
	@ManyToOne
	@JoinColumn
	private MedicoVeterinario id_historia_medico;
	
	
	//relacion historia consulta
	@ManyToOne
	@JoinColumn
	private ConsultaMedica id_historia_consulta;
	
	
	
	public HistoriaClinica() {
	}


	
	



	public HistoriaClinica(int idHistorial, Date diaDeAdminision, LocalDateTime hora, Mascota id_historia_mascota,
			MedicoVeterinario id_historia_medico, ConsultaMedica id_historia_consulta) {
		super();
		this.idHistorial = idHistorial;
		this.diaDeAdminision = diaDeAdminision;
		this.hora = hora;
		this.id_historia_mascota = id_historia_mascota;
		this.id_historia_medico = id_historia_medico;
		this.id_historia_consulta = id_historia_consulta;
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




	




	public MedicoVeterinario getId_historia_medico() {
		return id_historia_medico;
	}







	public void setId_historia_medico(MedicoVeterinario id_historia_medico) {
		this.id_historia_medico = id_historia_medico;
	}







	public Mascota getId_historia_mascota() {
		return id_historia_mascota;
	}



	public void setId_historia_mascota(Mascota id_historia_mascota) {
		this.id_historia_mascota = id_historia_mascota;
	}



	public ConsultaMedica getId_historia_consulta() {
		return id_historia_consulta;
	}

	
	public void setId_historia_consulta(ConsultaMedica id_historia_consulta) {
		this.id_historia_consulta = id_historia_consulta;
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
				+ ", id_historia_mascota=" + id_historia_mascota + ", id_historia_medico=" + id_historia_medico
				+ ", id_historia_consulta=" + id_historia_consulta + "]";
	}




}
