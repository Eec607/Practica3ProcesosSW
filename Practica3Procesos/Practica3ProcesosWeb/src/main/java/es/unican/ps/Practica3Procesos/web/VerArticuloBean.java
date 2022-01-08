package es.unican.ps.Practica3Procesos.web;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.inject.Named;

import es.unican.ps.Practica3Procesos.ClasesDominio.Articulo;
import es.unican.ps.Practica3Procesos.InterfacesDominio.IGestionPedidos;

@Named
@RequestScoped
public class VerArticuloBean {
	
	@EJB
	private IGestionPedidos supermercado;
	
	@ManagedProperty(value = "articulo")
	private Articulo articulo;
	private int uds;

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo a) {
		articulo = a;
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
		return "listaArticulos.xhtml";
	}

	
}
