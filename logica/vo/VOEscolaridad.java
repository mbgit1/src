package logica.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class VOEscolaridad implements Serializable  {
	private int numero;
	private int aniLectivo;
	private int montoBase;
	private int calificacion;
	private String asignaturaNombre;
	
	public VOEscolaridad( int numero, int aniLectivo, int montoBase, int calificacion, String asignaturaNombre ) {
		this.numero				= numero;
		this.aniLectivo			= aniLectivo;
		this.montoBase			= montoBase;
		this.calificacion		= calificacion;
		this.asignaturaNombre	= asignaturaNombre;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public int getAnioLectivo() {
		return aniLectivo;
	}
	
	public int getMontoBase() {
		return montoBase;
	}
	
	public int getCalificacion() {
		return calificacion;
	}
	
	public String getAsignaturaNombre() {
		return asignaturaNombre;
	}
}
