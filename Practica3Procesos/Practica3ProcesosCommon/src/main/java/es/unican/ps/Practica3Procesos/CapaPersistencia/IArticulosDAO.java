package es.unican.ps.Practica3Procesos.CapaPersistencia;

import java.util.Set;

import es.unican.ps.Practica3Procesos.ClasesDominio.Articulo;

public interface IArticulosDAO {
	
	Articulo creaArticulo(Articulo a);
	
	Articulo eliminaArticulo(String nombre);
	
	Articulo actualizaArticulo(Articulo a);
	
	Articulo articulo(String nombre);
	
	Set<Articulo> articulos();

}
