package es.unican.ps.Practica3Procesos.ClasesDominio;

public class LineaPedido {
	private int cantidad;
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
