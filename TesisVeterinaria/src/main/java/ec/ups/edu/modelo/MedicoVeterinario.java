package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;



/**
 * Entity implementation class for Entity: MedicoVeterinario
 *
 */
@Entity

public class MedicoVeterinario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private String cedulaId;
	private String nombres;
	private String apellidos;
	private String direccion;
	private String fechaNac;
	private String celular;
	private String titulo;
	//foreing keys
	//relacion historia-medico
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "cedula_id")
	private  HistoriaClinica historiaClinica;
	

	
	//Relacion medico veterinario -  especialidad
	@OneToOne
	@JoinColumn
	private Especialidad especialidad_id;
	
	
	//Relacion Medico Veterinario	Usuario
	@OneToOne
	@JoinColumn
	private Usuario usuario_id;
	
	
	public MedicoVeterinario() {
		super();
	}


	public MedicoVeterinario(String cedulaId, String nombres, String apellidos, String direccion, String fechaNac,
			String celular, String titulo, Especialidad especialidad_id, Usuario usuario_id) {
		super();
		this.cedulaId = cedulaId;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.fechaNac = fechaNac;
		this.celular = celular;
		this.titulo = titulo;
		this.especialidad_id = especialidad_id;
		this.usuario_id = usuario_id;
	}


	public String getCedulaId() {
		return cedulaId;
	}


	public void setCedulaId(String cedulaId) {
		this.cedulaId = cedulaId;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getFechaNac() {
		return fechaNac;
	}


	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public HistoriaClinica getHistoriaClinica() {
		return historiaClinica;
	}


	public void setHistoriaClinica(HistoriaClinica historiaClinica) {
		this.historiaClinica = historiaClinica;
	}


	public Especialidad getEspecialidad_id() {
		return especialidad_id;
	}


	public void setEspecialidad_id(Especialidad especialidad_id) {
		this.especialidad_id = especialidad_id;
	}


	public Usuario getUsuario_id() {
		return usuario_id;
	}


	public void setUsuario_id(Usuario usuario_id) {
		this.usuario_id = usuario_id;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cedulaId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedicoVeterinario other = (MedicoVeterinario) obj;
		return cedulaId == other.cedulaId;
	}


	@Override
	public String toString() {
		return "MedicoVeterinario [cedulaId=" + cedulaId + ", nombres=" + nombres + ", apellidos=" + apellidos
				+ ", direccion=" + direccion + ", fechaNac=" + fechaNac + ", celular=" + celular + ", titulo=" + titulo
				+ ", especialidad_id=" + especialidad_id + ", usuario_id=" + usuario_id + "]";
	}
	
	
	
	
   
}
