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
	

}
