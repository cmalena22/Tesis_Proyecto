package ec.ups.edu.modelo;

import java.io.Serializable;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPropietario;
	private String direccion;
	private String propietario;
	private String telefono;
	private String cuidad;
	
//foreing keys
	//relacion propietario mascota
	@OneToMany(mappedBy = "id_mascota_propietario")
	private Set<Mascota>listMascotas;
	
	
	
	private static final long serialVersionUID = 1L;

	public Propietario() {

	}

	public Propietario(int idPropietario, String direccion, String propietario, String telefono, String cuidad) {
		super();
		this.idPropietario = idPropietario;
		this.direccion = direccion;
		this.propietario = propietario;
		this.telefono = telefono;
		this.cuidad = cuidad;
	}

	public int getIdPropietario() {
		return idPropietario;
	}

	public void setIdPropietario(int idPropietario) {
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

	@Override
	public String toString() {
		return "Propietario [idPropietario=" + idPropietario + ", direccion=" + direccion + ", propietario="
				+ propietario + ", telefono=" + telefono + ", cuidad=" + cuidad + ", listMascotas=" + listMascotas
				+ "]";
	}
   
	
}
