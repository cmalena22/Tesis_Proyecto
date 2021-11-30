package ec.ups.edu.ejb;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.ups.edu.modelo.ConstantesFisiologicasCabecera;

@Stateless
public class ConstantesFisiologicasCabeceraFacade extends AbstractFacade<ConstantesFisiologicasCabecera>{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	public ConstantesFisiologicasCabeceraFacade() {
		super(ConstantesFisiologicasCabecera.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
}
