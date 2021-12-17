package ec.ups.edu.ejb;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.ups.edu.modelo.ConstantesFisiologicasCabecera;
import ec.ups.edu.modelo.ConsultaMedica;
import ec.ups.edu.modelo.MedicoVeterinario;

@Stateless
public class ConsultaMedicaFacade extends AbstractFacade<ConsultaMedica>{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	public ConsultaMedicaFacade() {
		super(ConsultaMedica.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public ConsultaMedica buscarId(int id) {
		ConsultaMedica cab = new ConsultaMedica();
		try {
			String sql = "SELECT p FROM ConsultaMedica p where p.idConsultaMedica=" + id + "";
			System.out.println(sql);
			Query query = em.createQuery(sql);
			cab = (ConsultaMedica) query.getSingleResult();
			System.out.println("recupere raza:" + cab);
			System.out.println("pasa:" + id);
		} catch (Exception e) {
			System.out.println("pais" + e.getMessage());
		}

		return cab;

	}
	public List<ConsultaMedica> consultaById(int id) {
		List<ConsultaMedica> us = new  ArrayList<ConsultaMedica>();
		String query = "SELECT e " + "FROM ConsultaMedica e " + "WHERE e.historia_Id.idHistorial = " + id + "";
		us = em.createQuery(query, ConsultaMedica.class).getResultList();
		return us;
	}
	
}
