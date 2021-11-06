package ec.ups.edu.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ec.ups.edu.modelo.MedicoVeterinario;

public class MedicoVeterinarioFacade extends AbstractFacade<MedicoVeterinario>{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	public MedicoVeterinarioFacade() {
		super(MedicoVeterinario.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
}
