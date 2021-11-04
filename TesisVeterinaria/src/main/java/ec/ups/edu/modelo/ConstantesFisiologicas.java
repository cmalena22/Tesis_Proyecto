package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.Objects;

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
	}


	public ConstantesFisiologicas(int idConstante, String peso, String t, String fCard, String fRes, String mucosas,
			char asa, String turgenciaPiel, int pulso, String otras, String estadoFisico, String estadoMental,
			ConsultaMedica id_consulta_constantes) {
		super();
		this.idConstante = idConstante;
		this.peso = peso;
		T = t;
		this.fCard = fCard;
		this.fRes = fRes;
		this.mucosas = mucosas;
		Asa = asa;
		this.turgenciaPiel = turgenciaPiel;
		this.pulso = pulso;
		this.otras = otras;
		this.estadoFisico = estadoFisico;
		this.estadoMental = estadoMental;
		this.id_consulta_constantes = id_consulta_constantes;
	}


	public int getIdConstante() {
		return idConstante;
	}


	public void setIdConstante(int idConstante) {
		this.idConstante = idConstante;
	}


	public String getPeso() {
		return peso;
	}


	public void setPeso(String peso) {
		this.peso = peso;
	}


	public String getT() {
		return T;
	}


	public void setT(String t) {
		T = t;
	}


	public String getfCard() {
		return fCard;
	}


	public void setfCard(String fCard) {
		this.fCard = fCard;
	}


	public String getfRes() {
		return fRes;
	}


	public void setfRes(String fRes) {
		this.fRes = fRes;
	}


	public String getMucosas() {
		return mucosas;
	}


	public void setMucosas(String mucosas) {
		this.mucosas = mucosas;
	}


	public char getAsa() {
		return Asa;
	}


	public void setAsa(char asa) {
		Asa = asa;
	}


	public String getTurgenciaPiel() {
		return turgenciaPiel;
	}


	public void setTurgenciaPiel(String turgenciaPiel) {
		this.turgenciaPiel = turgenciaPiel;
	}


	public int getPulso() {
		return pulso;
	}


	public void setPulso(int pulso) {
		this.pulso = pulso;
	}


	public String getOtras() {
		return otras;
	}


	public void setOtras(String otras) {
		this.otras = otras;
	}


	public String getEstadoFisico() {
		return estadoFisico;
	}


	public void setEstadoFisico(String estadoFisico) {
		this.estadoFisico = estadoFisico;
	}


	public String getEstadoMental() {
		return estadoMental;
	}


	public void setEstadoMental(String estadoMental) {
		this.estadoMental = estadoMental;
	}


	public ConsultaMedica getId_consulta_constantes() {
		return id_consulta_constantes;
	}


	public void setId_consulta_constantes(ConsultaMedica id_consulta_constantes) {
		this.id_consulta_constantes = id_consulta_constantes;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idConstante);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConstantesFisiologicas other = (ConstantesFisiologicas) obj;
		return idConstante == other.idConstante;
	}


	@Override
	public String toString() {
		return "ConstantesFisiologicas [idConstante=" + idConstante + ", peso=" + peso + ", T=" + T + ", fCard=" + fCard
				+ ", fRes=" + fRes + ", mucosas=" + mucosas + ", Asa=" + Asa + ", turgenciaPiel=" + turgenciaPiel
				+ ", pulso=" + pulso + ", otras=" + otras + ", estadoFisico=" + estadoFisico + ", estadoMental="
				+ estadoMental + ", id_consulta_constantes=" + id_consulta_constantes + "]";
	}
   
	
}
