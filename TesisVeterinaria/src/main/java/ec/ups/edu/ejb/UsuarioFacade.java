package ec.ups.edu.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
