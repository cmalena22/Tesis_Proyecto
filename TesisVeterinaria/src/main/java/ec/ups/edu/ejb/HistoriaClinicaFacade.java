package ec.ups.edu.ejb;


import javax.ejb.Stateless;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.ups.edu.modelo.HistoriaClinica;
import ec.ups.edu.modelo.Raza;

@Stateless
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
	public HistoriaClinica buscarId(int idhistoria) {
		HistoriaClinica historia = new HistoriaClinica();
		try {
			String sql = "SELECT p FROM HistoriaClinica p where p.idHistorial=" + idhistoria + "";
			System.out.println(sql);
			Query query = em.createQuery(sql);
			historia = (HistoriaClinica) query.getSingleResult();
			System.out.println("recupere hisotira:" + historia);
			System.out.println("pasa:" + idhistoria);
		} catch (Exception e) {
			System.out.println("pais" + e.getMessage());
		}

		return historia;

	}
}
