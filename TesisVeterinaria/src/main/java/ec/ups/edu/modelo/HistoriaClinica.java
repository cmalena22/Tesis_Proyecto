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
	@OneToOne(mappedBy = "id_historia_mascota")
	private Mascota mascota;
	
	//relacion historia medico
	@ManyToOne
	@JoinColumn
	private HistoriaClinica id_historia_medico;
	
	
	//relacion historia consulta
	@OneToMany(mappedBy = "id_historia_consulta")
	private Set<ConsultaMedica> listaConsultaMedica;
	
	
	public HistoriaClinica() {
	}


	

	public HistoriaClinica(int idHistorial, Date diaDeAdminision, LocalDateTime hora, Mascota mascota,
			HistoriaClinica id_historia_medico, Set<ConsultaMedica> listaConsultaMedica) {
		super();
		this.idHistorial = idHistorial;
		this.diaDeAdminision = diaDeAdminision;
		this.hora = hora;
		this.mascota = mascota;
		this.id_historia_medico = id_historia_medico;
		this.listaConsultaMedica = listaConsultaMedica;
	}




	public HistoriaClinica getId_historia_medico() {
		return id_historia_medico;
	}




	public void setId_historia_medico(HistoriaClinica id_historia_medico) {
		this.id_historia_medico = id_historia_medico;
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


	public Mascota getMascota() {
		return mascota;
	}


	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}


	

	public Set<ConsultaMedica> getListaConsultaMedica() {
		return listaConsultaMedica;
	}


	public void setListaConsultaMedica(Set<ConsultaMedica> listaConsultaMedica) {
		this.listaConsultaMedica = listaConsultaMedica;
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
				+ ", mascota=" + mascota + ", id_historia_medico=" + id_historia_medico + ", listaConsultaMedica="
				+ listaConsultaMedica + "]";
	}


	
}
