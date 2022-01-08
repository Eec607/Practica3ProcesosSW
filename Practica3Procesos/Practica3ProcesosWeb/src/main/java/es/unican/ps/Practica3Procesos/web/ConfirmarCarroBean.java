package es.unican.ps.Practica3Procesos.web;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import es.unican.ps.Practica3Procesos.ClasesDominio.Pedido;
import es.unican.ps.Practica3Procesos.InterfacesDominio.IGestionPedidos;

@Named
@RequestScoped
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
