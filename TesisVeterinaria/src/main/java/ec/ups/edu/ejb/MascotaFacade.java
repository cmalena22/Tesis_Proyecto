package ec.ups.edu.ejb;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ec.ups.edu.modelo.Mascota;
import ec.ups.edu.modelo.Propietario;

@Stateless
public class MascotaFacade extends AbstractFacade<Mascota>{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	public MascotaFacade() {
		super(Mascota.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public List<Mascota> obtenerMascotaByIdPropietario(String idPropietario) {
		List<Mascota> us = new ArrayList<Mascota>();
		String query = "SELECT e " + "FROM Mascota e " + "WHERE  e.id_mascota_propietario.idPropietario = '" + idPropietario + "'";
		us = em.createQuery(query, Mascota.class).getResultList();
		return us;
	}
}
