package es.unican.ps.Practica3Procesos.CapaNegocio;

import javax.ejb.Stateful;

import es.unican.ps.Practica3Procesos.ClasesDominio.Usuario;
import es.unican.ps.Practica3Procesos.InterfacesDominio.IGestionRegistro;
import es.unican.ps.Practica3Procesos.InterfacesDominio.IUsuariosDAO;

@Stateful
public class GestionRegistro implements IGestionRegistro {
	
	private IUsuariosDAO usuariosDAO;

	public Usuario registrarUsuario(Usuario u) {
		usuariosDAO.creaUsuario(u);
		return u;
	}

	public Usuario onLogin(Usuario u) {
		// TODO: Login
		return u;
	}

}
