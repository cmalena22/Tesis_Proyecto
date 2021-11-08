package ec.ups.edu.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ec.ups.edu.modelo.HistoriaClinica;

public class HistoriaClinicaFacade extends AbstractFacade<HistoriaClinica>{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	public HistoriaClinicaFacade() {
		super(HistoriaClinica.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
}
