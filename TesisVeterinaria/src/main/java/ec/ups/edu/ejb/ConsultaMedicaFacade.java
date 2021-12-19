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
	
	public  List<ConsultaMedica> buscarId(int id) {
		List<ConsultaMedica> cab = new  ArrayList<ConsultaMedica>();
		String query ="SELECT p FROM ConsultaMedica p where p.idConsultaMedica=" + id + "";
		cab = em.createQuery(query, ConsultaMedica.class).getResultList();
		return cab;
		
	}
	public List<ConsultaMedica> consultaById(int id) {
		List<ConsultaMedica> us = new  ArrayList<ConsultaMedica>();
		String query = "SELECT e " + "FROM ConsultaMedica e " + "WHERE e.historia_Id.idHistorial = " + id + "";
		us = em.createQuery(query, ConsultaMedica.class).getResultList();
		return us;
	}
	
}
