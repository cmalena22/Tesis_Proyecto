package ec.ups.edu.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import ec.ups.edu.modelo.MedicoVeterinario;
import ec.ups.edu.modelo.Usuario;

@Stateless
public class MedicoVeterinarioFacade extends AbstractFacade<MedicoVeterinario>{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	public MedicoVeterinarioFacade() {
		super(MedicoVeterinario.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public MedicoVeterinario inicioo(String username, String password) {
		MedicoVeterinario us = new MedicoVeterinario();
		String query = "SELECT e " + "FROM MedicoVeterinario e " + "WHERE e.correo = '" + username + "' AND "
				+ " e.contrasena = '" + password + "'";
		us = em.createQuery(query, MedicoVeterinario.class).getSingleResult();
		return us;
	}
	
	public MedicoVeterinario buscarcorreo(String correo) {
		System.out.println("Buscandos de correo");
		System.out.println("Llega"+correo);
		MedicoVeterinario us = new MedicoVeterinario();
		String query = "SELECT e " + "FROM MedicoVeterinario e " + "WHERE  e.usuario_id.correo = '" + correo + "'";
		us = em.createQuery(query, MedicoVeterinario.class).getSingleResult();
		System.out.println(query);
		System.out.println(us.getCedulaId());
		System.out.println(us.getApellidos());
		System.out.println(us.getFechaNac());	
		System.out.println(us.getNombres());
		System.out.println(us.getTitulo());
		System.out.println(us.getUsuario_id().getCorreo());
		System.out.println(us.getEspecialidad_id().getTipoEspecialidad());
		System.out.println(us.getEspecialidad_id().getEspecialidad_id());
		System.out.println(us.getUsuario_id());
		return us;

	}
	
	public MedicoVeterinario buscarcorreoV(int usuario_id) {
		MedicoVeterinario us = new MedicoVeterinario();
		String query = "SELECT e " + "FROM MedicoVeterinario e " + "WHERE  e.usuario_id.usuario_id=" + usuario_id + " ";
		us = em.createQuery(query, MedicoVeterinario.class).getSingleResult();
		System.out.println(query);
		/*
		System.out.println(us.getCedulaId());
		System.out.println(us.getNombres());
		System.out.println(us.getApellidos());
		System.out.println(us.getFechaNac());	
		System.out.println(us.getCelular());
		System.out.println(us.getDireccion());
		System.out.println(us.getTitulo());
		System.out.println(us.getEspecialidad_id());
		*/
		return us;

	}
	
	public void actualizarusuario(int id,String cedula,String nombres,String apellidos,String celular,String direccion,String fechaNac,String titulo,int especialidad) {
		//Usuario usu=new Usuario();
		//Usuario us = new Usuario();
		 String query = "UPDATE MedicoVeterinario e " + "SET e.cedulaId='" + cedula + 
				 "',e.nombres='" + nombres + 
				  "',e.apellidos='" + apellidos + 
				   "',e.celular='" + celular + 
				    "',e.direccion='" + direccion + 
				     "',e.fechaNac='" + fechaNac + 
				      "',e.titulo='" + titulo + 
				       "',e.especialidad_id.especialidad_id=" + especialidad + 
				 " WHERE  e.usuario_id.usuario_id=" + id;
		System.out.println(query);
		em.createQuery(query).executeUpdate();
	}
	
	
	
}
