package ec.ups.edu.ejb;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.ups.edu.modelo.ConstantesFisiologicasCabecera;
import ec.ups.edu.modelo.Raza;

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
	
	public ConstantesFisiologicasCabecera buscarId(int id) {
		ConstantesFisiologicasCabecera cab = new ConstantesFisiologicasCabecera();
		try {
			String sql = "SELECT p FROM ConstantesFisiologicasCabecera p where p.constantes_idCab=" + id + "";
			System.out.println(sql);
			Query query = em.createQuery(sql);
			cab = (ConstantesFisiologicasCabecera) query.getSingleResult();
			System.out.println("recupere raza:" + cab);
			System.out.println("pasa:" + id);
		} catch (Exception e) {
			System.out.println("pais" + e.getMessage());
		}

		return cab;

	}
}
