package ec.ups.edu.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.ups.edu.modelo.Especialidad;
import ec.ups.edu.modelo.Raza;

public class RazaFacade  extends AbstractFacade<Raza>{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	public RazaFacade() {
		super(Raza.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

}
