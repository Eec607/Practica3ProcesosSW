package es.unican.ps.Practica3Procesos.CapaPersistencia;

import java.io.Serializable;
import java.util.Set;

import javax.ejb.ScheduleExpression;
import javax.ejb.Stateful;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.annotation.Resource;
import javax.ejb.TimerService;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.unican.ps.Practica3Procesos.ClasesDominio.Usuario;

@Stateful
public class UsuariosDAO implements IUsuariosDAO {
	
	@Resource
	TimerService timerService;
	
	@PersistenceContext(unitName="SupermercadosPU")
	private EntityManager em;

	public Usuario creaUsuario(Usuario u) {
		try {
			em.persist(u);
			
			//Programación del timer para resetear las compras mensuales
			ScheduleExpression diaReset = new ScheduleExpression().dayOfMonth(1);
			timerService.createCalendarTimer(diaReset, new TimerConfig(u,true));
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
	
	@Timeout
	public void limpiarComprasMensuales(Timer timer) {
		Usuario usuario = (Usuario) timer.getInfo();
		usuario.setComprasMensuales(0);
	}

}
