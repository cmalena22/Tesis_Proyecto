package ec.ups.edu.ejb;



import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ec.ups.edu.modelo.Propietario;

@Stateless
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
