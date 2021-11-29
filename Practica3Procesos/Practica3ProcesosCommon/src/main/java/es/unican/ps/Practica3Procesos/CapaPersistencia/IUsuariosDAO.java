package es.unican.ps.Practica3Procesos.CapaPersistencia;

import java.util.Set;

import es.unican.ps.Practica3Procesos.ClasesDominio.Usuario;

public interface IUsuariosDAO {
	
	Usuario creaUsuario(Usuario u);
	
	Usuario eliminaUsuario(String dni);
	
	Usuario actualizaUsuario(Usuario u);
	
	Usuario usuario(String dni);
	
	Set<Usuario> usuarios();

}
