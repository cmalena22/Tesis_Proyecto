package ec.ups.edu.ejb;



import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.ups.edu.modelo.MedicoVeterinario;
import ec.ups.edu.modelo.Propietario;

@Stateless
public class PropietarioFacade extends AbstractFacade<Propietario>{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	public PropietarioFacade() {
		super(Propietario.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	public Propietario buscarCedula(String idPro) {
		Propietario pro = new Propietario();
		try {
			String sql = "SELECT p FROM Propietario p where p.idPropietario='" + idPro + "'";
			System.out.println(sql);
			Query query = em.createQuery(sql);
			pro = (Propietario) query.getSingleResult();
			System.out.println("recupere propietario:" + pro);
			System.out.println("pasa:" + idPro);
		} catch (Exception e) {
			System.out.println("pais" + e.getMessage());
		}

		return pro;

	}
}
