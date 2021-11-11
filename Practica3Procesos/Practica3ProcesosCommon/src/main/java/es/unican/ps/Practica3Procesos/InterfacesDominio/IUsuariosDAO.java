package es.unican.ps.Practica3Procesos.InterfacesDominio;

import java.util.Set;
import javax.ejb.Remote;
import es.unican.ps.Practica3Procesos.ClasesDominio.Usuario;

@Remote
public interface IUsuariosDAO {
	
	Usuario creaUsuario(Usuario u);
	
	Usuario eliminaUsuario(String dni);
	
	Usuario actualizaUsuario(Usuario u);
	
	Usuario usuario(String dni);
	
	Set<Usuario> usuarios();

}