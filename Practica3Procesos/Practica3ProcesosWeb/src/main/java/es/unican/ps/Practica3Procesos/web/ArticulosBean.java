package es.unican.ps.Practica3Procesos.web;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import es.unican.ps.Practica3Procesos.ClasesDominio.Articulo;
import es.unican.ps.Practica3Procesos.ClasesDominio.LineaPedido;
import es.unican.ps.Practica3Procesos.ClasesDominio.Pedido;
import es.unican.ps.Practica3Procesos.ClasesDominio.Usuario;
import es.unican.ps.Practica3Procesos.InterfacesDominio.IGestionPedidos;
import es.unican.ps.Practica3Procesos.InterfacesDominio.IGestionRegistro;

@Named
@SessionScoped
public class ArticulosBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private IGestionPedidos carro;
	@EJB
	private IGestionRegistro usuario;
	private Usuario u;
	private String dni = "";
	private List<Articulo> articulos = new ArrayList<Articulo>();
	private List<LineaPedido> lineasPedido = new ArrayList<LineaPedido>();
	private Date horaRecogida;
	private double precio;
	private Articulo articulo;
	private int uds;
	private Pedido pedido;
	
	public ArticulosBean() {}
	
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
	
	public List<LineaPedido> getLineasPedido() {
		return lineasPedido;
	}

	public void setLineasPedido(List<LineaPedido> lineasPedido) {
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
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}	

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	public Usuario getUsuario() {
		return u;
	}

	public void setUsuario(Usuario u) {
		this.u = u;
	}	
	
	// xhtml	
	
	public String volverInicio() {
		carro.limpiarCarro();
		return "listaArticulos.xhtml";
	}
	
	public String login() {
		return "login.xhtml";
	}
	
	public String checkDni() {
		u = usuario.onLogin(dni);
		String result;
		if (u==null) {
			result = "login.xhtml";
		} else {
			result = "listaArticulos.xhtml";
		}
		return result;
	}
	
	public String verCarro() {
		lineasPedido = carro.onVerCarro();
		return "verCarro.xhtml";
	}
	
	public String verArticulo(Articulo a) {
		articulo = a;
		return "verArticulo.xhtml";
	}
	
	public String anhadirCarro() {
		carro.onAnhadirAlCarro(articulo, uds);
		return "listaArticulos.xhtml";
	}
	
	public String verArticulos() {
		return "listaArticulos.xhtml";
	}
	
	public String confirmarCarro(){
		LocalDateTime horaR;
		horaR = horaRecogida.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		pedido = carro.realizarPedido(horaR.toLocalTime().minusHours(1), u);
		u = usuario.actualizaUsuario(u);
		u.incrementarComprasMensuales();
		
		return "confirmarCarro.xhtml";
	}

}
