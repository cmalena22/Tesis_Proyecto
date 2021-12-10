package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity

public class Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int usuario_id;
	private String correo;
	private String contrasena;
	
	//Relacion usuario rol
	@OneToOne
	@JoinColumn
	private Rol rol_id;
	
	//Relacion Usuario Medico

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario_id")
	private MedicoVeterinario medicoVeterinario;
	
	
	
	public Usuario() {
		
	}
	
	

	public Usuario(int usuario_id, String correo, String contrasena, Rol rol_id) {
		super();
		this.usuario_id = usuario_id;
		this.correo = correo;
		this.contrasena = contrasena;
		this.rol_id = rol_id;
		
	}



	public int getUsuario_id() {
		return usuario_id;
	}



	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public String getContrasena() {
		return contrasena;
	}



	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}



	public Rol getRol_id() {
		return rol_id;
	}



	public void setRol_id(Rol rol_id) {
		this.rol_id = rol_id;
	}



	public MedicoVeterinario getMedicoVeterinario() {
		return medicoVeterinario;
	}



	public void setMedicoVeterinario(MedicoVeterinario medicoVeterinario) {
		this.medicoVeterinario = medicoVeterinario;
	}



	@Override
	public int hashCode() {
		return Objects.hash(usuario_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return usuario_id == other.usuario_id;
	}



	@Override
	public String toString() {
		return "Usuario [usuario_id=" + usuario_id + ", correo=" + correo + ", contrasena=" + contrasena + ", rol_id="
				+ rol_id + "]";
	}
   
	
	
}
