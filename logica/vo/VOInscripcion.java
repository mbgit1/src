package logica.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class VOInscripcion implements Serializable  {
	private int numero;
	private String codigo;
	private int anioLectivo;
	private int montoBase;
	private int calificacion;
	
	public VOInscripcion( int numero, String codigo, int anioLectivo, int montoBase, int calificacion ) {
		this.numero			= numero;
		this.codigo			= codigo;
		this.anioLectivo	= anioLectivo;
		this.montoBase		= montoBase;
		this.calificacion		= calificacion;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public int getAnioLectivo() {
		return anioLectivo;
	}
	
	public int getMontoBase() {
		return montoBase;
	}
	
	public int getCalificacion() {
		return calificacion;
	}	
}
