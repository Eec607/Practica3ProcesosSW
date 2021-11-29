package es.unican.ps.Practica3Procesos.CapaPersistencia;
import java.util.Set;

import es.unican.ps.Practica3Procesos.ClasesDominio.Pedido;

public interface IPedidosDAO {
	
	Pedido creaPedido(Pedido p);
	
	Pedido eliminaPedido(String ref);
	
	Pedido actualizaPedido(Pedido p);
	
	Pedido pedido(String ref);
	
	Set<Pedido> pedidos();

}
