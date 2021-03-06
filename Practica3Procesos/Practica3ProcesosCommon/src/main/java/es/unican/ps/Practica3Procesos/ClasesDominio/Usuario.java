package es.unican.ps.Practica3Procesos.ClasesDominio;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Atributos de Usuario
	private String nombre;
	@Id
	private String dni;
	private String direccion;
	private String email;
	private int comprasMensuales;
	
	// Conjunto de pedidos
	@OneToMany(mappedBy="usuario")
	private Set<Pedido> pedidos;
	
	/**
	 * Constructor de la clase Usuario
	 * @param nombre el nombre del usuario
	 * @param dni el dni del usuario
	 * @param direccion la direccion del usuario
	 * @param email el email del usuario
	 */
	public Usuario (String nombre, String dni, String direccion, String email) {
		this.nombre = nombre;
		this.dni = dni;
		this.direccion = direccion;
		this.email = email;
		this.comprasMensuales = 0;
		pedidos = new HashSet<Pedido>();
	}
	
	public Usuario() { }
	
	// M?todos getters y setters de los atributos de Usuario
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getComprasMensuales() {
		return comprasMensuales;
	}
	public void setComprasMensuales(int i) {
		this.comprasMensuales = i;		
	}
	public Set<Pedido> getPedidos() {
		return pedidos;
	}
		
	/**
	 * Incrementa el n?mero de compras mensuales del usuario en 1
	 */
	public void incrementarComprasMensuales() {
		comprasMensuales++;
	}
}
