package logica.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class VOAlumnoListado implements Serializable  {
	private int cedula;
	private String nombre;
	private String apellido;
private String tipo;
	
	public VOAlumnoListado( int cedula, String nombre, String apellido, String tipo) {
		this.cedula		= cedula;
		this.nombre		= nombre;
		this.apellido	= apellido;
		this.tipo = tipo;
		
	}
	
	public int getCedula() {
		return cedula;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
