package es.unican.ps.Practica3Procesos.CapaPersistencia;

import java.util.Set;

import javax.ejb.Stateful;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.unican.ps.Practica3Procesos.ClasesDominio.Usuario;

@Stateful
public class UsuariosDAO implements IUsuariosDAO {
	
	@PersistenceContext(unitName="SupermercadosPU")
	private EntityManager em;

	public Usuario creaUsuario(Usuario u) {
		try {
			em.persist(u);
			return u;
		} catch(EntityExistsException e) {
			return null;
		}		
	}

	public Usuario eliminaUsuario(String dni) {
		Usuario u = em.find(Usuario.class, dni);
		try {
			em.remove(u);
			return u;
		} catch(EntityExistsException e) {
			return null;
		}		
	}

	public Usuario actualizaUsuario(Usuario u) {
		em.merge(u);
		return u;
	}

	public Usuario usuario(String dni) {
		return em.find(Usuario.class, dni);
	}

	public Set<Usuario> usuarios() {
		Query q = em.createQuery("SELECT u FROM Usuario u");
		return (Set<Usuario>) q.getResultList();
	}

}
