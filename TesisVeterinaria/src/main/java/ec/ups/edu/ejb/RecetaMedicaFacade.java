package ec.ups.edu.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ec.ups.edu.modelo.RecetaMedica;

@Stateless
public class RecetaMedicaFacade extends AbstractFacade<RecetaMedica>{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	public RecetaMedicaFacade() {
		super(RecetaMedica.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
}
