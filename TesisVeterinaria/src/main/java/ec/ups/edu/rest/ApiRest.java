package ec.ups.edu.rest;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;


import ec.ups.edu.ejb.MedicoVeterinarioFacade;
import ec.ups.edu.modelo.MedicoVeterinario;


@Path("/prueba")
public class ApiRest {

	@EJB private MedicoVeterinarioFacade ejbMedicoVeterinarioFacade;
	
	public ApiRest() {

	}

	@POST
	@Path("/inicio")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response inicio(@FormParam("correo") String correo, @FormParam("contrasena") String contrasena)
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
				return Response.ok(correo)

						.header("Access-Control-Allow-Origin", "*")
						.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
						.header("Access-Control-Max-Age", "120960")
						.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
						
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
}
