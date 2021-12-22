package es.unican.ps.Practica3Procesos.web;

import javax.ejb.EJB;

import es.unican.ps.Practica3Procesos.ClasesDominio.Articulo;
import es.unican.ps.Practica3Procesos.InterfacesDominio.IGestionPedidos;

public class VerArticuloBean {
	
	@EJB
	private IGestionPedidos supermercado;
	
	private Articulo articulo;
	private int uds;

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	
	public int getUds() {
		return uds;
	}

	public void setUds(int uds) {
		this.uds = uds;
	}

	public String anhadirCarro() {
		supermercado.onAnhadirAlCarro(articulo, uds);
		return "verArticulo.xhtml";
	}
	
	public String volver() {
		return "verArticulo.xhtml";
	}
	
}