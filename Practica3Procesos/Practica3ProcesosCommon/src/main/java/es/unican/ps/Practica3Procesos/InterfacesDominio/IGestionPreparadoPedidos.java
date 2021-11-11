package es.unican.ps.Practica3Procesos.InterfacesDominio;

import es.unican.ps.Practica3Procesos.ClasesDominio.Pedido;
import javax.ejb.Remote;

@Remote
public interface IGestionPreparadoPedidos {
	Pedido entregaPedido(String dni, String	 ref);
	
	Pedido procesaPedido();
}