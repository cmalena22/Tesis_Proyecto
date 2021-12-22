package ec.ups.edu.ejb;



import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.ups.edu.modelo.MedicoVeterinario;
import ec.ups.edu.modelo.Propietario;
import ec.ups.edu.modelo.Raza;

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
	public List<Propietario> obtenerPropietarioById(String idPropietario) {
		List<Propietario> us = new ArrayList<Propietario>();
		String query = "SELECT e " + "FROM Propietario e " + "WHERE  e.idPropietario = '" + idPropietario + "'";
		us = em.createQuery(query, Propietario.class).getResultList();
		return us;
	}

}
