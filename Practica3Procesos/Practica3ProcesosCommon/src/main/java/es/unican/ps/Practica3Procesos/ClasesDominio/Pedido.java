package es.unican.ps.Practica3Procesos.ClasesDominio;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	
	// Atributos de la clase Pedido
	private String referencia;
	@Enumerated(EnumType.STRING)
	private Estado estado;
	private LocalDate fecha;
	private LocalTime horaRecogida;
	private double precio;
	private static final double DESCUENTO = 0.05;
	
	// Usuario que hace el pedido
	@ManyToOne
	private Usuario usuario;
	// Conjunto de lineas de pedido
	@OneToMany
	@JoinColumn
	private List<LineaPedido> lineasPedido;
	
	/**
	 * Constructor de la clase Pedido
	 * @param referencia
	 * @param estado
	 * @param fecha
	 * @param horaRecogida
	 * @param usuario
	 */
	public Pedido(String referencia, Estado estado, LocalDate fecha, LocalTime horaRecogida, Usuario usuario) {
		this.referencia = referencia;
		this.estado = estado;
		this.fecha = fecha;
		this.horaRecogida = horaRecogida;
		this.usuario = usuario;
		precio = 0.0;
		lineasPedido = new ArrayList<LineaPedido>();
	}
	
	
	/**
	 * Constructor de la clase Pedido
	 * @param referencia
	 * @param estado
	 * @param fecha
	 * @param horaRecogida
	 * @param usuario
	 * @param lineasPedido
	 */
	public Pedido(String referencia, Estado estado, LocalDate fecha, LocalTime horaRecogida, Usuario usuario, List<LineaPedido> lineasPedido) {
		this.referencia = referencia;
		this.estado = estado;
		this.fecha = fecha;
		this.horaRecogida = horaRecogida;
		this.usuario = usuario;
		this.lineasPedido = lineasPedido;
	}	

	public Pedido() { }
	
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
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
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
	public List<LineaPedido> getLineasPedido() {
		return lineasPedido;
	}
	
	/**
	 * Devuelve el usuario que hace el pedido
	 * @return el usuario que hace el pedido
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	
	/**
	 * Calcula el precio del pedido
	 */
	public void calculaPrecio() {
		for(LineaPedido l: lineasPedido) {
			this.precio += l.getCantidad()*l.getArticulo().getPrecio();
		}
	}
	
	/**
	 * Aplica descuento al precio total del pedido
	 */
	public void aplicaDescuento() {
		this.precio = (1-DESCUENTO) * this.precio;
	}
	
	/**
	 * Devuelve el precio del pedido
	 * @return el precio del pedido
	 */
	public double getPrecio() {
		return this.precio;
	}
	
	@Override
	public boolean equals(Object pedido) {		
		if (this == pedido) {
			return true;
		}
		if (pedido == null || getClass() != pedido.getClass()) {
			return false;
		}
		Pedido p = (Pedido) pedido;
		
		return Objects.equals(p.estado, estado) &&
				Objects.equals(p.fecha, fecha) &&
				Objects.equals(p.horaRecogida, horaRecogida) &&
				Objects.equals(p.precio, precio);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(referencia, estado, fecha, horaRecogida, precio);
	}

}
