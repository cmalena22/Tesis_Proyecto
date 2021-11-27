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
	private int cedulaId;
	private String nombres;
	private String apellidos;
	private String direccion;
	private Date fechaNac;
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
	
	

	public MedicoVeterinario(int cedulaId, String nombres, String apellidos, 
			String direccion, Date fechaNac, String celular, String titulo) {
		super();
		this.cedulaId = cedulaId;
		this.nombres = nombres;
		this.apellidos = apellidos;
		
		this.direccion = direccion;
		this.fechaNac = fechaNac;
		this.celular = celular;
		this.titulo = titulo;
	
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

	private static MedicoVeterinario medi;
	public static List<MedicoVeterinario> serializeMedicoVeterinario(List<MedicoVeterinario> medis) {
		List<MedicoVeterinario> productoList = new ArrayList<>();
		
     medis.forEach(
				e->{
					medi = new MedicoVeterinario(e.getCedulaId(),e.getNombres(),e.getApellidos(),e.getDireccion(),e.getFechaNac(),e.getCelular(),e.getTitulo());
					
				}
		);
		
		return productoList;
	}

	@Override
	public String toString() {
		return "MedicoVeterinario [cedulaId=" + cedulaId + ", nombres=" + nombres + ", apellidos=" + apellidos
				 + ", direccion=" + direccion + ", fechaNac="
				+ fechaNac + ", celular=" + celular + ", titulo=" + titulo 
				 + "]";
	}



	
	
	
   
}
