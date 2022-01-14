package es.unican.ps.Practica3Procesos.web;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import es.unican.ps.Practica3Procesos.ClasesDominio.LineaPedido;
import es.unican.ps.Practica3Procesos.InterfacesDominio.IGestionPedidos;

@Named
@RequestScoped
public class CarroBean {
	
	@EJB
	private IGestionPedidos carro;
	
	private Set<LineaPedido> lineasPedido = new HashSet<LineaPedido>();
	private Date horaRecogida;
	private double precio;
	
	
	public CarroBean() {}
	
	@PostConstruct
	public void cargaCarro() {
		lineasPedido = carro.onVerCarro();
	}
	
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
	
	public double getPrecio() {
		precio = calculaPrecio();
		return precio;
	}
	
	private double calculaPrecio() {
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
