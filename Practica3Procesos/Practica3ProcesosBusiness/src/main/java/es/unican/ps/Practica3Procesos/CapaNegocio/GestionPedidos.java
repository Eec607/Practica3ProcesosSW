package es.unican.ps.Practica3Procesos.CapaNegocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import es.unican.ps.Practica3Procesos.ClasesDominio.Articulo;
import es.unican.ps.Practica3Procesos.ClasesDominio.Estado;
import es.unican.ps.Practica3Procesos.ClasesDominio.LineaPedido;
import es.unican.ps.Practica3Procesos.ClasesDominio.Pedido;
import es.unican.ps.Practica3Procesos.ClasesDominio.Usuario;
import es.unican.ps.Practica3Procesos.InterfacesDominio.IArticulosDAO;
import es.unican.ps.Practica3Procesos.InterfacesDominio.IGestionPedidos;
import es.unican.ps.Practica3Procesos.InterfacesDominio.IGestionPreparadoPedidos;
import es.unican.ps.Practica3Procesos.InterfacesDominio.IPedidosDAO;
import es.unican.ps.Practica3Procesos.InterfacesDominio.IUsuariosDAO;

@Stateful
public class GestionPedidos implements IGestionPedidos, IGestionPreparadoPedidos{
	
	@EJB
	private IPedidosDAO pedidosDAO;
	@EJB
	private IUsuariosDAO usuariosDAO;
	@EJB
	private IArticulosDAO articulosDAO;
	
	private static LocalTime horaApertura = LocalTime.of(9, 0);
	private static LocalTime horaCierre = LocalTime.of(21, 0);
	
	private Stack<Pedido> pedidosPendientes = new Stack<Pedido>();
	private Set<LineaPedido> lineasPedido = new HashSet<LineaPedido>();
	private int id = 0;
	private String ref = "A"+id;

	public Pedido entregaPedido(String dni, String ref) {
		Pedido p = buscaPedido(ref);
		Usuario u = buscaUsuario(dni);
		
		if (p!=null && u!=null) {
			// Entregar Pedido
			p.setEstado(Estado.ENTREGADO);
			pedidosDAO.actualizaPedido(p);
		}
		return p;
	}
	
	public Pedido procesaPedido() {
		// Desapila el pedido
		Pedido p = pedidosPendientes.peek();
		p.setEstado(Estado.REALIZADO);
		return p;
	}

	public Pedido realizarPedido(LocalTime horaRecogida, Usuario u) {
		Pedido p = null;		
		// Comprobar usuario
		if (u != null) {
			// Comprobar la hora de recogida
			if (horaRecogida.isBefore(horaCierre) && horaRecogida.isAfter(horaApertura)) {
				p = new Pedido(ref, Estado.EN_PROGRESO, LocalDate.now(), horaRecogida, u, lineasPedido);
				p.calculaPrecio();
				if (u.getComprasMensuales() >= 10) {
					p.aplicaDescuento();
				}
				id++;
				pedidosPendientes.add(p);
				u.incrementarComprasMensuales();
			}
		}		
		return p;		
	}

	public Set<LineaPedido> onVerCarro() {
		return lineasPedido;
	}

	public Articulo onAnhadirAlCarro(Articulo a, int uds) {
		lineasPedido.add(new LineaPedido(uds, a));
		return a;
	}

	public List<Articulo> onVerListaArticulos() {
		return articulosDAO.articulos();
	}
	
	public void limpiarCarro() {
		this.lineasPedido.clear();
	}
	
	/**
	 * Devuelve el pedido que tiene la referencia pasada como parametro
	 * @param ref la referencia del pedido
	 * @return el pedido que tiene la referencia pasada como parametro
	 */
	private Pedido buscaPedido(String ref) {
		Pedido p;
		if (ref == null) {
			return null;
		}
		p = pedidosDAO.pedido(ref);
		return p;
	}

	/**
	 * Devuelve el usuario que tiene el dni pasado como parametro
	 * @param dni el dni del usuario
	 * @return el usuario que tiene el dni pasado como parametro
	 */
	private Usuario buscaUsuario(String dni) {
		Usuario u;
		if (dni == null) {
			return null;
		}
		u = usuariosDAO.usuario(dni);
		return u;
	}
	

}
