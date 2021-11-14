package es.unican.ps.Practica3Procesos.CapaNegocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import es.unican.ps.Practica3Procesos.ClasesDominio.Estado;
import es.unican.ps.Practica3Procesos.ClasesDominio.Pedido;
import es.unican.ps.Practica3Procesos.ClasesDominio.Usuario;

public class GestionPedidosTest {
	Usuario u, u2;
	Pedido p, p2;
	GestionPedidos sut;
	
	@Before
	public void setup() {
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
	}
	
	@Test
	public void realizarPedido() {
		// TODO: Pasar la fecha (hoy a las 16), comprobar el resultado
		
		// UT 6.a Persona sin descuento
		Assert.assertEquals(sut.realizarPedido(LocalTime.of(16, 0)), p);
		
		// UT 6.b Persona con descuento
		Assert.assertEquals(sut.realizarPedido(LocalTime.of(16, 0)), p2);
		
		// UT 6.c Hora no válida - retorna null
		Assert.assertNull(sut.realizarPedido(LocalTime.of(23, 45)));
		
	}

}
