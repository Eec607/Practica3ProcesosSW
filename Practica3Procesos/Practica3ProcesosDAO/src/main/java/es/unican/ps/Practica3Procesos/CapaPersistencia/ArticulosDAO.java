package es.unican.ps.Practica3Procesos.CapaPersistencia;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.unican.ps.Practica3Procesos.ClasesDominio.Articulo;

@Stateless
public class ArticulosDAO implements es.unican.ps.Practica3Procesos.InterfacesDominio.IArticulosDAO {
	
	@PersistenceContext(unitName="SupermercadosPU")
	private EntityManager em;

	public Articulo creaArticulo(Articulo a) {
		try {
			em.persist(a);
			return a;
		} catch(EntityExistsException e) {
			return null;
		}		
	}

	public Articulo eliminaArticulo(String nombre) {
		Articulo a = em.find(Articulo.class, nombre);
		try {
			em.remove(a);
			return a;
		} catch(EntityExistsException e) {
			return null;
		}		
	}

	public Articulo actualizaArticulo(Articulo a) {
		em.merge(a);
		return a;
	}

	public Articulo articulo(String nombre) {
		return em.find(Articulo.class, nombre);
	}

	public List<Articulo> articulos() {
		Query q = em.createQuery("SELECT a FROM Articulo a");
		return (List<Articulo>) q.getResultList();
	}
}
