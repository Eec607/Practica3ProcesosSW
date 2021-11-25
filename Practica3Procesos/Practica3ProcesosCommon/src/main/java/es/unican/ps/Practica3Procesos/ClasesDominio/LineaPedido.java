package es.unican.ps.Practica3Procesos.ClasesDominio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class LineaPedido {
	
	@Id
	private int id;
	
	// Atributos
	private int cantidad;
	@OneToOne
	@JoinColumn
	private Articulo articulo;
	
	/**
	 * Constructor de la clase LineaPedido
	 * @param cantidad
	 * @param articulo
	 */
	public LineaPedido(int cantidad, Articulo articulo) {
		this.cantidad = cantidad;
		this.articulo = articulo;
	}

	/**
	 * Devuelve la cantidad de articulos de la linea de pedido
	 * @return la cantidad de articulos de la linea de pedido
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Asigna la cantidad de articulos de la linea de pedido
	 * @param cantidad de articulos de la linea de pedido
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Devuelve el artículo de la linea de pedido
	 * @return el artículo de la linea de pedido
	 */
	public Articulo getArticulo() {
		return articulo;
	}
	
	

}
