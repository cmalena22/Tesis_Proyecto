package ec.ups.edu.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.ups.edu.modelo.Especialidad;
import ec.ups.edu.modelo.Especie;
import ec.ups.edu.modelo.Mascota;
@Stateless

public class EspecieFacade  extends AbstractFacade<Especie>{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	public EspecieFacade() {
		super(Especie.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	public Especie especieByNombre(String nombre) {
		Especie us = new Especie();
		String query = "SELECT e " + "FROM Especie e " + "WHERE  e.nombreEspecie = '" + nombre + "'";
		us = em.createQuery(query, Especie.class).getSingleResult();
		return us;
	}
	public List<Especie> especieActivo() {
		List<Especie> us = new ArrayList<Especie>() ;
		String query = "SELECT e " + "FROM Especie e " + "WHERE  e.estado = 'activo'" ;
		us = em.createQuery(query, Especie.class).getResultList();
		return us;
	}
}
