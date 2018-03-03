package logica.asignatura;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Asignatura implements Serializable  {
	String codigo;
	String nombre;
	String descripcion;
	
	public Asignatura( String codigo, String nombre, String descripcion ) {
		this.codigo 		= codigo;
		this.nombre 		= nombre;
		this.descripcion	= descripcion;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

}
