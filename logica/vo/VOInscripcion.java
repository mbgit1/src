package logica.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class VOInscripcion implements Serializable  {
	private int cedula;
	private String codigo;
	private int anioLectivo;
	private int montoBase;
	
	public VOInscripcion( int cedula, String codigo, int anioLectivo, int montoBase ) {
		this.cedula			= cedula;
		this.codigo			= codigo;
		this.anioLectivo	= anioLectivo;
		this.montoBase		= montoBase;
	}
	
	public int getCedula() {
		return cedula;
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
}
