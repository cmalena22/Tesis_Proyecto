package ec.ups.edu.modelo;

import java.io.Serializable;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Timer;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: HsitoriaClinica
 *
 */
@Entity

public class HistoriaClinica implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHistorial;
	private Date diaDeAdminision;
	private LocalTime  hora;
	//Foreing Keys

	//relacion mascota - historia
	@OneToOne
	@JoinColumn
	private Mascota mascota_id; 
	
	//relacion historia medico	
	
	@ManyToOne
	@JoinColumn
	private MedicoVeterinario cedula_id;
	
	//relacion historia consulta	
	@OneToMany(mappedBy = "historia_Id")
	private Set<ConsultaMedica> listaConsultaMedica  = new HashSet<ConsultaMedica>();
	
	
	
	public HistoriaClinica() {
	}

	

	public HistoriaClinica(Date diaDeAdminision, LocalTime hora, Mascota mascota_id, MedicoVeterinario cedula_id) {
		super();
		this.diaDeAdminision = diaDeAdminision;
		this.hora = hora;
		this.mascota_id = mascota_id;
		this.cedula_id = cedula_id;
	}

	public HistoriaClinica(int idHistorial, Date diaDeAdminision, LocalTime hora, Mascota mascota_id, MedicoVeterinario cedula_id) {
		super();
		this.diaDeAdminision = diaDeAdminision;
		this.hora = hora;
		this.mascota_id = mascota_id;
		this.cedula_id = cedula_id;
		this.idHistorial=idHistorial;
	}
	

	public Set<ConsultaMedica> getListaConsultaMedica() {
		return listaConsultaMedica;
	}



	public void setListaConsultaMedica(Set<ConsultaMedica> listaConsultaMedica) {
		this.listaConsultaMedica = listaConsultaMedica;
	}



	public int getIdHistorial() {
		return idHistorial;
	}



	public void setIdHistorial(int idHistorial) {
		this.idHistorial = idHistorial;
	}



	public Date getDiaDeAdminision() {
		return diaDeAdminision;
	}



	public void setDiaDeAdminision(Date diaDeAdminision) {
		this.diaDeAdminision = diaDeAdminision;
	}



	public LocalTime getHora() {
		return hora;
	}



	public void setHora(LocalTime hora) {
		this.hora = hora;
	}



	public Mascota getMascota_id() {
		return mascota_id;
	}



	public void setMascota_id(Mascota mascota_id) {
		this.mascota_id = mascota_id;
	}



	public MedicoVeterinario getCedula_id() {
		return cedula_id;
	}



	public void setCedula_id(MedicoVeterinario cedula_id) {
		this.cedula_id = cedula_id;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idHistorial;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoriaClinica other = (HistoriaClinica) obj;
		if (idHistorial != other.idHistorial)
			return false;
		return true;
	}




	private static HistoriaClinica historia;
	private static Mascota mascota;
	private static MedicoVeterinario  medico;
	private static Especie especie;
	private static Raza raza;
	private static Especialidad especialidad;
	private static Usuario usuario;
	private static List<Especialidad> listEspecialidad= new ArrayList<Especialidad>();
	private static List<Usuario> listUsuario= new ArrayList<Usuario>();
	private static Propietario propietario;


	public static List<HistoriaClinica> serializeHistoriaClinica(List<HistoriaClinica> historias) {
		List<HistoriaClinica> historiaList = new ArrayList<>();
		listEspecialidad.forEach(e->{
			especialidad=new Especialidad(e.getEspecialidad_id(), e.getTipoEspecialidad());
		});
		listUsuario.forEach(e->{
			usuario=new Usuario(e.getUsuario_id(), e.getCorreo(), e.getContrasena(), e.getRol_id());
		});
		
		historias.forEach(
		e-> {		
			
			especie=new Especie(e.getMascota_id().getEspecie_id().getEspecie_id().getEspecie_id(), e.getMascota_id().getEspecie_id().getEspecie_id().getNombreEspecie());
			raza=new Raza(e.getMascota_id().getEspecie_id().getRaza_id(),e.getMascota_id().getEspecie_id().getNombre(), especie);

			propietario=new Propietario(e.getMascota_id().getId_mascota_propietario().getIdPropietario(),
					e.getMascota_id().getId_mascota_propietario().getDireccion(), e.getMascota_id().getId_mascota_propietario().getPropietario(), 
					e.getMascota_id().getId_mascota_propietario().getTelefono(),
					e.getMascota_id().getId_mascota_propietario().getCuidad(),e.getMascota_id().getId_mascota_propietario().getCorreo());

			
			mascota = new Mascota(e.getMascota_id().getNombre(),e.getMascota_id().getSexo(),
			e.getMascota_id().getFechaNac(),e.getMascota_id().getEdad(),e.getMascota_id().getColoYSenalesParti(),
			propietario,raza);
			
			
			medico =  new MedicoVeterinario(e.getCedula_id().getCedulaId(), e.getCedula_id().getNombres(),
			e.getCedula_id().getApellidos(),e.getCedula_id().getDireccion(),e.getCedula_id().getFechaNac(), 
			e.getCedula_id().getCelular(), e.getCedula_id().getTitulo(),especialidad,usuario);
			
			historia = new HistoriaClinica(e.getIdHistorial(),e.getDiaDeAdminision(), e.getHora(), mascota,medico);
			historiaList.add(historia);

		});
		return historiaList;

	}
	
	@Override
	public String toString() {
		return "HistoriaClinica [idHistorial=" + idHistorial + ", diaDeAdminision=" + diaDeAdminision + ", hora=" + hora
				+ ", mascota_id=" + mascota_id + ", cedula_id=" + cedula_id + "]";
	}








}
