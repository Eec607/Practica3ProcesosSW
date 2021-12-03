package es.unican.ps.Practica3Procesos.CapaPersistencia;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import es.unican.ps.Practica3Procesos.ClasesDominio.Estado;
import es.unican.ps.Practica3Procesos.ClasesDominio.Pedido;
import es.unican.ps.Practica3Procesos.ClasesDominio.Usuario;

public class PedidosDAOTest {
	Pedido p;
	Usuario u;
	PedidosDAO sut;
	
	@Before
	public void setup(){
		// Inicializar el sut
		sut = new PedidosDAO();
		u = new Usuario("Fernando Alonso", "14141414A", "España", "elplan@gmail.com");
		p = new Pedido("A01", Estado.EN_PROGRESO, LocalDate.now(), LocalTime.of(14, 0), u);
	}
	
	@Test
	public void crearPedidoTest() {
		// UT 1.a Crear pedido no existente
		Assert.assertEquals(sut.creaPedido(p), p);
		
		// UT 1.b Crear pedido ya existente
		Assert.assertNull(sut.creaPedido(p));
	}
	

}
