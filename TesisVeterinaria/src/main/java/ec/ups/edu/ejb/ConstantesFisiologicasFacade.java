package ec.ups.edu.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.ups.edu.modelo.ConstantesFisiologicas;


public class ConstantesFisiologicasFacade extends AbstractFacade<ConstantesFisiologicas>{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	public ConstantesFisiologicasFacade() {
		super(ConstantesFisiologicas.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
}
