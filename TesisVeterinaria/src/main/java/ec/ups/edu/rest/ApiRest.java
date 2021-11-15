package ec.ups.edu.rest;

import java.io.IOException;
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

import ec.ups.edu.ejb.MedicoVeterinarioFacade;
import ec.ups.edu.ejb.PropietarioFacade;
import ec.ups.edu.modelo.MedicoVeterinario;
import ec.ups.edu.modelo.Propietario;


@Path("/prueba")
public class ApiRest {

	@EJB private MedicoVeterinarioFacade ejbMedicoVeterinarioFacade;
	@EJB private PropietarioFacade ejbPropietarioFacade;
	
	public ApiRest() {

	}

	@POST
	@Path("/inicio")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response inicio(@FormParam("correo") String correo, @FormParam("contrasena") String contrasena, @FormParam("otra") String hsdg)
			throws IOException {
		System.out.println("Metodo crear");
		MedicoVeterinario us = new MedicoVeterinario();
		System.out.println("Correo " + correo);
		System.out.println("Contrasena " + contrasena);

		MedicoVeterinario usu = new MedicoVeterinario();
		usu.setCorreo(correo);
		String correoo = usu.getCorreo();

		usu.setContraseña(contrasena);
		String contrasenaa = usu.getContraseña();

		try {
			us = ejbMedicoVeterinarioFacade.inicioo(correoo, contrasenaa);
			if (us != null) {
				return Response.ok(correo).build();

						//.header("Access-Control-Allow-Origin", "*")
						//.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
						//.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
						
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
	@Path("/registraPropietario")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createPropietario(Propietario propietario) {
		System.out.println("Ingreso");
		System.out.println(propietario.toString());
		try {
			//ejbPropietarioFacade.create(propietario);
			return Response.ok("Creado")
	    			.header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		} catch (Exception e) {
			// TODO: handle exception
			return Response.ok("Error")
	    			.header("Access-Control-Allow-Origin", "*")
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
			//ejbPropietarioFacade.create(propietario);
			return Response.ok("Creado desde tesis veterinaria")
	    			.header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		} catch (Exception e) {
			// TODO: handle exception
			return Response.ok("Error")
	    			.header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		}
	}
	
	
	@GET
	@Path("/medicoperfil/{correo}")
	@Produces(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.TEXT_PLAIN)
	public Response medicoperfil(@PathParam("correo") String correopda) {
		Jsonb jsonb = JsonbBuilder.create();
		MedicoVeterinario usu = new MedicoVeterinario();
		//usu = ejbMedicoVeterinarioFacade.buscarcorreo(correopda);
		System.out.println(usu.getCedulaId());
		System.out.println(usu.getNombres());
		System.out.println(usu.getApellidos());
		System.out.println(jsonb.toJson(usu));
		
		
		try {
			usu = ejbMedicoVeterinarioFacade.buscarcorreo(correopda);
			usu = new MedicoVeterinario(usu.getCedulaId(),usu.getNombres(),usu.getApellidos(),usu.getCorreo(),usu.getContraseña(),usu.getDireccion(),usu.getFechaNac(),usu.getCelular(),usu.getTitulo(),usu.getEspecialidad());
			if (usu != null) {
				return Response.ok(jsonb.toJson(usu)).build();

						//.header("Access-Control-Allow-Origin", "*")
						//.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
						//.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
						
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
