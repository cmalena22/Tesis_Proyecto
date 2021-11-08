package ec.ups.edu.ejb;


import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ec.ups.edu.modelo.Mascota;

@Stateless
public class MascotaFacade extends AbstractFacade<Mascota>{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	public MascotaFacade() {
		super(Mascota.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
}
