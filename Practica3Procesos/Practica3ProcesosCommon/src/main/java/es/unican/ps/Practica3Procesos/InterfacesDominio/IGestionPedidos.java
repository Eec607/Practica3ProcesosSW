package es.unican.ps.Practica3Procesos.InterfacesDominio;

import java.time.LocalTime;
import java.util.Set;

import es.unican.ps.Practica3Procesos.ClasesDominio.Articulo;
import es.unican.ps.Practica3Procesos.ClasesDominio.LineaPedido;
import es.unican.ps.Practica3Procesos.ClasesDominio.Pedido;
import javax.ejb.Remote;

@Remote
public interface IGestionPedidos {
	Pedido realizarPedido(LocalTime horaRecogida);
	
	Set<LineaPedido> onVerCarro();
	
	Articulo onAnhadirAlCarro(Articulo a, int uds);
	
	Set<Articulo> onVerListaArticulos();
}