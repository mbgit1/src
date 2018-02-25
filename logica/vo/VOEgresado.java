package logica.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class VOEgresado implements Serializable  {
	private int cedula;
	private String nombre;
	private String apellido;
	private float promedioCalificacion;
	private float promedioAprobacion;
	
	public VOEgresado( int cedula, String nombre, String apellido, float promedioCalificacion, float promedioAprobacion ) {
		this.cedula					= cedula;
		this.nombre					= nombre;
		this.apellido				= apellido;
		this.promedioCalificacion	= promedioCalificacion;
		this.promedioAprobacion		= promedioAprobacion;
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
	
	public float getPromedioCalificacion() {
		return promedioCalificacion;
	}
	
	public float getPromedioAprobacion() {
		return promedioAprobacion;
	}
}
