package ec.ups.edu.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import ec.ups.edu.modelo.MedicoVeterinario;

@Stateless
public class MedicoVeterinarioFacade extends AbstractFacade<MedicoVeterinario>{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	public MedicoVeterinarioFacade() {
		super(MedicoVeterinario.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public MedicoVeterinario inicioo(String username, String password) {
		MedicoVeterinario us=new MedicoVeterinario();
   	 String query = "SELECT e " +
   		      "FROM MedicoVeterinario e " +
   		      "WHERE e.correo = '" + username +
   		      "' AND " +
   		      " e.contraseña = '" + password + "'";
      	us =em.createQuery(query, MedicoVeterinario.class).getSingleResult();
   		      return us;
   }
}
