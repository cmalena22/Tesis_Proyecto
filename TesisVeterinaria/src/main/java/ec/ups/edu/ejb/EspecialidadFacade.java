package ec.ups.edu.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.ups.edu.modelo.ConsultaMedica;
import ec.ups.edu.modelo.Especialidad;

@Stateless
public class EspecialidadFacade  extends AbstractFacade<Especialidad>{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	public EspecialidadFacade() {
		super(Especialidad.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

}
