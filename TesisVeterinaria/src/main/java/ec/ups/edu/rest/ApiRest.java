package ec.ups.edu.rest;

import java.io.IOException;

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

import ec.ups.edu.ejb.MedicoVeterinarioFacade;
import ec.ups.edu.ejb.PropietarioFacade;
import ec.ups.edu.modelo.MedicoVeterinario;
import ec.ups.edu.modelo.Propietario;

@Path("/prueba")
public class ApiRest {

	@EJB
	private MedicoVeterinarioFacade ejbMedicoVeterinarioFacade;
	@EJB
	private PropietarioFacade ejbPropietarioFacade;

	public ApiRest() {

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
		usu.setCorreo(correo);
		String correoo = usu.getCorreo();

		usu.setContraseña(contrasena);
		String contrasenaa = usu.getContraseña();

		try {
			us = ejbMedicoVeterinarioFacade.inicioo(correoo, contrasenaa);
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
			//ejbPropietarioFacade.create(propietario);
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

}
