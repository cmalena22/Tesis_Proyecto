package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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


	public ConstantesFisiologicasDetalle( String valorAsignado,
			ConstantesFisiologicasCabecera constantesidCab, ConsultaMedica consulta_id) {
		super();
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

	private static ConstantesFisiologicasDetalle detalle;

	public static List<ConstantesFisiologicasDetalle> serializeConstantesFiosiologicasDetalle(List<ConstantesFisiologicasDetalle> detalles) {
		List<ConstantesFisiologicasDetalle> detallesList = new ArrayList<>();
		detalles.forEach(
		e-> {
			ConstantesFisiologicasCabecera cabecera = new ConstantesFisiologicasCabecera(e.getConstantesidCab().getConstantes_idCab(),e.getConstantesidCab().getNombre());
				ConsultaMedica consultaM = new ConsultaMedica( e.getConsulta_id().getMotivoConsulta(), e.getConsulta_id().getVacunacion(), e.getConsulta_id().getProducto(), e.getConsulta_id().getDesparacitacion(), e.getConsulta_id().getFechas(), e.getConsulta_id().getEstadoReproductivo(),
						e.getConsulta_id().getProcedencia(), e.getConsulta_id().getAnamnesis(), e.getConsulta_id().getDiagnostico(), e.getConsulta_id().getPronostico(), e.getConsulta_id().getTratamiento(), e.getConsulta_id().getObservaciones(),e.getConsulta_id().getHistoria_Id());

			detalle = new ConstantesFisiologicasDetalle(e.getValorAsignado(), cabecera,consultaM);
			detallesList.add(detalle);

		});
		return detallesList;

	}

	

	@Override
	public String toString() {
		return "ConstantesFisiologicasDetalle [constante_idDetalle=" + constante_idDetalle + ", valorAsignado="
				+ valorAsignado + ", constantesidCab=" + constantesidCab + ", consulta_id=" + consulta_id + "]";
	}
   
	
}
