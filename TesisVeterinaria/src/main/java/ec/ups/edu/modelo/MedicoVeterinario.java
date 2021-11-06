package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: MedicoVeterinario
 *
 */
@Entity

public class MedicoVeterinario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private int cedulaId;
	private String nombres;
	private String apellidos;
	private String correo;
	private String contraseña;
	private String direccion;
	private Date fechaNac;
	private String celular;
	private String titulo;
	private String especialidad;
	//foreing keys
	//relacion historia clinica medico
	@OneToOne
	@JoinColumn
	private HistoriaClinica id_historia_medico;
	public MedicoVeterinario() {
		super();
	}
	
	
	
	public MedicoVeterinario(int cedulaId, String nombres, String apellidos, String correo,String contraseña, String direccion,
			Date fechaNac, String celular, String titulo, String especialidad, HistoriaClinica id_historia_medico) {
		this.cedulaId = cedulaId;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.contraseña = contraseña;
		this.direccion = direccion;
		this.fechaNac = fechaNac;
		this.celular = celular;
		this.titulo = titulo;
		this.especialidad = especialidad;
		this.id_historia_medico = id_historia_medico;
	}



	public int getCedulaId() {
		return cedulaId;
	}
	public void setCedulaId(int cedulaId) {
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
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
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
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public HistoriaClinica getId_historia_medico() {
		return id_historia_medico;
	}
	public void setId_historia_medico(HistoriaClinica id_historia_medico) {
		this.id_historia_medico = id_historia_medico;
	}



	public String getContraseña() {
		return contraseña;
	}



	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
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
				+ ", correo=" + correo + ", contraseña=" + contraseña + ", direccion=" + direccion + ", fechaNac="
				+ fechaNac + ", celular=" + celular + ", titulo=" + titulo + ", especialidad=" + especialidad
				+ ", id_historia_medico=" + id_historia_medico + "]";
	}
	
	
   
}
