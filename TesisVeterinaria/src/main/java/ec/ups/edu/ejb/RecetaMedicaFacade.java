package ec.ups.edu.ejb;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.ups.edu.modelo.ConsultaMedica;
import ec.ups.edu.modelo.Propietario;
import ec.ups.edu.modelo.RecetaMedica;
import ec.ups.edu.modelo.Usuario;

@Stateless
public class RecetaMedicaFacade extends AbstractFacade<RecetaMedica>{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	public RecetaMedicaFacade() {
		super(RecetaMedica.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public RecetaMedica CorreoOk(int consultaid) {
		RecetaMedica rece = new RecetaMedica();
		String query = "SELECT e " + "FROM RecetaMedica e " + "WHERE e.consulta_id.idConsultaMedica = " + consultaid + "";
		rece = em.createQuery(query, RecetaMedica.class).getSingleResult();
		return rece;
	}
	
	public  List<RecetaMedica> IdListConsult(int id) {
		List<RecetaMedica> cab = new  ArrayList<RecetaMedica>();
		String query ="SELECT e FROM RecetaMedica e where e.consulta_id.idConsultaMedica=" + id + "";
		cab = em.createQuery(query, RecetaMedica.class).getResultList();
		return cab;
	}
	
	public List<RecetaMedica> buscarIdReceta(int idReceta) {
		List<RecetaMedica> rece = new ArrayList<RecetaMedica>();
		String query = "SELECT e " + "FROM RecetaMedica e " + "WHERE  e.idReceta = " + idReceta + "";
		rece = em.createQuery(query, RecetaMedica.class).getResultList();
		return rece;
	}
	
	public void actualizarReceta(int id,String rp,String prescripcion) {
		String query = "UPDATE RecetaMedica e " + "SET e.rp='" + rp + 
				 "',e.prescripcion='" + prescripcion + 
				 "' WHERE  e.idReceta=" + id;
		 System.out.println(query);
		em.createQuery(query).executeUpdate();
	}
	
	
}
