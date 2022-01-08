package es.unican.ps.Practica3Procesos.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.inject.Named;

import es.unican.ps.Practica3Procesos.ClasesDominio.Articulo;
import es.unican.ps.Practica3Procesos.InterfacesDominio.IGestionPedidos;

@Named
@RequestScoped
public class ListaArticulosBean {
	@EJB
	private IGestionPedidos carro;
	
	private List<Articulo> articulos = new ArrayList<Articulo>();
	@ManagedProperty(value = "#{param.nombre}")
	private String articuloSeleccionado;
	
	public ListaArticulosBean() {
		
	}
	
	@PostConstruct
	public void cargaArticulos() {
		articulos = carro.onVerListaArticulos();
	}
	
	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
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
		return "verArticulo.xhtml";
	}

}
