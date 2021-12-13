package ec.ups.edu.rest;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
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
import ec.ups.edu.ejb.EspecieFacade;
import ec.ups.edu.ejb.MascotaFacade;
import ec.ups.edu.ejb.MedicoVeterinarioFacade;
import ec.ups.edu.ejb.PropietarioFacade;
import ec.ups.edu.ejb.RazaFacade;
import ec.ups.edu.ejb.Roww;
import ec.ups.edu.modelo.ConstantesFisiologicasCabecera;
import ec.ups.edu.modelo.ConsultaMedica;
import ec.ups.edu.modelo.Especie;
import ec.ups.edu.modelo.Mascota;
import ec.ups.edu.modelo.MedicoVeterinario;
import ec.ups.edu.modelo.Propietario;
import ec.ups.edu.modelo.Raza;

@Path("/prueba")
public class ApiRest {
	
	private List<Roww> list;
	private ConsultaMedica consultaM;

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
	

	public ApiRest() {
		this.list = new ArrayList<>();
		this.consultaM= new ConsultaMedica();
	}

	@POST
	@Path("/inicio")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response inicio(@FormParam("correo") String correo, @FormParam("contrasena") String contrasena,
			@FormParam("otra") String hsdg) throws IOException {
		System.out.println("Metodo crear");
		MedicoVeterinario us = new MedicoVeterinario();
		System.out.println("Correo " + correo);
		System.out.println("Contrasena " + contrasena);

		MedicoVeterinario usu = new MedicoVeterinario();

		try {
			// us = ejbMedicoVeterinarioFacade.inicioo();
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
		return Response.ok("Bien").build();
		// .header("Access-Control-Allow-Headers", "origin, content-type, accept,
		// authorization")
	}


	@GET
	@Path("/obtenerEspecieMascota")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ingresarEspecieMascota() {
		System.out.println("Especie mascota");
		Jsonb jsonb = JsonbBuilder.create();
		List<Raza> listaRaza = new ArrayList<Raza>();

		try {
			listaRaza = Raza.serializeRaza(ejbRazaFacade.findAll());
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
	@Path("/obtenerRazaMascota")
	@Produces(MediaType.APPLICATION_JSON)

	public Response obtenerRazaMascota() {

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
	@POST
	@Path("/registrarConsultaMedica")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)

	public Response registrarConsulta(@FormParam("motivoConsulta") String motivoConsulta, @FormParam("vacunacion") String vacunacion,
			@FormParam("desparacitacion") String desparacitacion, @FormParam("estadoR") String estadoR,
			@FormParam("producto") String producto, @FormParam("fecha") String fecha,@FormParam("procedencia") String procedencia,
			@FormParam("anamnesis") String anamnesis,@FormParam("diagnostico") String diagnostico,@FormParam("pronostico") String pronostico,
			@FormParam("tratamiento") String tratamiento,@FormParam("observaciones") String observaciones) {

		System.out.println("estamos rn registras consulta medica");
		System.out.println("Ingreso");
		System.out.println("motivo"+motivoConsulta);
		System.out.println("vacunacion"+vacunacion);
		System.out.println("desparacitavion"+desparacitacion);
		System.out.println("Estado Repro"+estadoR);
		System.out.println("producto"+producto);
		System.out.println("fecha"+fecha);
		System.out.println("procedencia"+procedencia);
		System.out.println("anamnesis"+anamnesis);
		System.out.println("diagnosstico"+diagnostico);
		System.out.println("pronostico"+pronostico);
		System.out.println("tratamiento"+tratamiento);
		System.out.println("observaciones"+observaciones);
		consultaM.setIdConsultaMedica(1);
		consultaM.setMotivoConsulta(motivoConsulta);
		System.out.println(consultaM.getIdConsultaMedica());
		//consultaM.setVacunacion(True);

		
		try {
		//	ejbPropietarioFacade.create(propietario);
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
	@Path("/agregarConstanteF")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)


	public Response agregarConsultaMedica(String jsonConsultaMedica) {
		System.out.println("ConsutalMedica");
		System.out.println("JSONPRODUCTO----------------->" + jsonConsultaMedica);
		// System.out.println(jsonConsultaMedica.getClass());
		Jsonb jsonb = JsonbBuilder.create();
		
		//list.add(new Roww("gola", "gola", "gola", "gola", "gola", "gola", "gola", "gola", "gola"));
		list= jsonb.fromJson(jsonConsultaMedica, new ArrayList<Roww>() {}.getClass().getGenericSuperclass());	
		System.out.println("La lista es :" +list);	
		System.out.println("Id de consulta medica registrada es"+consultaM.getIdConsultaMedica());
		for (Roww roww : list) {
			System.out.println(roww.getNombreConsta());			
		}

		try {

			// ejbPropietarioFacade.create(propietario);
			return Response.ok("OK").header("Access-Control-Allow-Origin", "*")
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
	@Path("/users/{userId}")
	public Response findUserById(@PathParam("userId") String user) {
		System.out.println("UserID ==> " + user);
		return null;
	}

}
