package es.unican.ps.Practica3Procesos.CapaNegocio;

import javax.ejb.Stateful;

import es.unican.ps.Practica3Procesos.ClasesDominio.Articulo;
import es.unican.ps.Practica3Procesos.InterfacesDominio.IArticulosDAO;
import es.unican.ps.Practica3Procesos.InterfacesDominio.IGestionArticulos;

@Stateful
public class GestionArticulos implements IGestionArticulos {
	
	private IArticulosDAO articulosDAO;

	public Articulo anhadirArticulo(Articulo a) {
		articulosDAO.creaArticulo(a);
		return a;
	}

	public Articulo eliminarArticulo(Articulo a) {
		articulosDAO.eliminaArticulo(a.getNombre());
		return a;
	}

	public Articulo actualizarArticulo(Articulo a, int uds) {
		a.setUnidadesStock(uds);
		articulosDAO.actualizaArticulo(a);
		return a;
	}

}
