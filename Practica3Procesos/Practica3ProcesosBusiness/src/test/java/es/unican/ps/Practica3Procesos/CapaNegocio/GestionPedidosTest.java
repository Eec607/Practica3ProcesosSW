package es.unican.ps.Practica3Procesos.CapaNegocio;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import es.unican.ps.Practica3Procesos.ClasesDominio.Articulo;
import es.unican.ps.Practica3Procesos.ClasesDominio.Estado;
import es.unican.ps.Practica3Procesos.ClasesDominio.LineaPedido;
import es.unican.ps.Practica3Procesos.ClasesDominio.Pedido;
import es.unican.ps.Practica3Procesos.ClasesDominio.Usuario;

public class GestionPedidosTest {
	Usuario u, u2;
	Pedido p, p2;
	Articulo leche, pan, huevos, chocolate;
	
	GestionPedidos sut;
	
	@Before
	public void setup() {
		// Inicializar el sut
		sut = new GestionPedidos();
		
		// Creamos los usuarios
		// Usuario sin descuento
		u = new Usuario("Juan Gomez", "12345678A", "Sanlucar de barrameda", "jg123@gmail.com");
		// Usuario con descuento
		u2 = new Usuario("Pepe Viyuela", "12345678B", "Santander", "pv123@gmail.com");
		for (int i = 0; i < 10; i++) {
			u2.incrementarComprasMensuales();
		}
		// Creamos los pedidos
		p = new Pedido("A1", Estado.EN_PROGRESO, LocalDate.now(), LocalTime.of(16, 0), u);
		p2 = new Pedido("A2", Estado.EN_PROGRESO, LocalDate.now(), LocalTime.of(16, 0), u2);
		
		// Creamos los articulos
		leche = new Articulo("Leche", 80, 1.0);
		pan = new Articulo("Pan", 30, 0.5);
		huevos = new Articulo("Huevos", 50, 1.5);
		chocolate = new Articulo("Chocolate", 25, 1.0);
		
		// Añado los articulos al pedido p. Precio total p: 3.5
		p.getLineasPedido().add(new LineaPedido(3, leche));
		p.getLineasPedido().add(new LineaPedido(1, pan));
		p.calculaPrecio();
		
		// Añado los articulos al pedido p2. Precio total p2: 8.0
		p2.getLineasPedido().add(new LineaPedido(4, leche));
		p2.getLineasPedido().add(new LineaPedido(2, huevos));
		p2.getLineasPedido().add(new LineaPedido(1, chocolate));
		p2.calculaPrecio();
		p2.aplicaDescuento();
	}
	
	@Test
	public void realizarPedidoTest() {		
		// UT 6.a Persona sin descuento
		sut.onAnhadirAlCarro(leche, 3);
		sut.onAnhadirAlCarro(pan, 1);
		Pedido pedido1 = sut.realizarPedido(LocalTime.of(16, 0), u);
		Assert.assertEquals(pedido1, p);
		
		// Hay que introducir un margen de error
		Assert.assertEquals(pedido1.getPrecio(), 3.5, 0.1);
		sut.limpiarCarro();
		
		// UT 6.b Persona con descuento
		sut.onAnhadirAlCarro(leche, 4);
		sut.onAnhadirAlCarro(huevos, 2);
		sut.onAnhadirAlCarro(chocolate, 1);
		Pedido pedido2 = sut.realizarPedido(LocalTime.of(16, 0), u2);
		Assert.assertEquals(pedido2, p2);
		
		// Hay que introducir un margen de error
		Assert.assertEquals(pedido2.getPrecio(), 7.6, 0.1);
		
		// UT 6.c Hora no válida - retorna null
		Assert.assertNull(sut.realizarPedido(LocalTime.of(23, 45), u2));
		
	}

}
