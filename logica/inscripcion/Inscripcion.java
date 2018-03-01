package logica.inscripcion;
import logica.asignatura.Asignatura;

public class Inscripcion {
	int numero;
	int anioLectivo;
	int montoBase;
	int calificacion;
	Asignatura asignatura;
	
	public Inscripcion( int numero, int anioLectivo, int montoBase, Asignatura asignatura ) {
		this.numero				= numero;
		this.anioLectivo		= anioLectivo;
		this.montoBase			= montoBase;
		this.calificacion		= 0;
		this.asignatura	= asignatura;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public int getAnio() {
		return anioLectivo;
	}	
	
	public int getMonto() {
		return montoBase;
	}	

	public int getCalificacion() {
		return calificacion;
	}
	
	public Asignatura getAsignatura() {
		return asignatura;
	}		
	
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	
	public boolean aprobada() {
		return calificacion >= 6;
	}	
	
	public boolean calificada() {
		return calificacion != 0;
	}	
	
}
