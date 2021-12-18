package ec.ups.edu.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.ups.edu.modelo.ConstantesFisiologicasDetalle;
import ec.ups.edu.modelo.MedicoVeterinario;

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
	
	public List<ConstantesFisiologicasDetalle> obtenerConstante(int idConsulta) {
		List<ConstantesFisiologicasDetalle> us = new ArrayList<ConstantesFisiologicasDetalle>();
		String query = "SELECT e " + "FROM ConstantesFisiologicasDetalle e " + "WHERE  e.consulta_id.idConsultaMedica = " + idConsulta + "";
		us = em.createQuery(query, ConstantesFisiologicasDetalle.class).getResultList();
		return us;
	}
	
}
