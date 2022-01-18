package es.unican.ps.Practica3Procesos.CapaNegocio;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import es.unican.ps.Practica3Procesos.ClasesDominio.Usuario;
import es.unican.ps.Practica3Procesos.InterfacesDominio.IGestionRegistro;
import es.unican.ps.Practica3Procesos.InterfacesDominio.IUsuariosDAO;

@Stateful
public class GestionRegistro implements IGestionRegistro {
	
	@EJB
	private IUsuariosDAO usuariosDAO;

	public Usuario registrarUsuario(Usuario u) {
		usuariosDAO.creaUsuario(u);
		return u;
	}

	public Usuario onLogin(String dni) {
		Usuario user = null;
		if (dni != null && dni.length() == 9) {
			user = usuariosDAO.usuario(dni);
		}
		return user;
	}
	
	public Usuario actualizaUsuario(Usuario u) {
		return usuariosDAO.actualizaUsuario(u);
	}

}
