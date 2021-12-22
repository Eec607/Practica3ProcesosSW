package es.unican.ps.Practica3Procesos.web;

import javax.ejb.EJB;

import es.unican.ps.Practica3Procesos.ClasesDominio.Usuario;
import es.unican.ps.Practica3Procesos.InterfacesDominio.IGestionRegistro;

public class LoginBean {
	
	@EJB
	private IGestionRegistro usuario;
	
	private String dni;

	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String checkDni(String dni) {
		Usuario u = usuario.onLogin(dni);
		String result;
		if (u==null) {
			result = "login.xhtml";
		} else {
			result = "listaArticulos.xhtml";
		}
		return result;
	}
}
