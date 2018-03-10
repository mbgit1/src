package logica.alumno;

import java.io.Serializable;

import logica.vo.VOAlumnoDetallado;
import logica.vo.VOBecado;

@SuppressWarnings("serial")
public class Becado extends Alumno implements Serializable  {

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

	public VOBecado voBecado() {

		return new VOBecado(getCedula(),getApellido(), getNombre(),getDomicilio(),getTelefono(),getEmail(),descuento,descripcion);
	}
	/*
public int calcularCuota( ) {

	return super.calcularCuota()  - ((super.calcularCuota()* descuento)/100); 
}

	 */

	public float montoRecaudado(int anio) {	
		return  super.montoRecaudado(anio) - ((super.montoRecaudado(anio) * this.descuento)/100);       
	}

	public VOAlumnoDetallado listadoDetalleAlumno(){
		VOAlumnoDetallado voad;
		int montoCuota = 0;

		voad = new VOAlumnoDetallado(getCedula(), getNombre(), getApellido(), getDomicilio(), getTelefono(), getEmail(), montoCuota, "becado", descuento, descripcion);

		return voad;
	}
}

