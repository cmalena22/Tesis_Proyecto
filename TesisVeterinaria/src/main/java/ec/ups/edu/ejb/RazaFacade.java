package ec.ups.edu.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.ups.edu.modelo.Especialidad;
import ec.ups.edu.modelo.Propietario;
import ec.ups.edu.modelo.Raza;
@Stateless

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
	public Raza buscarId(String nombreRza) {
		Raza raza = new Raza();
		try {
			String sql = "SELECT p FROM Raza p where p.nombre='" + nombreRza + "'";
			System.out.println(sql);
			Query query = em.createQuery(sql);
			raza = (Raza) query.getSingleResult();
			System.out.println("recupere raza:" + raza);
			System.out.println("pasa:" + nombreRza);
		} catch (Exception e) {
			System.out.println("pais" + e.getMessage());
		}

		return raza;

	}

	public List<Raza> obtenerRazaByEspecie(String idEspecie) {
		List<Raza> us = new ArrayList<Raza>();
		String query = "SELECT e " + "FROM Raza e " + "WHERE  e.especie_id.nombreEspecie = '" + idEspecie + "' and  e.estado ='activo'";
		us = em.createQuery(query, Raza.class).getResultList();
		return us;
	}
}
