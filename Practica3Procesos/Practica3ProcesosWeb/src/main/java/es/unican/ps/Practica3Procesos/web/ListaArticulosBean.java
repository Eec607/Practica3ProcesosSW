package es.unican.ps.Practica3Procesos.web;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.EJB;

import es.unican.ps.Practica3Procesos.ClasesDominio.Articulo;
import es.unican.ps.Practica3Procesos.InterfacesDominio.IGestionPedidos;

public class ListaArticulosBean {
	@EJB
	private IGestionPedidos carro;
	
	private Set<Articulo> articulos = new HashSet<Articulo>();
	
	public Set<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(Set<Articulo> articulos) {
		this.articulos = articulos;
	}

	public String verCarro() {
		return "verCarro.xhtml";
	}
	
	public String verArticulo(String nombre) {
		// como ir a un articulo?
		return "verArticulo.xhtml";
	}

}
