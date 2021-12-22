package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Propietario
 *
 */
@Entity

public class Propietario implements Serializable {

	@Id
	private String idPropietario;
	private String direccion;
	private String propietario;
	private String telefono;
	private String cuidad;
	private String correo;
	
	//foreing keys
	//relacion propietario mascota
	@OneToMany(mappedBy = "id_mascota_propietario")
	private Set<Mascota>listMascotas;
	
	
	
	private static final long serialVersionUID = 1L;

	public Propietario() {

	}

	public Propietario(String idPropietario, String direccion, String propietario, String telefono, String cuidad, String correo) {
		super();
		this.idPropietario = idPropietario;
		this.direccion = direccion;
		this.propietario = propietario;
		this.telefono = telefono;
		this.cuidad = cuidad;
		this.correo=correo;
	}

	
	
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getIdPropietario() {
		return idPropietario;
	}

	public void setIdPropietario(String idPropietario) {
		this.idPropietario = idPropietario;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCuidad() {
		return cuidad;
	}

	public void setCuidad(String cuidad) {
		this.cuidad = cuidad;
	}

	public Set<Mascota> getListMascotas() {
		return listMascotas;
	}

	public void setListMascotas(Set<Mascota> listMascotas) {
		this.listMascotas = listMascotas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPropietario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Propietario other = (Propietario) obj;
		return idPropietario == other.idPropietario;
	}
	
	private static Propietario propie;

	public static List<Propietario> serializePropietario(List<Propietario> propietarios) {
		List<Propietario> propietarioList = new ArrayList<>();
		propietarios.forEach(
		e-> {
			
			propie = new Propietario(e.getIdPropietario(), e.getDireccion(), e.getPropietario(), e.getTelefono(), e.getCuidad(), e.getCorreo());
			
			propietarioList.add(propie);

		});
		return propietarioList;

	}
	
	private static Propietario propiebyId;

	public static Propietario serializePropietarioByID(Propietario propietario) {
		Propietario prop = new Propietario();
		
			
			propiebyId = new Propietario(propietario.getIdPropietario(), propietario.getDireccion(), propietario.getPropietario(), propietario.getTelefono(), propietario.getCuidad(), propietario.getCorreo());
			
		
		return propiebyId;

	}


	@Override
	public String toString() {
		return "Propietario [idPropietario=" + idPropietario + ", direccion=" + direccion + ", propietario="
				+ propietario + ", telefono=" + telefono + ", cuidad=" + cuidad + ", correo=" + correo
				+  "]";
	}

	
   
	
}
