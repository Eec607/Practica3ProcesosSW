package es.unican.ps.Practica3Procesos.CapaPersistencia;

import java.util.Set;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.unican.ps.Practica3Procesos.ClasesDominio.Pedido;

@Stateless
public class PedidosDAO implements es.unican.ps.Practica3Procesos.InterfacesDominio.IPedidosDAO {
	
	@PersistenceContext(unitName="SupermercadosPU")
	private EntityManager em;

	public Pedido creaPedido(Pedido p) {
		if (p != null) {
			try {
				em.persist(p);
			} catch(EntityExistsException e) {
				p = null;
			}
		}
		
		return p;
	}

	public Pedido eliminaPedido(String ref) {
		Pedido p = em.find(Pedido.class, ref);
		try {
			em.remove(p);
			return p;
		} catch(EntityExistsException e) {
			return null;
		}		
	}

	public Pedido actualizaPedido(Pedido p) {
		em.merge(p);
		return p;
	}

	public Pedido pedido(String ref) {
		return em.find(Pedido.class, ref);
	}

	@SuppressWarnings("unchecked")
	public Set<Pedido> pedidos() {
		Query q = em.createQuery("SELECT p FROM Pedido p");
		return (Set<Pedido>) q.getResultList();
	}
	
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

}
