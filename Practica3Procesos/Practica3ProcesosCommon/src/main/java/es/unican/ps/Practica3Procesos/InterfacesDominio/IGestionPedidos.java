package es.unican.ps.Practica3Procesos.InterfacesDominio;

import java.time.LocalTime;
import java.util.List;

import es.unican.ps.Practica3Procesos.ClasesDominio.Articulo;
import es.unican.ps.Practica3Procesos.ClasesDominio.LineaPedido;
import es.unican.ps.Practica3Procesos.ClasesDominio.Pedido;
import es.unican.ps.Practica3Procesos.ClasesDominio.Usuario;

import javax.ejb.Remote;

@Remote
public interface IGestionPedidos {
	Pedido realizarPedido(LocalTime horaRecogida, Usuario u);
	
	List<LineaPedido> onVerCarro();
	
	Articulo onAnhadirAlCarro(Articulo a, int uds);
	
	List<Articulo> onVerListaArticulos();
	
	void limpiarCarro();
}