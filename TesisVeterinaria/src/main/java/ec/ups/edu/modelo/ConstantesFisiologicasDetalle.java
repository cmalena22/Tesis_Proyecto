package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ConstantesFisiologicasDetalle
 *
 */
@Entity

public class ConstantesFisiologicasDetalle implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int constante_idDetalle;
	private String valorAsignado;
	
	//Relacion Contstante id cab constante detalle
	@ManyToOne
	@JoinColumn
	private ConstantesFisiologicasCabecera constantesidCab;

	
	//Relacion constantes detalles consulta medica
	@ManyToOne
	@JoinColumn
	private ConsultaMedica consulta_id;

	
	public ConstantesFisiologicasDetalle() {
		super();
	}


	public ConstantesFisiologicasDetalle(int constante_idDetalle, String valorAsignado,
			ConstantesFisiologicasCabecera constantesidCab, ConsultaMedica consulta_id) {
		super();
		this.constante_idDetalle = constante_idDetalle;
		this.valorAsignado = valorAsignado;
		this.constantesidCab = constantesidCab;
		this.consulta_id = consulta_id;
	}


	public int getConstante_idDetalle() {
		return constante_idDetalle;
	}


	public void setConstante_idDetalle(int constante_idDetalle) {
		this.constante_idDetalle = constante_idDetalle;
	}


	public String getValorAsignado() {
		return valorAsignado;
	}


	public void setValorAsignado(String valorAsignado) {
		this.valorAsignado = valorAsignado;
	}


	public ConstantesFisiologicasCabecera getConstantesidCab() {
		return constantesidCab;
	}


	public void setConstantesidCab(ConstantesFisiologicasCabecera constantesidCab) {
		this.constantesidCab = constantesidCab;
	}


	public ConsultaMedica getConsulta_id() {
		return consulta_id;
	}


	public void setConsulta_id(ConsultaMedica consulta_id) {
		this.consulta_id = consulta_id;
	}


	@Override
	public int hashCode() {
		return Objects.hash(constante_idDetalle);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConstantesFisiologicasDetalle other = (ConstantesFisiologicasDetalle) obj;
		return constante_idDetalle == other.constante_idDetalle;
	}


	@Override
	public String toString() {
		return "ConstantesFisiologicasDetalle [constante_idDetalle=" + constante_idDetalle + ", valorAsignado="
				+ valorAsignado + ", constantesidCab=" + constantesidCab + ", consulta_id=" + consulta_id + "]";
	}
   
	
}
