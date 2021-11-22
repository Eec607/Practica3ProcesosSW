package es.unican.ps.Practica3Procesos.ClasesDominio;
import java.time.LocalTime;

public class Supermercado {
	private LocalTime horaApertura;
	private LocalTime horaCierre;
	
	/**
	 * Constructor de la clase Supermercado
	 * @param horaApertura la hora de apertura del supermercado
	 * @param horaCierre la hora de cierre del supermercado
	 */
	public Supermercado(LocalTime horaApertura, LocalTime horaCierre) {
		this.horaApertura = horaApertura;
		this.horaCierre = horaCierre;
	}
	
	public LocalTime getHoraApertura() {
		return horaApertura;
	}
	public void setHoraApertura(LocalTime horaApertura) {
		this.horaApertura = horaApertura;
	}
	public LocalTime getHoraCierre() {
		return horaCierre;
	}
	public void setHoraCierre(LocalTime horaCierre) {
		this.horaCierre = horaCierre;
	}
	
	
}
