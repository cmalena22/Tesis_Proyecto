package ec.ups.edu.modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.List;
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
	@ManyToOne
	@JoinColumn
	private Rol rol_id;
	
	//Relacion Usuario Medico
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario_id")
	private Set<MedicoVeterinario> medicoVeterinario  = new HashSet<MedicoVeterinario>();
	
	
	
	public Usuario() {
		
	}
	
	

	public Usuario(int usuario_id, String correo, String contrasena, Rol rol_id) {
		super();
		this.usuario_id = usuario_id;
		this.correo = correo;
		this.contrasena = contrasena;
		this.rol_id = rol_id;
		this.medicoVeterinario=medicoVeterinario;
		
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



	public Set<MedicoVeterinario> getMedicoVeterinario() {
		return medicoVeterinario;
	}



	public void setMedicoVeterinario(Set<MedicoVeterinario> medicoVeterinario) {
		this.medicoVeterinario = medicoVeterinario;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rol_id == null) ? 0 : rol_id.hashCode());
		return result;
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
		if (rol_id == null) {
			if (other.rol_id != null)
				return false;
		} else if (!rol_id.equals(other.rol_id))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Usuario [usuario_id=" + usuario_id + ", correo=" + correo + ", contrasena=" + contrasena + ", rol_id="
				+ rol_id + "]";
	}
   
	public static String md5(String input) {
		String md5 = null;
		if(null == input) return null;
		try {
			//Create MessageDigest object for MD5
			MessageDigest digest = MessageDigest.getInstance("MD5");
			//Update input string in message digest
			digest.update(input.getBytes(), 0, input.length());
			//Converts message digest value in base 16 (hex) 
			md5 = new BigInteger(1, digest.digest()).toString(16);
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return md5;
	}
	
}
