package es.unican.ps.Practica3Procesos.ClasesDominio;

public class Articulo {
	private String nombre;
	private int unidadesStock;
	private double precio;
	public String getNombre() {
		return nombre;
	}
	
	public Articulo(String nombre, int unidadesStock, double precio) {
		this.nombre = nombre;
		this.unidadesStock = unidadesStock;
		this.precio = precio;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getUnidadesStock() {
		return unidadesStock;
	}
	public void setUnidadesStock(int unidadesStock) {
		this.unidadesStock = unidadesStock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	

}
