package es.unican.ps.Practica3Procesos.InterfacesDominio;

import java.util.Set;
import es.unican.ps.Practica3Procesos.ClasesDominio.Pedido;
import javax.ejb.Remote;

@Remote
public interface IPedidosDAO {
	
	Pedido creaPedido(Pedido p);
	
	Pedido eliminaPedido(String referencia);
	
	Pedido actualizaPedido(Pedido p);
	
	Pedido pedido(String referencia);
	
	Set<Pedido> pedidos();

}
