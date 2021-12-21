package ec.ups.edu.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import ec.ups.edu.modelo.MedicoVeterinario;
import ec.ups.edu.modelo.Raza;
import ec.ups.edu.modelo.Usuario;
@Stateless

public class UsuarioFacade  extends AbstractFacade<Usuario>{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	public UsuarioFacade() {
		super(Usuario.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public Usuario inicioo(String username, String password) {
		Usuario us = new Usuario();
		String contra=us.md5(password);
		String query = "SELECT e " + "FROM Usuario e " + "WHERE e.correo = '" + username + "' AND "
				+ " e.contrasena = '" + contra + "'";
		us = em.createQuery(query, Usuario.class).getSingleResult();
		return us;
	}
	
	public Usuario iniciar(String username, String password) {
		Usuario usuario = new Usuario();
		String contra=usuario.md5(password);
		try {
			String sql = "SELECT e " + "FROM Usuario e " + "WHERE e.correo = '" + username + "' AND "
					+ " e.contrasena = '" + contra + "'";
			System.out.println(sql);
			Query query = em.createQuery(sql);
			usuario = (Usuario) query.getSingleResult();
			System.out.println("recupere usuario:" + usuario);
		
		} catch (Exception e) {
			System.out.println("pais" + e.getMessage());
		}

		return usuario;
	}

public int idusuario(String correo) {
		
		String query = "SELECT  e.usuario_id " + "FROM Usuario e " + "WHERE e.correo = '" + correo + "' ";
		return em.createQuery(query, Integer.class).getSingleResult();
	}
	

public Usuario CorreoOk(String username) {
	Usuario us = new Usuario();
	String query = "SELECT e " + "FROM Usuario e " + "WHERE e.correo = '" + username + "'";
	us = em.createQuery(query, Usuario.class).getSingleResult();
	return us;
}

public String Contradusuario(String correo) {
	
	String query = "SELECT  e.contrasena " + "FROM Usuario e " + "WHERE e.correo = '" + correo + "' ";
	return em.createQuery(query, String.class).getSingleResult();
}



public void acti(int id,String contraNueva) {
	//Usuario usu=new Usuario();
	Usuario us = new Usuario();
	String contra=us.md5(contraNueva);
	 String query = "UPDATE Usuario e " + "SET e.contrasena='" + contra + "' WHERE  e.usuario_id=" + id;
	 System.out.println(query);
	em.createQuery(query).executeUpdate();
}

public void actualizarusuario(int id,String correo) {
	//Usuario usu=new Usuario();
	//Usuario us = new Usuario();
	 String query = "UPDATE Usuario e " + "SET e.correo='" + correo + "' WHERE  e.usuario_id=" + id;
	 System.out.println(query);
	em.createQuery(query).executeUpdate();
}

}
