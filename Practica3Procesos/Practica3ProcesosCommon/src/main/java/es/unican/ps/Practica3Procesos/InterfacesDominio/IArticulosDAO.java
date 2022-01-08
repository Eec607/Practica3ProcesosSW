package es.unican.ps.Practica3Procesos.InterfacesDominio;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ejb.Remote;
import es.unican.ps.Practica3Procesos.ClasesDominio.Articulo;

@Remote
public interface IArticulosDAO {
	
	Articulo creaArticulo(Articulo a);
	
	Articulo eliminaArticulo(String nombre);
	
	Articulo actualizaArticulo(Articulo a);
	
	Articulo articulo(String nombre);
	
	List<Articulo> articulos();

}