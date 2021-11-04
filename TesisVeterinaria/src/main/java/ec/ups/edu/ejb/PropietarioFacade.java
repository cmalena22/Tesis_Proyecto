package ec.ups.edu.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ec.ups.edu.modelo.Propietario;

public class PropietarioFacade extends AbstractFacade<Propietario>{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	public PropietarioFacade() {
		super(Propietario.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
}
