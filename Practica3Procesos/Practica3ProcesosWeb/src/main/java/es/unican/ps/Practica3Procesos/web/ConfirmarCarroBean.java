package es.unican.ps.Practica3Procesos.web;

import javax.ejb.EJB;

import es.unican.ps.Practica3Procesos.ClasesDominio.Pedido;
import es.unican.ps.Practica3Procesos.InterfacesDominio.IGestionPedidos;

public class ConfirmarCarroBean {
	
	@EJB
	private IGestionPedidos supermercado;
	
	private Pedido pedido;

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public String inicio() {
		supermercado.limpiarCarro();
		return "verArticulos.xhtml";
	}

}
