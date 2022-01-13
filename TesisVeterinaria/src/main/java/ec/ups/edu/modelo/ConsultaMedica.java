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
 * Entity implementation class for Entity: ConsultaMedica
 *
 */
@Entity

public class ConsultaMedica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idConsultaMedica;
	private Date fechaConsulta;
	private String motivoConsulta;
	private String vacunacion; 
	private String producto;
	private String desparacitacion;
	private String fechas;
	private String estadoReproductivo;
	private String procedencia;
	private String anamnesis;
	private String diagnostico;
	private String pronostico;
	private String tratamiento;
	private String observaciones;
	//foreing Keys
	//relacion historia-consulta
	@ManyToOne
	@JoinColumn
	private HistoriaClinica historia_Id;
	
	
	
	//Relacion consulta- constante fisio detalle	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "consulta_id")
	private Set<ConstantesFisiologicasDetalle> constantesFiologicasDetalle  = new HashSet<ConstantesFisiologicasDetalle>();
	
	
		
	//Relacion receta consult amedica
	@OneToMany(mappedBy = "consulta_id")
	private Set<RecetaMedica> listreceta = new HashSet<RecetaMedica>();;
	
	
	public ConsultaMedica() { 
	}
	public ConsultaMedica(int idConsultaMedica) { 
		this.idConsultaMedica=idConsultaMedica;
	}




	public ConsultaMedica( String motivoConsulta, String vacunacion, String producto,
			String desparacitacion, String fechas, String estadoReproductivo, String procedencia, String anamnesis,
			String diagnostico, String pronostico, String tratamiento, String observaciones,
			HistoriaClinica historia_Id) {
		super();
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
		this.tratamiento = tratamiento;
		this.observaciones = observaciones;
		this.historia_Id = historia_Id;
	}
	public ConsultaMedica(int idConsultaMedica,Date fechaConsulta, String motivoConsulta, String vacunacion, String producto,
			String desparacitacion, String fechas, String estadoReproductivo, String procedencia, String anamnesis,
			String diagnostico, String pronostico, String tratamiento, String observaciones,
			HistoriaClinica historia_Id) {
		super();
		this.fechaConsulta=fechaConsulta;
		this.idConsultaMedica=idConsultaMedica;
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
		this.tratamiento = tratamiento;
		this.observaciones = observaciones;
		this.historia_Id = historia_Id;
		
	}
	
	

	public Date getFechaConsulta() {
		return fechaConsulta;
	}
	
	public void setFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
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


	public String getVacunacion() {
		return vacunacion;
	}


	public void setVacunacion(String vacunacion) {
		this.vacunacion = vacunacion;
	}


	public String getProducto() {
		return producto;
	}


	public void setProducto(String producto) {
		this.producto = producto;
	}


	public String getDesparacitacion() {
		return desparacitacion;
	}


	public void setDesparacitacion(String desparacitacion) {
		this.desparacitacion = desparacitacion;
	}


	public String getFechas() {
		return fechas;
	}


	public void setFechas(String fechas) {
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



	public HistoriaClinica getHistoria_Id() {
		return historia_Id;
	}
	public void setHistoria_Id(HistoriaClinica historia_Id) {
		this.historia_Id = historia_Id;
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
	
	


	public String getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
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
	
	private static ConsultaMedica consulta;
	private static HistoriaClinica historia;
	private static Mascota mascota;
	private static MedicoVeterinario medico;
	private static Raza raza;
	private static Propietario propietario;
	private static Especialidad especialidad;
	private static Usuario usuario;
	private static Especie especie;
	private static List<Especialidad> listEspecialidad= new ArrayList<Especialidad>();
	private static List<Raza> listraza= new ArrayList<Raza>();
	private static List<Propietario> listPropietario= new ArrayList<Propietario>();
	private static List<Usuario> listUsuario= new ArrayList<Usuario>();



	public static List<ConsultaMedica> serializeConsulta(List<ConsultaMedica> consultas) {
		List<ConsultaMedica> consultaList = new ArrayList<>();
		listPropietario.forEach(e->{
		});
		listEspecialidad.forEach(e->{
			especialidad=new Especialidad(e.getEspecialidad_id(), e.getTipoEspecialidad());
		});
		listUsuario.forEach(e->{
			usuario=new Usuario(e.getUsuario_id(), e.getCorreo(), e.getContrasena(), e.getRol_id());
		});
		listraza.forEach(e->{
		});
		consultas.forEach(
		e-> {
			propietario=new Propietario(e.getHistoria_Id().getMascota_id().getId_mascota_propietario().getIdPropietario(), e.getHistoria_Id().getMascota_id().getId_mascota_propietario().getDireccion(), e.getHistoria_Id().getMascota_id().getId_mascota_propietario().getPropietario(), e.getHistoria_Id().getMascota_id().getId_mascota_propietario().getTelefono(), e.getHistoria_Id().getMascota_id().getId_mascota_propietario().getCuidad(), e.getHistoria_Id().getMascota_id().getId_mascota_propietario().getCorreo());

			medico=new MedicoVeterinario(e.getHistoria_Id().getCedula_id().getCedulaId(), e.getHistoria_Id().getCedula_id().getNombres(), e.getHistoria_Id().getCedula_id().getApellidos(), e.getHistoria_Id().getCedula_id().getDireccion(), e.getHistoria_Id().getCedula_id().getFechaNac(), e.getHistoria_Id().getCedula_id().getCelular(), e.getHistoria_Id().getCedula_id().getTitulo(),e.getHistoria_Id().getCedula_id().getFotoMedico(),especialidad,usuario);
			especie=new Especie(e.getHistoria_Id().getMascota_id().getEspecie_id().getEspecie_id().getEspecie_id(), e.getHistoria_Id().getMascota_id().getEspecie_id().getEspecie_id().getNombreEspecie());
			raza=new Raza(e.getHistoria_Id().getMascota_id().getEspecie_id().getRaza_id(),e.getHistoria_Id().getMascota_id().getEspecie_id().getNombre() , especie);

			mascota=new Mascota(e.getHistoria_Id().getMascota_id().getId_mascota(), e.getHistoria_Id().getMascota_id().getNombre(), e.getHistoria_Id().getMascota_id().getSexo(), e.getHistoria_Id().getMascota_id().getFechaNac(), e.getHistoria_Id().getMascota_id().getEdad(), e.getHistoria_Id().getMascota_id().getColoYSenalesParti(), propietario,raza);

			historia = new HistoriaClinica(e.getHistoria_Id().getIdHistorial(),e.getHistoria_Id().getDiaDeAdminision(),e.getHistoria_Id().getHora(),mascota,medico);

			consulta = new ConsultaMedica(e.getIdConsultaMedica(),e.getFechaConsulta(), e.getMotivoConsulta(), e.getVacunacion(), e.getProducto(), e.getDesparacitacion(), e.getFechas(), e.getEstadoReproductivo(),
					e.getProcedencia(), e.getAnamnesis(), e.getDiagnostico(), e.getPronostico(), e.getTratamiento(), e.getObservaciones(), historia);
			consultaList.add(consulta);

		});
		return consultaList;

	}
	@Override
	public String toString() {
		return "ConsultaMedica [idConsultaMedica=" + idConsultaMedica + ", fechaConsulta=" + fechaConsulta
				+ ", motivoConsulta=" + motivoConsulta + ", vacunacion=" + vacunacion + ", producto=" + producto
				+ ", desparacitacion=" + desparacitacion + ", fechas=" + fechas + ", estadoReproductivo="
				+ estadoReproductivo + ", procedencia=" + procedencia + ", anamnesis=" + anamnesis + ", diagnostico="
				+ diagnostico + ", pronostico=" + pronostico + ", tratamiento=" + tratamiento + ", observaciones="
				+ observaciones + ", historia_Id=" + historia_Id + ", constantesFiologicasDetalle="
				+ constantesFiologicasDetalle + ", listreceta=" + listreceta + "]";
	}
	
	
	

	
   
}
