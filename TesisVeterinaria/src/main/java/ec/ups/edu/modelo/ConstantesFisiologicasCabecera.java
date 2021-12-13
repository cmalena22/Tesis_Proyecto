package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ConstantesFisiologicas
 *
 */
@Entity

public class ConstantesFisiologicasCabecera implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int constantes_idCab;
	private String nombre;
	
	//Constante cabecera a constante detalle
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "constantesidCab")
	private Set<ConstantesFisiologicasDetalle> constantesFisiologicaDetalle;
	
	

	public ConstantesFisiologicasCabecera() {
		
	}

	public ConstantesFisiologicasCabecera(int constantes_idCab, String nombre) {
		this.constantes_idCab = constantes_idCab;
		this.nombre = nombre;
	}

	public int getConstantes_idCab() {
		return constantes_idCab;
	}

	public void setConstantes_idCab(int constantes_idCab) {
		this.constantes_idCab = constantes_idCab;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<ConstantesFisiologicasDetalle> getConstantesFisiologicaDetalle() {
		return constantesFisiologicaDetalle;
	}

	public void setConstantesFisiologicaDetalle(Set<ConstantesFisiologicasDetalle> constantesFisiologicaDetalle) {
		this.constantesFisiologicaDetalle = constantesFisiologicaDetalle;
	}

	@Override
	public int hashCode() {
		return Objects.hash(constantes_idCab);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConstantesFisiologicasCabecera other = (ConstantesFisiologicasCabecera) obj;
		return constantes_idCab == other.constantes_idCab;
	}

	private static ConstantesFisiologicasCabecera constanteCab;

	public static List<ConstantesFisiologicasCabecera> serializeEspecie(List<ConstantesFisiologicasCabecera> constantesCab) {
		List<ConstantesFisiologicasCabecera> constantesList = new ArrayList<>();
		constantesCab.forEach(
		e-> {
			constanteCab = new ConstantesFisiologicasCabecera(e.getConstantes_idCab(),e.getNombre());
			constantesList.add(constanteCab);		
		});
		return constantesList;

	}
	
	@Override
	public String toString() {
		return "ConstantesFisiologicasCabecera [constantes_idCab=" + constantes_idCab + ", nombre=" + nombre + "]";
	}
	

	
}
