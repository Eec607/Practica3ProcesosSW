package es.unican.ps.Practica3Procesos.CapaNegocio;

import java.time.LocalTime;
import java.util.Set;

import javax.ejb.Stateful;

import es.unican.ps.Practica3Procesos.ClasesDominio.Articulo;
import es.unican.ps.Practica3Procesos.ClasesDominio.LineaPedido;
import es.unican.ps.Practica3Procesos.ClasesDominio.Pedido;
import es.unican.ps.Practica3Procesos.ClasesDominio.Usuario;
import es.unican.ps.Practica3Procesos.InterfacesDominio.IGestionPedidos;
import es.unican.ps.Practica3Procesos.InterfacesDominio.IGestionPreparadoPedidos;
import es.unican.ps.Practica3Procesos.InterfacesDominio.IPedidosDAO;
import es.unican.ps.Practica3Procesos.InterfacesDominio.IUsuariosDAO;

@Stateful
public class GestionPedidos implements IGestionPedidos, IGestionPreparadoPedidos{
	
	private IPedidosDAO pedidosDAO;
	private IUsuariosDAO usuariosDAO;

	public Pedido entregaPedido(String dni, String ref) {
		Pedido p = existePedido(ref);
		Usuario u = existeUsuario(dni);
		
		if (existeUsuario(dni) && existePedido(ref)) {
			// Entregar Pedido
		};
		return null;
	}
	
	private Pedido existePedido(String dni) {
		Pedido p;
		if (ref == null) {
			return null;
		}
		p = pedidosDAO.pedido(dni);
		return p;
	}

	private Usuario existeUsuario(String dni) {
		Usuario u;
		if (dni == null) {
			return null;
		}
		u = usuariosDAO.usuario(dni);
		return u;
	}

	public Pedido procesaPedido() {
		// TODO Auto-generated method stub
		return null;
	}

	public Pedido realizarPedido(LocalTime horaRecogida) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<LineaPedido> onVerCarro() {
		// TODO Auto-generated method stub
		return null;
	}

	public Articulo onAnhadirAlCarro(Articulo a, int uds) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Articulo> onVerListaArticulos() {
		// TODO Auto-generated method stub
		return null;
	}

}
