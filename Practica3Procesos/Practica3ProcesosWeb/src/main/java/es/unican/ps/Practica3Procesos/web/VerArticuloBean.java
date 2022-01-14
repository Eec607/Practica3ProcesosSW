package es.unican.ps.Practica3Procesos.web;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import es.unican.ps.Practica3Procesos.ClasesDominio.Articulo;
import es.unican.ps.Practica3Procesos.InterfacesDominio.IGestionPedidos;

@Named
@RequestScoped
public class VerArticuloBean {
	
	@EJB
	private IGestionPedidos supermercado;
	
	private static Articulo articulo;
	private String nombre;
	private int uds;
	
	public VerArticuloBean() {}
	
	@PostConstruct
	public void cargaDatos() {
		nombre = articulo.getNombre();
	}

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
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String anhadirCarro() {
		supermercado.onAnhadirAlCarro(articulo, uds);
		return "listaArticulos.xhtml";
	}
	
	public String volver() {
		return "listaArticulos.xhtml";
	}

	public static void pasaArticulo(Articulo a) {
		articulo = a;
	}
	
}
