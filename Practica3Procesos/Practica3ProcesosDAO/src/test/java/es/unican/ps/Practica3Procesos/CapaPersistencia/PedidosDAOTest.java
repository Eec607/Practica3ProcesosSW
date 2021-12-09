package es.unican.ps.Practica3Procesos.CapaPersistencia;



import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import es.unican.ps.Practica3Procesos.ClasesDominio.Estado;
import es.unican.ps.Practica3Procesos.ClasesDominio.Pedido;
import es.unican.ps.Practica3Procesos.ClasesDominio.Usuario;

public class PedidosDAOTest {
	Pedido p;
	Usuario u;
	PedidosDAO sut;
	
	@Mock	
	EntityManager mockEM;
	
	
	
	@Before
	public void setup(){
		mockEM = mock(EntityManager.class);
		// Inicializamos el sut
		sut = new PedidosDAO();
		// Instanciamos el mismo entity manager
		sut.setEntityManager(mockEM);
		// Programamos el lanzamiento de la excepcion
		doNothing().doThrow(EntityExistsException.class).when(mockEM).persist(any(Pedido.class));
		// Creamos usuario y pedido
		u = new Usuario("Fernando Alonso", "14141414A", "España", "elplan@gmail.com");
		p = new Pedido("A01", Estado.EN_PROGRESO, LocalDate.now(), LocalTime.of(14, 0), u);
		
	}
	
	@Test
	public void crearPedidoTest() {
		// UT 1.a Crear pedido no existente
		Assert.assertEquals(p, sut.creaPedido(p));
		
		// UT 1.b Crear pedido ya existente
		Assert.assertNull(sut.creaPedido(p));
	}
	
	@After
	public void clean() {
		sut.eliminaPedido(p.getReferencia());
	}
	

}
