package logica.alumno;

import exception.AlumnoYaExisteException;
import logica.inscripcion.Inscripciones;

@SuppressWarnings("serial")
public class Becado extends Alumno {

	private int descuento;
	private String descripcion;
	
public Becado(int cedula, String nombre, String apellido, String domicilio, int telefono, String email, int descuento, String descripcion) {
	
	
	super(cedula,nombre,apellido,domicilio,telefono,email);
	this.descuento = descuento;
	this.descripcion = descripcion;
}

public int getDescuento() {
	return descuento;
}

public void setDescuento(int descuento) {
	this.descuento = descuento;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public int montoRecaudado(int anio) {
	
	return  super.montoRecaudado(anio) - ((super.montoRecaudado(anio) * this.descuento)/100);       

}
}
