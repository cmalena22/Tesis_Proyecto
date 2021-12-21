package ec.ups.edu.rest;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import ec.ups.edu.ejb.ConstantesFisiologicasCabeceraFacade;
import ec.ups.edu.ejb.ConstantesFisiologicasDetalleFacade;
import ec.ups.edu.ejb.ConsultaMedicaFacade;
import ec.ups.edu.ejb.EspecialidadFacade;
import ec.ups.edu.ejb.EspecieFacade;
import ec.ups.edu.ejb.HistoriaClinicaFacade;
import ec.ups.edu.ejb.MascotaFacade;
import ec.ups.edu.ejb.MedicoVeterinarioFacade;
import ec.ups.edu.ejb.PropietarioFacade;
import ec.ups.edu.ejb.RazaFacade;
import ec.ups.edu.ejb.Roww;
import ec.ups.edu.modelo.ConstantesFisiologicasCabecera;
import ec.ups.edu.modelo.ConstantesFisiologicasDetalle;
import ec.ups.edu.modelo.ConsultaMedica;
import ec.ups.edu.ejb.UsuarioFacade;
import ec.ups.edu.modelo.Especialidad;
import ec.ups.edu.modelo.Especie;

import ec.ups.edu.modelo.Mail;

import ec.ups.edu.modelo.HistoriaClinica;

import ec.ups.edu.modelo.Mascota;
import ec.ups.edu.modelo.MedicoVeterinario;
import ec.ups.edu.modelo.Propietario;
import ec.ups.edu.modelo.Raza;
import ec.ups.edu.modelo.Rol;
import ec.ups.edu.modelo.Usuario;

@Path("/prueba")
public class ApiRest {

	private List<Roww> list;
	private ConsultaMedica consultaM;
	private HistoriaClinica historiaC;
	
	
	@EJB
	private MedicoVeterinarioFacade ejbMedicoVeterinarioFacade;
	@EJB
	private PropietarioFacade ejbPropietarioFacade;
	@EJB
	private MascotaFacade ejbMascotaFacade;
	@EJB
	private RazaFacade ejbRazaFacade;
	@EJB
	private EspecieFacade ejbEspecieFacade;
	@EJB
	private ConstantesFisiologicasCabeceraFacade ejbConstantesCabecera;
	@EJB
	private ConstantesFisiologicasDetalleFacade ejbConstanteDetalle;
	@EJB
	private EspecialidadFacade ejbEspecialidadFacade;
	@EJB
	private UsuarioFacade ejbUsuarioFacade;
	@EJB
	private HistoriaClinicaFacade ejbHistoriaClinicaFacade;

	@EJB
	private ConsultaMedicaFacade ejbConsultaMedica;

	public ApiRest() {
		this.list = new ArrayList<Roww>();
		this.consultaM = new ConsultaMedica();
		this.historiaC= new HistoriaClinica();
	}

	@POST
	@Path("/inicio")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response inicio(@FormParam("correo") String correo, @FormParam("contrasena") String contrasena,
			@FormParam("otra") String hsdg) throws IOException {
		System.out.println("Metodo crear");
		Usuario us = new Usuario();
		System.out.println("Correo " + correo);
		System.out.println("Contrasena " + contrasena);
		MedicoVeterinario usu = new MedicoVeterinario();
		// MedicoVeterinario usu = new MedicoVeterinario();

		try {
			// us = ejbMedicoVeterinarioFacade.inicioo();
			us = ejbUsuarioFacade.inicioo(correo, contrasena);
			if (us != null) {
				return Response.ok(correo).build();

				// .header("Access-Control-Allow-Origin", "*")
				// .header("Access-Control-Allow-Headers", "origin, content-type, accept,
				// authorization")
				// .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();

			}
		} catch (Exception ex) {
			return Response.ok("No creado").build();

		}
		return Response.ok("No creado").build();
	}

	@GET
	@Path("/holamundo")
	@Produces("text/html")
	public String getHtml() {
		return "Hola Mundo!!";
	}

	@POST
	@Path("/registrarPropietario")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)

	public Response Prueba(@FormParam("cedula") String cedula, @FormParam("nombrepropietario") String nombrepropietario,
			@FormParam("ciudad") String ciudad, @FormParam("direccion") String direccion,
			@FormParam("telefono") String telefono, @FormParam("correo") String correo) {

		System.out.println("Ingreso");
		Propietario propietario = new Propietario();
		propietario.setIdPropietario(cedula);
		propietario.setPropietario(nombrepropietario);
		propietario.setCuidad(ciudad);
		propietario.setDireccion(direccion);
		propietario.setTelefono(telefono);
		propietario.setCorreo(correo);
		System.out.println(propietario.toString());
		try {
			ejbPropietarioFacade.create(propietario);
			return Response.ok("Creado desde tesis veterinaria").header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		} catch (Exception e) {
			// TODO: handle exception
			return Response.ok("Error").header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		}
	}

	@POST
	@Path("/registrarMascota")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response RegistrarMascota(@FormParam("idPro") String idPro, @FormParam("nombre") String nombre,
			@FormParam("especie") String especie, @FormParam("raza") String raza, @FormParam("sexo") String sexo,
			@FormParam("fechaNac") String fechaNac, @FormParam("edad") String edad,
			@FormParam("coloYSenalesParti") String coloYSenalesParti) {
		System.out.println(idPro + "=" + nombre + "=" + especie + "=" + raza + "=" + sexo + "=" + fechaNac + "=" + edad
				+ "=" + coloYSenalesParti);
		System.out.println("Ingreso");
		Jsonb jsonb = JsonbBuilder.create();
		Propietario propietario = new Propietario();
		propietario = ejbPropietarioFacade.buscarCedula(idPro);
		System.out.println(propietario.toString());
		Raza razaV = new Raza();
		razaV = ejbRazaFacade.buscarId(raza);
		System.out.println(razaV.toString());
		Mascota mascota = new Mascota();
		mascota.setNombre(nombre);
		mascota.setSexo(sexo);
		mascota.setFechaNac(fechaNac);
		mascota.setEdad(edad);
		mascota.setColoYSenalesParti(coloYSenalesParti);
		mascota.setId_mascota_propietario(propietario);
		mascota.setRaza_id(razaV);
		System.out.println("Mascota final" + mascota.toString());
		ejbMascotaFacade.create(mascota);
		return Response.ok(mascota.getId_mascota()).build();
		// .header("Access-Control-Allow-Headers", "origin, content-type, accept,
		// authorization")
	}

	@GET
	@Path("/obtenerRazaByEspecie/{idEspecie}")	
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerRazaByEspecie(@PathParam("idEspecie") String idEspecie) {
		System.out.println("Especie mascota");
		Jsonb jsonb = JsonbBuilder.create();
		Raza raza= new Raza();
		List<Raza> listaRaza = new ArrayList<Raza>();
		
		try {
			listaRaza = Raza.serializeRaza(ejbRazaFacade.obtenerRazaByEspecie(idEspecie));
			System.out.println("Raza" + listaRaza);
			// ejbPropietarioFacade.create(propietario);
			return Response.ok(jsonb.toJson(listaRaza)).header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		} catch (Exception e) {
			// TODO: handle exception
			return Response.ok("Error").header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Header", "*")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		}
	}
	@GET
	@Path("/obtenerEspecieMascota")
	@Produces(MediaType.APPLICATION_JSON)

	public Response obtenerEspecieMascota() {

		System.out.println("Especie mascota");
		Jsonb jsonb = JsonbBuilder.create();
		List<Especie> listaEspecie = new ArrayList<Especie>();

		try {
			listaEspecie = Especie.serializeEspecie(ejbEspecieFacade.findAll());
			System.out.println("Raza" + listaEspecie);
			// ejbPropietarioFacade.create(propietario);
			return Response.ok(jsonb.toJson(listaEspecie)).header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		} catch (Exception e) {
			// TODO: handle exception
			return Response.ok("Error").header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		}
	}

	@GET
	@Path("/obtenerConstantesCabecera")
	@Produces(MediaType.APPLICATION_JSON)

	public Response obtenerConstantesCabeceras() {

		System.out.println("Constantes Cabecera mascota");
		Jsonb jsonb = JsonbBuilder.create();
		List<ConstantesFisiologicasCabecera> listaConstantesCab = new ArrayList<ConstantesFisiologicasCabecera>();

		try {
			listaConstantesCab = ConstantesFisiologicasCabecera.serializeEspecie(ejbConstantesCabecera.findAll());
			System.out.println("Raza" + listaConstantesCab);
			// ejbPropietarioFacade.create(propietario);
			return Response.ok(jsonb.toJson(listaConstantesCab)).header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		} catch (Exception e) {
			// TODO: handle exception
			return Response.ok("Error").header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		}
	}
	
	private static int idConsultaMedica;
	@POST
	@Path("/registrarConsultaMedica")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)

	public Response registrarConsulta(@FormParam("motivoConsulta") String motivoConsulta,
			@FormParam("vacunacion") String vacunacion, @FormParam("desparacitacion") String desparacitacion,
			@FormParam("estadoR") String estadoR, @FormParam("producto") String producto,
			@FormParam("fecha") String fecha, @FormParam("procedencia") String procedencia,
			@FormParam("anamnesis") String anamnesis, @FormParam("diagnostico") String diagnostico,
			@FormParam("pronostico") String pronostico, @FormParam("tratamiento") String tratamiento,
			@FormParam("observaciones") String observaciones, @FormParam("idMascota") String idMascota,
			@FormParam("medico") String medico) {
			System.out.println("__________--------------------------------------- registrar consulta medica");
		// Historia Clinica
				// Se obtiene la Fecha
				LocalTime time = LocalTime.now();
				Date date = new Date();
				// mASCOTA
				System.out.println("id mascota recuperado" + idMascota);
				Mascota mascota = new Mascota();
				mascota = ejbMascotaFacade.find(Integer.parseInt(idMascota));
				System.out.println("Mascota recuperada" + mascota.toString());
				// medico
				//System.out.println("Id dentro de consta fisio de medico" + medico);
				Usuario usu = new Usuario();
				MedicoVeterinario medi= new MedicoVeterinario();
				ejbUsuarioFacade.idusuario(medico);
				System.out.println(ejbUsuarioFacade.idusuario(medico));				
				System.out.println("--------------------------------------");				 
				medi = ejbMedicoVeterinarioFacade.buscarcorreoV(ejbUsuarioFacade.idusuario(medico));
				System.out.println("medico recuperado"+medi.getNombres());
				// Crear historiaa
				System.out.println("Historiaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				HistoriaClinica historia= new HistoriaClinica();
				historia.setDiaDeAdminision(date);
				historia.setHora(time);
				historia.setMascota_id(mascota);
				historia.setCedula_id(medi);
				System.out.println(historia.getDiaDeAdminision());
				ejbHistoriaClinicaFacade.create(historia);
				//HistoriaClinica hC= ejbHistoriaClinicaFacade.buscarId(historia.getIdHistorial());
				System.out.println("recuperadooooo historia clinica==============="+historia.getIdHistorial());
				HistoriaClinica h = new HistoriaClinica();
				h=ejbHistoriaClinicaFacade.find(historia.getIdHistorial());
				System.out.println("HHHHHHHHHHHHHHHHH"+h.getIdHistorial());
		//aqui
		ConsultaMedica consultaMedica = new ConsultaMedica();
		consultaMedica.setMotivoConsulta(motivoConsulta);
		consultaMedica.setVacunacion(vacunacion);
		consultaMedica.setDesparacitacion(desparacitacion);
		consultaMedica.setEstadoReproductivo(estadoR);
		consultaMedica.setProducto(producto);
		consultaMedica.setFechas(fecha);
		consultaMedica.setProcedencia(procedencia);
		consultaMedica.setAnamnesis(anamnesis);
		consultaMedica.setDiagnostico(diagnostico);
		consultaMedica.setPronostico(pronostico);
		consultaMedica.setTratamiento(tratamiento);
		consultaMedica.setObservaciones(observaciones);
		consultaMedica.setHistoria_Id(h);
		consultaMedica.setFechaConsulta(date);
		ejbConsultaMedica.create(consultaMedica);
		//ConsultaMedica c = new ConsultaMedica();
		consultaM=ejbConsultaMedica.find(consultaMedica.getIdConsultaMedica());
		System.out.println("Cccccccccccccccccc"+consultaM.getIdConsultaMedica());
		//consultaM = ejbConsultaMedica.find(consultaMedica.getIdConsultaMedica());
		idConsultaMedica = consultaM.getIdConsultaMedica();
		
		System.out.println(idConsultaMedica);
		System.out.println("estamos rn registras consulta medica");
		System.out.println("Ingreso");
		System.out.println("motivo" + motivoConsulta);
		System.out.println("vacunacion" + vacunacion);
		System.out.println("desparacitavion" + desparacitacion);
		System.out.println("Estado Repro" + estadoR);
		System.out.println("producto" + producto);
		System.out.println("fecha" + fecha);
		System.out.println("procedencia" + procedencia);
		System.out.println("anamnesis" + anamnesis);
		System.out.println("diagnosstico" + diagnostico);
		System.out.println("pronostico" + pronostico);
		System.out.println("tratamiento" + tratamiento);
		System.out.println("observaciones" + observaciones);
		System.out.println("idMascota" + idMascota);
		System.out.println("medico correo" + medico);
		try {
			// ejbPropietarioFacade.create(propietario);
			return Response.ok(String.valueOf( consultaMedica.getIdConsultaMedica())).header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		} catch (Exception e) {
			// TODO: handle exception
			return Response.ok("Error").header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		}
	}
	

	//private static int idConsultaMedica;
	@POST
	@Path("/registrarConsultaMedicaByHistoria")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response registrarConsultaMedicaByHistoria(@FormParam("motivoConsulta") String motivoConsulta,
			@FormParam("vacunacion") String vacunacion, @FormParam("desparacitacion") String desparacitacion,
			@FormParam("estadoR") String estadoR, @FormParam("producto") String producto,
			@FormParam("fecha") String fecha, @FormParam("procedencia") String procedencia,
			@FormParam("anamnesis") String anamnesis, @FormParam("diagnostico") String diagnostico,
			@FormParam("pronostico") String pronostico, @FormParam("tratamiento") String tratamiento,
			@FormParam("observaciones") String observaciones,@FormParam("idMascota") String idMascota) {
			System.out.println("__________--------------------------------------- registrar consulta medica2");
		// Historia Clinica
				// Se obtiene la Fecha
				LocalTime time = LocalTime.now();
				Date date = new Date();
				HistoriaClinica h = new HistoriaClinica();
				h=ejbHistoriaClinicaFacade.find(Integer.parseInt(idMascota));
				System.out.println("Historia recu" + h.getIdHistorial());
				
				

		//aqui
		ConsultaMedica consultaMedica = new ConsultaMedica();
		consultaMedica.setMotivoConsulta(motivoConsulta);
		consultaMedica.setVacunacion(vacunacion);
		consultaMedica.setDesparacitacion(desparacitacion);
		consultaMedica.setEstadoReproductivo(estadoR);
		consultaMedica.setProducto(producto);
		consultaMedica.setFechas(fecha);
		consultaMedica.setProcedencia(procedencia);
		consultaMedica.setAnamnesis(anamnesis);
		consultaMedica.setDiagnostico(diagnostico);
		consultaMedica.setPronostico(pronostico);
		consultaMedica.setTratamiento(tratamiento);
		consultaMedica.setObservaciones(observaciones);
		consultaMedica.setHistoria_Id(h);
		consultaMedica.setFechaConsulta(date);
		//System.out.println(consultaMedica);
		ejbConsultaMedica.create(consultaMedica);
		ConsultaMedica c = new ConsultaMedica();
		consultaM=ejbConsultaMedica.find(consultaMedica.getIdConsultaMedica());
		System.out.println("Cccccccccccccccccc22222222"+consultaM.getIdConsultaMedica());
		consultaM = ejbConsultaMedica.find(consultaMedica.getIdConsultaMedica());
		idConsultaMedica = consultaM.getIdConsultaMedica();
		
		//System.out.println(idConsultaMedica);
		System.out.println("estamos rn registras consulta medica");
		System.out.println("Ingreso");
		System.out.println("motivo" + motivoConsulta);
		System.out.println("vacunacion" + vacunacion);
		System.out.println("desparacitavion" + desparacitacion);
		System.out.println("Estado Repro" + estadoR);
		System.out.println("producto" + producto);
		System.out.println("fecha" + fecha);
		System.out.println("procedencia" + procedencia);
		System.out.println("anamnesis" + anamnesis);
		System.out.println("diagnosstico" + diagnostico);
		System.out.println("pronostico" + pronostico);
		System.out.println("tratamiento" + tratamiento);
		System.out.println("observaciones" + observaciones);
		System.out.println("idMascota" + idMascota);
		try {
			// ejbPropietarioFacade.create(propietario);
			return Response.ok("ok").header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		} catch (Exception e) {
			// TODO: handle exception
			return Response.ok("Error").header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		}
	}
	

	@POST
	@Path("/agregarConstanteF")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response agregarConsultaMedica(String jsonConsultaMedica) {
		System.out.println("ConsutalMedica");
		System.out.println("JSONPRODUCTO----------------->" + jsonConsultaMedica);
		// System.out.println(jsonConsultaMedica.getClass());

		Jsonb jsonb = JsonbBuilder.create();	
		
		list = jsonb.fromJson(jsonConsultaMedica, new ArrayList<Roww>() {}.getClass().getGenericSuperclass());
		System.out.println("consulta medica id recuperado"+idConsultaMedica);
		ConsultaMedica consultamedicaBusqueda = new ConsultaMedica();
		consultamedicaBusqueda=ejbConsultaMedica.find(idConsultaMedica);
		System.out.println("consulM recu"+consultamedicaBusqueda.getObservaciones());		

		for (Roww roww : list) {
			System.out.println(roww.getNombreConsta());
			ConstantesFisiologicasCabecera cabecera = ejbConstantesCabecera.buscarId(roww.getNombreConsta());
			ConstantesFisiologicasDetalle constDet = new ConstantesFisiologicasDetalle(roww.getValorConsta(), cabecera,
					consultamedicaBusqueda);
			ejbConstanteDetalle.create(constDet);
		}
		// System.out.println("Id de consulta medica recuperada es:"+
		// consultamedicaBusqueda);

		try {

			// ejbPropietarioFacade.create(propietario);
			return Response.ok("Ok").header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		} catch (Exception e) {
			// TODO: handle exception
			return Response.ok("Error").header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		}
	}

	@GET
	@Path("/listarHistoriaClinica")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarHistoriaClinica() {
		System.out.println("Constantes Cabecera mascota");
		Jsonb jsonb = JsonbBuilder.create();
		List<HistoriaClinica> listaHistoria = new ArrayList<HistoriaClinica>();
	
	
		try {
			listaHistoria = HistoriaClinica.serializeHistoriaClinica(ejbHistoriaClinicaFacade.findAll());
			System.out.println("historias" + listaHistoria);
			// ejbPropietarioFacade.create(propietario);
			return Response.ok(jsonb.toJson(listaHistoria)).header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		} catch (Exception e) {
			// TODO: handle exception
			return Response.ok("Error").header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		}
	}

	@GET
	@Path("/listarConsultaMedica/{idHistoria}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarConsultaMedica(@PathParam("idHistoria") int idHistoria) {
		System.out.println("Constantes Cabecera mascota");
		System.out.println("Id historiaaaaaaaaaaa==="+ idHistoria);
		Jsonb jsonb = JsonbBuilder.create();
		List<HistoriaClinica> consultaMedicasList = new ArrayList<HistoriaClinica>();
	
	
		try {
			consultaMedicasList = HistoriaClinica.serializeHistoriaClinica(ejbHistoriaClinicaFacade.consultaById(idHistoria));
			System.out.println("historias" + consultaMedicasList);
			// ejbPropietarioFacade.create(propietario);
			return Response.ok(jsonb.toJson(consultaMedicasList)).header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		} catch (Exception e) {
			// TODO: handle exception
			return Response.ok("Error").header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		}
	}

	@GET
	@Path("/listarConsultaMedicaByIdHistoria/{idHistoria}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarConsultaMedicaByIdHistoria(@PathParam("idHistoria") int idHistoria) {
		System.out.println("Constantes Cabecera mascota");
		System.out.println("Id historiaaaaaaaaaaa==="+ idHistoria);
		Jsonb jsonb = JsonbBuilder.create();
		List<ConsultaMedica> consultaMedicasList = new ArrayList<ConsultaMedica>();
	
	
		try {
			consultaMedicasList = ConsultaMedica.serializeConsulta(ejbConsultaMedica.consultaById(idHistoria));
			System.out.println("historias" + consultaMedicasList);
			// ejbPropietarioFacade.create(propietario);
			return Response.ok(jsonb.toJson(consultaMedicasList)).header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		} catch (Exception e) {
			// TODO: handle exception
			return Response.ok("Error").header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		}
	}

	@GET
	@Path("/listarConstantesFisioByConsulta/{idConsulta}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarConstantesFisioByConsulta(@PathParam("idConsulta") int idConsulta) {
		System.out.println("Constantes Cabecera mascota");
		System.out.println("Id historiaaaaaaaaaaa==="+ idConsulta);
		Jsonb jsonb = JsonbBuilder.create();
		List<ConstantesFisiologicasDetalle> consultaMedicasList = new ArrayList<ConstantesFisiologicasDetalle>();
	
	
		try {
			consultaMedicasList = ConstantesFisiologicasDetalle.serializeConstantesFiosiologicasDetalle(ejbConstanteDetalle.obtenerConstante(idConsulta));
			System.out.println("historias" + consultaMedicasList);
			// ejbPropietarioFacade.create(propietario);
			return Response.ok(jsonb.toJson(consultaMedicasList)).header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		} catch (Exception e) {
			// TODO: handle exception
			return Response.ok("Error").header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		}
	}

	@GET
	@Path("/listarConsultaById/{idConsulta}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarConsultaById(@PathParam("idConsulta") int idConsulta) {
		System.out.println("Constantes Cabecera mascota");
		System.out.println("Id historiaaaaaaaaaaa==="+ idConsulta);
		Jsonb jsonb = JsonbBuilder.create();
		List<ConsultaMedica> consultaMedicasList = new ArrayList<ConsultaMedica>();
	
	
		try {
			consultaMedicasList = ConsultaMedica.serializeConsulta(ejbConsultaMedica.buscarId(idConsulta));
			System.out.println("historias" + consultaMedicasList);
			// ejbPropietarioFacade.create(propietario);
			return Response.ok(jsonb.toJson(consultaMedicasList)).header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		} catch (Exception e) {
			// TODO: handle exception
			return Response.ok("Error").header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		}
	}


	
	@GET
	@Path("/texto")
	@Produces(MediaType.APPLICATION_JSON)

	public Response Prueba() {
		System.out.println("Ingreso");
		try {
			// ejbPropietarioFacade.create(propietario);
			return Response.ok("Creado desde tesis veterinaria").header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		} catch (Exception e) {
			// TODO: handle exception
			return Response.ok("Error").header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		}
	}

	@GET
	@Path("/medicoperfil/{correo}")
	@Produces(MediaType.APPLICATION_JSON)
	// @Produces(MediaType.TEXT_PLAIN)
	public Response medicoperfil(@PathParam("correo") String correopda) {
		Jsonb jsonb = JsonbBuilder.create();
		MedicoVeterinario usu = new MedicoVeterinario();
		// usu = ejbMedicoVeterinarioFacade.buscarcorreo(correopda);
		System.out.println(usu.getCedulaId());
		System.out.println(usu.getNombres());
		System.out.println(usu.getApellidos());
		System.out.println(jsonb.toJson(usu));

		try {
			usu = ejbMedicoVeterinarioFacade.buscarcorreo(correopda);
			// usu = new MedicoVeterinario(usu.getCedulaId(), usu.getNombres(),
			// usu.getApellidos(), usu.getDireccion(), usu.getFechaNac(), usu.getCelular(),
			// usu.getTitulo(),
			// );
			if (usu != null) {
				return Response.ok(jsonb.toJson(usu)).build();

				// .header("Access-Control-Allow-Origin", "*")
				// .header("Access-Control-Allow-Headers", "origin, content-type, accept,
				// authorization")
				// .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();

			}
		} catch (Exception ex) {
			return Response.ok("No esta").build();

		}
		return Response.ok("No esta").build();

	}

	@GET
	@Path("/medicoperfilcorreo/{correopda}")
	@Produces(MediaType.APPLICATION_JSON)
	// @Produces(MediaType.TEXT_PLAIN)
	public Response medicoperfilcorreo(@PathParam("correopda") String correopda) {
		Jsonb jsonb = JsonbBuilder.create();
		Usuario usu = new Usuario();
		MedicoVeterinario medi= new MedicoVeterinario();
		ejbUsuarioFacade.idusuario(correopda);
		System.out.println(ejbUsuarioFacade.idusuario(correopda));
		
		 System.out.println("--------------------------------------");
		 
		 
		 try {
			
				medi = ejbMedicoVeterinarioFacade.buscarcorreoV(ejbUsuarioFacade.idusuario(correopda));
			
				System.out.println(medi.getCedulaId());
				System.out.println(medi.getNombres());
				System.out.println(medi.getApellidos());
				System.out.println(medi.getDireccion());
				System.out.println(medi.getFechaNac());
				System.out.println(medi.getCelular());
				System.out.println(medi.getTitulo());
				System.out.println(medi.getEspecialidad_id().getEspecialidad_id());
				System.out.println(medi.getUsuario_id().getUsuario_id());
				
				Usuario usua= new Usuario();
				usua.setUsuario_id(medi.getUsuario_id().getUsuario_id());
				usua.setCorreo(medi.getUsuario_id().getCorreo());
				usua.setContrasena(medi.getUsuario_id().getContrasena());
			
				Especialidad espec= new Especialidad();
				espec.setTipoEspecialidad(medi.getEspecialidad_id().getTipoEspecialidad());
				espec.setEspecialidad_id(medi.getEspecialidad_id().getEspecialidad_id());
				
				if (medi != null) {
					
					final  MedicoVeterinario medico;
					medico = new MedicoVeterinario(medi.getCedulaId(),medi.getNombres(),medi.getApellidos(),medi.getDireccion(),medi.getFechaNac(),medi.getCelular(),medi.getTitulo(),espec,usua);
					return Response.ok(jsonb.toJson(medico)).build();
			
				}
			} catch (Exception ex) {
				return Response.ok("No esta").build();

			}
			return Response.ok("No esta").build();

		
	}

	@GET
	@Path("/users/{userId}")
	public Response findUserById(@PathParam("userId") String user) {
		System.out.println("UserID ==> " + user);
		return null;
	}

	@GET
	@Path("/obtenerEspecialidad")
	@Produces(MediaType.APPLICATION_JSON)
	public Response capturarEspecialidad() {
		System.out.println("Especialidad");
		Jsonb jsonb = JsonbBuilder.create();
		List<Especialidad> listaespe = new ArrayList<Especialidad>();

		try {
			listaespe = Especialidad.serializeEspecialidad(ejbEspecialidadFacade.findAll());
			System.out.println("Raza" + listaespe);
			// ejbPropietarioFacade.create(propietario);
			return Response.ok(jsonb.toJson(listaespe)).build();
		} catch (Exception e) {
			// TODO: handle exception
			return Response.ok("No esta").build();

		}
	}

	@POST
	@Path("/registrarPUsuario")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response RegistrarPUsuario(@FormParam("cedula") String cedula, @FormParam("nombres") String nombres,
			@FormParam("apellidos") String apellidos, @FormParam("direccion") String direccion,
			@FormParam("fechaNac") String fechaNac, @FormParam("correo") String correo,
			@FormParam("contrasena") String contrasena, @FormParam("celular") String celular,
			@FormParam("titulo") String titulo, @FormParam("especialidad_id") String especialidad_id) {

		System.out.println("Ingreso");
		Jsonb jsonb = JsonbBuilder.create();
		System.out.println("cedula");
		System.out.println(cedula);
		System.out.println("nombres");
		System.out.println(nombres);
		System.out.println("apellidos");
		System.out.println(apellidos);
		System.out.println("direccion");
		System.out.println(direccion);
		System.out.println("fecha naci");
		System.out.println(fechaNac);
		System.out.println("correo");
		System.out.println(correo);
		System.out.println("contrasena");
		System.out.println(contrasena);
		System.out.println("celular");
		System.out.println(celular);
		System.out.println("titulo");
		System.out.println(titulo);
		System.out.println("especialidad id");
		System.out.println(especialidad_id);
		Usuario usu = new Usuario();
		String contramd5 = usu.md5(contrasena);
		usu.setCorreo(correo);
		usu.setContrasena(contramd5);
		Rol rol = new Rol();
		rol.setRol_id(1);
		usu.setRol_id(rol);
		System.out.println("rol id" + rol.getRol_id());

		Especialidad espe = new Especialidad();
		int especia = Integer.parseInt(especialidad_id);
		espe.setEspecialidad_id(especia);

		ejbUsuarioFacade.create(usu);
		System.out.println("usu id" + usu.getUsuario_id());

		MedicoVeterinario medi = new MedicoVeterinario();
		medi.setCedulaId(cedula);
		medi.setNombres(nombres);
		medi.setApellidos(apellidos);
		medi.setDireccion(direccion);
		medi.setFechaNac(fechaNac);
		medi.setCelular(celular);
		medi.setTitulo(titulo);
		medi.setEspecialidad_id(espe);
		medi.setUsuario_id(usu);

		ejbMedicoVeterinarioFacade.create(medi);

		return Response.ok("Bien").build();
		// .header("Access-Control-Allow-Headers", "origin, content-type, accept,
		// authorization")

	}
	
	
	@POST
	@Path("/recordarcontra")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response RecordarContra(@FormParam("correo") String correo) {

		Jsonb jsonb = JsonbBuilder.create();
		
		System.out.println("el correo es: ");
		System.out.println(correo);
		
		Usuario us = new Usuario();
		Usuario usu = new Usuario();
		try {
			// us = ejbMedicoVeterinarioFacade.inicioo();
		us = ejbUsuarioFacade.CorreoOk(correo);
			if (us != null) {
				String contra= ejbUsuarioFacade.Contradusuario(correo);
				System.out.println(contra);
				
				Mail mail= new Mail();
				/*
				mail.setTo(correo);
				mail.setSubject("Recuperar la contraseña");
				mail.setDescr("Su contraseña es: "+ contra);
				mail.enviarEmail();
				//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se envio un correo con su contraseña"));
				//new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se envio un correo con su contraseña")
				*/
				String subject = "Recuperacion de contraseña";
				String content = "Codigo de recuperacion: " + contra;
				mail.sendPlainTextEmail("smtp.gmail.com", "587", "tesisveterinariapo@gmail.com", "Politecnica*2020", correo, subject, content);
				System.out.println(us.getCorreo());
				System.out.println(us.getContrasena());
				System.out.println(us.getUsuario_id());
				System.out.println(us.getRol_id());
				Usuario usua= new Usuario();
				Rol rol =new Rol();
				rol.setRol_id(us.getRol_id().getRol_id());
				rol.setDescripcion(us.getRol_id().getDescripcion());
				
				usua.setUsuario_id(us.getUsuario_id());
				usua.setCorreo(us.getCorreo());
				usua.setContrasena(us.getContrasena());
				usua.setRol_id(rol);
				return Response.ok(jsonb.toJson(usua)).build();

			}
		} catch (Exception ex) {
			return Response.ok("No creado").build();

		}
		return Response.ok("No creado").build();
		
	}
	
	@POST
	@Path("/recordarcontrados")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response RecordarContrados(@FormParam("correo") String correo,@FormParam("contrasena") String contrasena,@FormParam("contrasenaNueva") String contrasenaNueva) {

		Jsonb jsonb = JsonbBuilder.create();
		
		System.out.println("el correo es: ");
		System.out.println(correo);
		System.out.println("codigo ");
		System.out.println(contrasena);
		System.out.println("Contraseña nueva");
		System.out.println(contrasenaNueva);
		
		Usuario usu = new Usuario();
		int codigoUsuario = ejbUsuarioFacade.idusuario(correo);
		System.out.println(codigoUsuario);
		ejbUsuarioFacade.acti(codigoUsuario,contrasenaNueva);
		
		return Response.ok("ok").build();
		
	}
	
	@POST
	@Path("/actualizarPMedico")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response ActualizarPMedico(@FormParam("cedula") String cedula, @FormParam("nombres") String nombres,
			@FormParam("apellidos") String apellidos, @FormParam("direccion") String direccion,
			@FormParam("fechaNac") String fechaNac, @FormParam("correo") String correo,
			@FormParam("celular") String celular,@FormParam("titulo") String titulo, 
			@FormParam("especialidad_id") String especialidad_id,@FormParam("usuario_id") String usuario_id) {

		System.out.println("Ingreso");
		Jsonb jsonb = JsonbBuilder.create();
		System.out.println("cedula");
		System.out.println(cedula);
		System.out.println("nombres");
		System.out.println(nombres);
		System.out.println("apellidos");
		System.out.println(apellidos);
		System.out.println("direccion");
		System.out.println(direccion);
		System.out.println("fecha naci");
		System.out.println(fechaNac);
		System.out.println("correo");
		System.out.println(correo);
		System.out.println("celular");
		System.out.println(celular);
		System.out.println("titulo");
		System.out.println(titulo);
		System.out.println("especialidad id");
		System.out.println(especialidad_id);
		System.out.println("usuario id");
		System.out.println(usuario_id);
		
		int usua_id= Integer.parseInt(usuario_id);
		ejbUsuarioFacade.actualizarusuario(usua_id,correo);

		int espe= Integer.parseInt(especialidad_id);
		//public void actualizarusuario(int id,String cedula,String nombres,String apellidos,String celular,String direccion,String fechaNac,String titulo,int especialidad) 
		
		ejbMedicoVeterinarioFacade.actualizarusuario(usua_id, cedula, nombres, apellidos, celular, direccion, fechaNac, titulo, espe);
		
		return Response.ok("Bien").build();
		// .header("Access-Control-Allow-Headers", "origin, content-type, accept,
		// authorization")

	}
	
	
	
	
}
