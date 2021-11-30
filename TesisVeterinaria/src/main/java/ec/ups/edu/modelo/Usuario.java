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
   
	
	
}
