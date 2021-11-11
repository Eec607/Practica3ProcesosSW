package es.unican.ps.Practica3Procesos.InterfacesDominio;

import es.unican.ps.Practica3Procesos.ClasesDominio.Usuario;
import javax.ejb.Remote;

@Remote
public interface IGestionRegistro {
	Usuario registrarUsuario(Usuario u);
	
	Usuario onLogin(Usuario u);
}