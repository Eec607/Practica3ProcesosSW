package es.unican.ps.Practica3Procesos.web;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.EJB;

import es.unican.ps.Practica3Procesos.ClasesDominio.LineaPedido;
import es.unican.ps.Practica3Procesos.InterfacesDominio.IGestionPedidos;

public class CarroBean {
	
	@EJB
	private IGestionPedidos supermercado;
	
	private Set<LineaPedido> lineasPedido = new HashSet<LineaPedido>();
	private Date horaRecogida;
	
	public Set<LineaPedido> getLineasPedido() {
		return lineasPedido;
	}

	public void setLineasPedido(Set<LineaPedido> lineasPedido) {
		this.lineasPedido = lineasPedido;
	}

	public Date getHoraRecogida() {
		return horaRecogida;
	}

	public void setHoraRecogida(Date horaRecogida) {
		this.horaRecogida = horaRecogida;
	}
	
	public double calculaPrecio() {
		double precio = 0.0;
		
		for(LineaPedido l : lineasPedido) {
			precio += l.getCantidad() * l.getArticulo().getPrecio();
			
		}
		return precio;
	}
	
	public String verArticulos() {
		return "listaArticulos.xhtml";
	}
	
	public String confirmarCarro(){
		return "confirmarCarro.xhtml";
	}
	
}
