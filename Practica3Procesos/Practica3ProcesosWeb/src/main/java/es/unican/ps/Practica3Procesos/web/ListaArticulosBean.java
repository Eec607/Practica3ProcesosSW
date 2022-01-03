package es.unican.ps.Practica3Procesos.web;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.annotation.ManagedProperty;

import es.unican.ps.Practica3Procesos.ClasesDominio.Articulo;
import es.unican.ps.Practica3Procesos.InterfacesDominio.IGestionPedidos;

public class ListaArticulosBean {
	@EJB
	private IGestionPedidos carro;
	
	private Map<String, Articulo> articulos = new HashMap<String, Articulo>();
	@ManagedProperty(value = "#{param.nombre}")
	private String articuloSeleccionado;
	
	public Map<String, Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(Map<String, Articulo> articulos) {
		this.articulos = articulos;
	}

	public String getArticuloSeleccionado() {
		return articuloSeleccionado;
	}

	public void setArticuloSeleccionado(String articuloSeleccionado) {
		this.articuloSeleccionado = articuloSeleccionado;
	}
	
	public String verCarro() {
		return "verCarro.xhtml";
	}
	
	public String verArticulo() {
		VerArticuloBean.setArticulo(articulos.get(articuloSeleccionado));
		return "verArticulo.xhtml";
	}

}
