package ec.ups.edu.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.ups.edu.modelo.Especialidad;
import ec.ups.edu.modelo.Especie;

public class EspecieFacade  extends AbstractFacade<Especie>{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	public EspecieFacade() {
		super(Especie.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
}
