package ec.ups.edu.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.ups.edu.modelo.ConsultaMedica;

public class ConsultaMedicaFacade extends AbstractFacade<ConsultaMedica>{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	public ConsultaMedicaFacade() {
		super(ConsultaMedica.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

}
