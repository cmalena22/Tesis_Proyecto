package ec.ups.edu.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.ups.edu.modelo.Especialidad;
import ec.ups.edu.modelo.Rol;
@Stateless

public class RolFacade  extends AbstractFacade<Rol>{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	public RolFacade() {
		super(Rol.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

}
