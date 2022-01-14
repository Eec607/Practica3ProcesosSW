package es.unican.ps.Practica3Procesos.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import es.unican.ps.Practica3Procesos.ClasesDominio.Articulo;
import es.unican.ps.Practica3Procesos.InterfacesDominio.IGestionPedidos;

@Named
@RequestScoped
public class ListaArticulosBean {
	@EJB
	private IGestionPedidos carro;
	
	private List<Articulo> articulos = new ArrayList<Articulo>();
	
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
	
	public String verCarro() {
		return "verCarro.xhtml";
	}
	
	public String verArticulo(Articulo a) {
		VerArticuloBean.pasaArticulo(a);
		return "verArticulo.xhtml";
	}

}
