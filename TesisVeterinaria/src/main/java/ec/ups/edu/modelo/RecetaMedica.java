package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: RecetaMedica
 *
 */
@Entity

public class RecetaMedica implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReceta;
	private Date fecha;
	private String rp;
	private String prescripcion;
	private static final long serialVersionUID = 1L;
//foreing keys
	
	//relacon consulta medica receta
	@ManyToOne
	@JoinColumn
	private ConsultaMedica consulta_id;
	
	public RecetaMedica() {
	}

	public RecetaMedica(int idReceta, Date fecha, String rp, String prescripcion, ConsultaMedica consulta_id) {
		super();
		this.idReceta = idReceta;
		this.fecha = fecha;
		this.rp = rp;
		this.prescripcion = prescripcion;
		this.consulta_id = consulta_id;
	}

	public int getIdReceta() {
		return idReceta;
	}

	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getRp() {
		return rp;
	}

	public void setRp(String rp) {
		this.rp = rp;
	}

	public String getPrescripcion() {
		return prescripcion;
	}

	public void setPrescripcion(String prescripcion) {
		this.prescripcion = prescripcion;
	}

	public ConsultaMedica getConsulta_id() {
		return consulta_id;
	}

	public void setConsulta_id(ConsultaMedica consulta_id) {
		this.consulta_id = consulta_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idReceta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecetaMedica other = (RecetaMedica) obj;
		return idReceta == other.idReceta;
	}

	@Override
	public String toString() {
		return "RecetaMedica [idReceta=" + idReceta + ", fecha=" + fecha + ", rp=" + rp + ", prescripcion="
				+ prescripcion + ", consulta_id=" + consulta_id + "]";
	}
	
	
	private static ConsultaMedica consulta;
	private static RecetaMedica receta;
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

	
	public static List<RecetaMedica> serializeReceta(List<RecetaMedica> recetas) {
		List<RecetaMedica> recetaList = new ArrayList<>();
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
		recetas.forEach(
		e-> {
			
			propietario=new Propietario(e.getConsulta_id().getHistoria_Id().getMascota_id().getId_mascota_propietario().getIdPropietario(), e.getConsulta_id().getHistoria_Id().
					getMascota_id().getId_mascota_propietario().getDireccion(), e.getConsulta_id().getHistoria_Id().getMascota_id().getId_mascota_propietario().getPropietario(),
					 e.getConsulta_id().getHistoria_Id().getMascota_id().getId_mascota_propietario().getTelefono(),
					  e.getConsulta_id().getHistoria_Id().getMascota_id().getId_mascota_propietario().getCuidad(), e.getConsulta_id().getHistoria_Id().getMascota_id().getId_mascota_propietario().getCorreo());

			
			medico=new MedicoVeterinario(e.getConsulta_id().getHistoria_Id().getCedula_id().getCedulaId(), e.getConsulta_id().getHistoria_Id().getCedula_id().getNombres(),
					 e.getConsulta_id().getHistoria_Id().getCedula_id().getApellidos(), e.getConsulta_id().getHistoria_Id().getCedula_id().getDireccion(), e.getConsulta_id().getHistoria_Id().getCedula_id().getFechaNac(),
					  e.getConsulta_id().getHistoria_Id().getCedula_id().getCelular(), e.getConsulta_id().getHistoria_Id().getCedula_id().getTitulo(), e.getConsulta_id().getHistoria_Id().getCedula_id().getFotoMedico(),especialidad,usuario);
			
			especie=new Especie(e.getConsulta_id().getHistoria_Id().getMascota_id().getEspecie_id().getEspecie_id().getEspecie_id(),
					 e.getConsulta_id().getHistoria_Id().getMascota_id().getEspecie_id().getEspecie_id().getNombreEspecie());
			
			raza=new Raza(e.getConsulta_id().getHistoria_Id().getMascota_id().getEspecie_id().getRaza_id(),e.getConsulta_id().getHistoria_Id().getMascota_id().getEspecie_id().getNombre() , especie);

			
			mascota=new Mascota(e.getConsulta_id().getHistoria_Id().getMascota_id().getId_mascota(), e.getConsulta_id().getHistoria_Id().getMascota_id().getNombre(),
					 e.getConsulta_id().getHistoria_Id().getMascota_id().getSexo(), e.getConsulta_id().getHistoria_Id().getMascota_id().getFechaNac(), e.getConsulta_id().getHistoria_Id().getMascota_id().getEdad(), 
					 e.getConsulta_id().getHistoria_Id().getMascota_id().getColoYSenalesParti(), propietario,raza);
			
			historia = new HistoriaClinica(e.getConsulta_id().getHistoria_Id().getIdHistorial(),e.getConsulta_id().getHistoria_Id().getDiaDeAdminision(),e.getConsulta_id().getHistoria_Id().getHora(),mascota,medico);

			consulta = new ConsultaMedica(e.getConsulta_id().getIdConsultaMedica(),e.getConsulta_id().getFechaConsulta(),e.getConsulta_id().getMotivoConsulta(), e.getConsulta_id().getVacunacion(), e.getConsulta_id().getProducto(), e.getConsulta_id().getDesparacitacion(), e.getConsulta_id().getFechas(), e.getConsulta_id().getEstadoReproductivo(),
					e.getConsulta_id().getProcedencia(), e.getConsulta_id().getAnamnesis(), e.getConsulta_id().getDiagnostico(), e.getConsulta_id().getPronostico(), e.getConsulta_id().getTratamiento(), e.getConsulta_id().getObservaciones(), historia);
			receta = new RecetaMedica(e.getIdReceta(),e.getFecha(),e.getRp(),e.getPrescripcion(),consulta);
			recetaList.add(receta);
		});
		return recetaList;

	}
}
