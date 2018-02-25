package logica.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class VOAlumnoModificar implements Serializable  {
	private int cedula;
	private String domicilio;
	private int telefono;
	private String email;
	
	public VOAlumnoModificar( int cedula, String domicilio, int telefono, String email ) {
		this.cedula		= cedula;
		this.domicilio	= domicilio;
		this.telefono	= telefono;
		this.email		= email;
	}
	
	public int getCedula() {
		return cedula;
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
