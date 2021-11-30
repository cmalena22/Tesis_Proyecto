package ec.ups.edu.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.ups.edu.modelo.ConstantesFisiologicasDetalle;

@Stateless
public class ConstantesFisiologicasDetalleFacade extends AbstractFacade<ConstantesFisiologicasDetalle>{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	public ConstantesFisiologicasDetalleFacade() {
		super(ConstantesFisiologicasDetalle.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
}
