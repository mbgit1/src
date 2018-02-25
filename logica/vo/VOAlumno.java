package logica.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class VOAlumno implements Serializable  {
	private int cedula;
	private String nombre;
	private String apellido;
	private String domicilio;
	private int telefono;
	private String email;
	
	public VOAlumno( int cedula, String nombre, String apellido, String domicilio, int telefono, String email ) {
		this.cedula		= cedula;
		this.nombre		= nombre;
		this.apellido	= apellido;
		this.domicilio	= domicilio;
		this.telefono	= telefono;
		this.email		= email;
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
	
	public String getDomicilio() {
		return domicilio;
	}
	
	public int getTelefono() {
		return telefono;
	}
	
	public String getEmail() {
		return email;
	}
}
