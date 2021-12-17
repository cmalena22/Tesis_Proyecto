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

	public ConstantesFisiologicasDetalle(int constante_idDetalle, String valorAsignado,
			ConstantesFisiologicasCabecera constantesidCab, ConsultaMedica consulta_id) {
		super();
		this.constante_idDetalle=constante_idDetalle;
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
	private static ConstantesFisiologicasCabecera cabecera;
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
	private static List<Usuario> listUsuario= new ArrayList<Usuario>();
public static List<ConstantesFisiologicasDetalle> serializeConstantesFiosiologicasDetalle(List<ConstantesFisiologicasDetalle> detalles) {
		List<ConstantesFisiologicasDetalle> detallesList = new ArrayList<>();		
	
		listEspecialidad.forEach(e->{
			especialidad=new Especialidad(e.getEspecialidad_id(), e.getTipoEspecialidad());
		});
		listUsuario.forEach(e->{
			usuario=new Usuario(e.getUsuario_id(), e.getCorreo(), e.getContrasena(), e.getRol_id());
		});
		detalles.forEach(
		e-> {
			propietario=new Propietario(e.getConsulta_id().getHistoria_Id().getMascota_id().getId_mascota_propietario().getIdPropietario(),
					e.getConsulta_id().getHistoria_Id().getMascota_id().getId_mascota_propietario().getDireccion(), e.getConsulta_id().getHistoria_Id().getMascota_id().getId_mascota_propietario().getPropietario(), 
					e.getConsulta_id().getHistoria_Id().getMascota_id().getId_mascota_propietario().getTelefono(),
					e.getConsulta_id().getHistoria_Id().getMascota_id().getId_mascota_propietario().getCuidad(), e.getConsulta_id().getHistoria_Id().getMascota_id().getId_mascota_propietario().getCorreo());

			medico=new MedicoVeterinario(e.getConsulta_id().getHistoria_Id().getCedula_id().getCedulaId(), e.getConsulta_id().getHistoria_Id().getCedula_id().getNombres(), e.getConsulta_id().getHistoria_Id().getCedula_id().getApellidos(), e.getConsulta_id().getHistoria_Id().getCedula_id().getDireccion(), e.getConsulta_id().getHistoria_Id().getCedula_id().getFechaNac(), e.getConsulta_id().getHistoria_Id().getCedula_id().getCelular(), e.getConsulta_id().getHistoria_Id().getCedula_id().getTitulo(),especialidad,usuario);
			especie=new Especie(e.getConsulta_id().getHistoria_Id().getMascota_id().getEspecie_id().getEspecie_id().getEspecie_id(), e.getConsulta_id().getHistoria_Id().getMascota_id().getEspecie_id().getEspecie_id().getNombreEspecie());
			raza=new Raza(e.getConsulta_id().getHistoria_Id().getMascota_id().getEspecie_id().getRaza_id(),e.getConsulta_id().getHistoria_Id().getMascota_id().getEspecie_id().getNombre() , especie);

			mascota=new Mascota(e.getConsulta_id().getHistoria_Id().getMascota_id().getId_mascota(), e.getConsulta_id().getHistoria_Id().getMascota_id().getNombre(), 
					e.getConsulta_id().getHistoria_Id().getMascota_id().getSexo(), e.getConsulta_id().getHistoria_Id().getMascota_id().getFechaNac(), e.getConsulta_id().getHistoria_Id().getMascota_id().getEdad(), 
					e.getConsulta_id().getHistoria_Id().getMascota_id().getColoYSenalesParti(), propietario,raza);

			historia = new HistoriaClinica(e.getConsulta_id().getHistoria_Id().getIdHistorial(),e.getConsulta_id().getHistoria_Id().getDiaDeAdminision(),e.getConsulta_id().getHistoria_Id().getHora(),mascota,medico);

			consulta= new ConsultaMedica( e.getConsulta_id().getIdConsultaMedica() ,e.getConsulta_id().getMotivoConsulta(),e.getConsulta_id().getVacunacion(),e.getConsulta_id().getProducto(),e.getConsulta_id().getDesparacitacion(),e.getConsulta_id().getFechas(),
					e.getConsulta_id().getEstadoReproductivo(),e.getConsulta_id().getProcedencia(),e.getConsulta_id().getAnamnesis(),e.getConsulta_id().getDiagnostico(),e.getConsulta_id().getPronostico(),e.getConsulta_id().getTratamiento(),e.getConsulta_id().getObservaciones(),historia);
			cabecera= new ConstantesFisiologicasCabecera(e.getConstantesidCab().getConstantes_idCab(),e.getConstantesidCab().getNombre());
			detalle = new ConstantesFisiologicasDetalle(e.getConstante_idDetalle(),e.getValorAsignado(), cabecera,consulta);
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
