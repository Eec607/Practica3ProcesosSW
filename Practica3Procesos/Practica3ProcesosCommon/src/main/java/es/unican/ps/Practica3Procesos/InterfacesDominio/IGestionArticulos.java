package es.unican.ps.Practica3Procesos.InterfacesDominio;

import es.unican.ps.Practica3Procesos.ClasesDominio.Articulo;
import javax.ejb.Remote;

@Remote
public interface IGestionArticulos {
	Articulo anhadirArticulo(Articulo a);
	
	Articulo eliminarArticulo(Articulo a);
	
	Articulo actualizarArticulo(Articulo a, int uds);
}