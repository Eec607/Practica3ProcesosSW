package es.unican.ps.Practica3Procesos.ClasesDominio;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Pedido {
	// Atributos de la clase Pedido
	private String referencia;
	private Estado estado;
	private Date fecha;
	private LocalTime horaRecogida;
	
	// Usuario que hace el pedido
	private Usuario usuario;
	// Conjunto de lineas de pedido
	private Set<LineaPedido> lineasPedido;
	
	public Pedido(String referencia, Estado estado, Date fecha, LocalTime horaRecogida, Usuario usuario) {
		this.referencia = referencia;
		this.estado = estado;
		this.fecha = fecha;
		this.horaRecogida = horaRecogida;
		this.usuario = usuario;
		lineasPedido = new HashSet<LineaPedido>();
	}
	
	// Métodos getters y setters de los atributos de Pedido
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHoraRecogida() {
		return horaRecogida;
	}
	public void setHoraRecogida(LocalTime horaRecogida) {
		this.horaRecogida = horaRecogida;
	}
	
	/**
	 * Devuelve las lineas de pedido del pedido
	 * @return las lineas de pedido del pedido
	 */
	public Set<LineaPedido> getLineasPedido() {
		return lineasPedido;
	}
	
	/**
	 * Devuelve el usuario que hace el pedido
	 * @return el usuario que hace el pedido
	 */
	public Usuario getUsuario() {
		return usuario;
	}

}
