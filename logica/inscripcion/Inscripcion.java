package logica.inscripcion;

public class Inscripcion {
	int numero;
	int anioLectivo;
	int montoBase;
	int calificacion;
	String codigoAsignatura;
	
	public Inscripcion( int numero, int anioLectivo, int montoBase, String codigoAsignatura ) {
		this.numero				= numero;
		this.anioLectivo		= anioLectivo;
		this.montoBase			= montoBase;
		this.calificacion		= 0;
		this.codigoAsignatura	= codigoAsignatura;
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
	
	public String getCodigoAsignatura() {
		return codigoAsignatura;
	}		
	
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	
	public boolean aprobada() {
		return calificacion >= 6;
	}	

	//public boolean inscripcionActiva(int anioLectivo) {}		
	
	public boolean calificada() {
		return calificacion != 0;
	}	
	
}
