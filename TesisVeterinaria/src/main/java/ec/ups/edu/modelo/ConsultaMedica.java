package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ConsultaMedica
 *
 */
@Entity

public class ConsultaMedica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idConsultaMedica;
	private String motivoConsulta;
	private char vacunacion; 
	private String producto;
	private char desparacitacion;
	private Date fechas;
	private String estadoReproductivo;
	private String procedencia;
	private String anamnesis;
	private String diagnostico;
	private String pronostico;
	private String observaciones;
	//foreing Keys
	//relacion historia-consulta
	
	@OneToMany(mappedBy = "consulta_id")
	private Set<HistoriaClinica> listaConsultaMedica;
	
	//Relacion consulta- constante fisio detalle	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "consulta_id")
	private Set<ConstantesFisiologicasDetalle> constantesFiologicasDetalle;
	
	
		
	//Relacion receta consult amedica
	@OneToMany(mappedBy = "consulta_id")
	private Set<RecetaMedica> listreceta;
	
	
	public ConsultaMedica() { 
	}


	public ConsultaMedica(int idConsultaMedica, String motivoConsulta, char vacunacion, String producto,
			char desparacitacion, Date fechas, String estadoReproductivo, String procedencia, String anamnesis,
			String diagnostico, String pronostico, String observaciones) {
		super();
		this.idConsultaMedica = idConsultaMedica;
		this.motivoConsulta = motivoConsulta;
		this.vacunacion = vacunacion;
		this.producto = producto;
		this.desparacitacion = desparacitacion;
		this.fechas = fechas;
		this.estadoReproductivo = estadoReproductivo;
		this.procedencia = procedencia;
		this.anamnesis = anamnesis;
		this.diagnostico = diagnostico;
		this.pronostico = pronostico;
		this.observaciones = observaciones;
	}


	public int getIdConsultaMedica() {
		return idConsultaMedica;
	}


	public void setIdConsultaMedica(int idConsultaMedica) {
		this.idConsultaMedica = idConsultaMedica;
	}


	public String getMotivoConsulta() {
		return motivoConsulta;
	}


	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}


	public char getVacunacion() {
		return vacunacion;
	}


	public void setVacunacion(char vacunacion) {
		this.vacunacion = vacunacion;
	}


	public String getProducto() {
		return producto;
	}


	public void setProducto(String producto) {
		this.producto = producto;
	}


	public char getDesparacitacion() {
		return desparacitacion;
	}


	public void setDesparacitacion(char desparacitacion) {
		this.desparacitacion = desparacitacion;
	}


	public Date getFechas() {
		return fechas;
	}


	public void setFechas(Date fechas) {
		this.fechas = fechas;
	}


	public String getEstadoReproductivo() {
		return estadoReproductivo;
	}


	public void setEstadoReproductivo(String estadoReproductivo) {
		this.estadoReproductivo = estadoReproductivo;
	}


	public String getProcedencia() {
		return procedencia;
	}


	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}


	public String getAnamnesis() {
		return anamnesis;
	}


	public void setAnamnesis(String anamnesis) {
		this.anamnesis = anamnesis;
	}


	public String getDiagnostico() {
		return diagnostico;
	}


	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}


	public String getPronostico() {
		return pronostico;
	}


	public void setPronostico(String pronostico) {
		this.pronostico = pronostico;
	}


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	public Set<HistoriaClinica> getListaConsultaMedica() {
		return listaConsultaMedica;
	}


	public void setListaConsultaMedica(Set<HistoriaClinica> listaConsultaMedica) {
		this.listaConsultaMedica = listaConsultaMedica;
	}


	public Set<ConstantesFisiologicasDetalle> getConstantesFiologicasDetalle() {
		return constantesFiologicasDetalle;
	}


	public void setConstantesFiologicasDetalle(Set<ConstantesFisiologicasDetalle> constantesFiologicasDetalle) {
		this.constantesFiologicasDetalle = constantesFiologicasDetalle;
	}


	public Set<RecetaMedica> getListreceta() {
		return listreceta;
	}


	public void setListreceta(Set<RecetaMedica> listreceta) {
		this.listreceta = listreceta;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idConsultaMedica);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultaMedica other = (ConsultaMedica) obj;
		return idConsultaMedica == other.idConsultaMedica;
	}


	@Override
	public String toString() {
		return "ConsultaMedica [idConsultaMedica=" + idConsultaMedica + ", motivoConsulta=" + motivoConsulta
				+ ", vacunacion=" + vacunacion + ", producto=" + producto + ", desparacitacion=" + desparacitacion
				+ ", fechas=" + fechas + ", estadoReproductivo=" + estadoReproductivo + ", procedencia=" + procedencia
				+ ", anamnesis=" + anamnesis + ", diagnostico=" + diagnostico + ", pronostico=" + pronostico
				+ ", observaciones=" + observaciones + ", listaConsultaMedica=" + listaConsultaMedica
				+ ", constantesFiologicasDetalle=" + constantesFiologicasDetalle + ", listreceta=" + listreceta + "]";
	}

	

	
   
}
