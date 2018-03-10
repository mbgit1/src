package logica.alumno;

import java.io.Serializable;
import java.util.List;

import configuracion.Configuracion;
import logica.inscripcion.Inscripcion;
import logica.inscripcion.Inscripciones;
import logica.vo.VOAlumno;
import logica.vo.VOAlumnoDetallado;
import logica.vo.VOAlumnoListado;
import logica.vo.VOEscolaridad;
import logica.vo.VOInscripcion;

@SuppressWarnings("serial")
public class Alumno implements Serializable {

	private int cedula;
	private String nombre;
	private String apellido;
	private String domicilio;
	private int telefono;
	private String email;
	private Inscripciones inscripciones;


	public Alumno(int cedula, String nombre, String apellido, String domicilio, int telefono, String email)	{

		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.email = email;
		this.inscripciones = new Inscripciones();


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

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public void addInscripcion(Inscripcion inscripcion){

		this.inscripciones.addInscripcion(inscripcion); 

	}


	public float montoRecaudado(int anio) {
		return this.inscripciones.montoRecaudado(anio);	
	}



	public List<VOEscolaridad> escolaridad(boolean parcial){

		return this.inscripciones.listarEscolaridad(parcial);


	}


	public List<VOInscripcion> getListaInscripciones(){

		return  this.getListaInscripciones();

	}

	public Inscripciones getInscripciones(){

		return this.inscripciones;

	}

	public boolean egresado() {

		return this.inscripciones.egresado();

	}

	public VOAlumno voSalida() {
		return new VOAlumno(cedula, nombre,  apellido,  domicilio,  telefono,  email);
	}

	public VOAlumnoListado voAlumnoListado() {
		String tipo;

		if ( this instanceof Becado) {
			tipo = "becado";
		}else {
			tipo = "común";
		}

		return new VOAlumnoListado(cedula, nombre, apellido, tipo);
	}



	public VOAlumnoDetallado voAlumnoDetallado() {
		return new VOAlumnoDetallado(cedula, apellido, nombre, domicilio, telefono, email, 0, "", 0, "");
	}
	/*
public int calcularCuota( ) {


	 int anioLectivo = this.inscpripciones.obtenerInscripcion(this.inscpripciones.ultimaInscripcion()).getAnio();
	 return this.montoRecaudado(anioLectivo);
}
	 */
	public void modificarAlumno(String domicilio, int telefono, String email  ) {
		this.setDomicilio(domicilio);
		this.setTelefono(telefono);
		this.setEmail(email);
		if( Configuracion.debug() ) {
			System.out.println( "Modificar alumno cedula: " + cedula + ", domicilio: " + domicilio + ", telefono: " + telefono + ", email: " + email);
		}
	}

	public VOAlumnoDetallado listadoDetalleAlumno(){
		VOAlumnoDetallado voad;
		int montoCuota = 0;
		String tipo;

		if ( this instanceof Becado) {		
			//montoCuota = this.calcularCuota();
			tipo = "becado";
		}else {
			//montoCuota = this.calcularCuota();
			tipo = "comun";
		}

		voad = new VOAlumnoDetallado(cedula, nombre, apellido, domicilio, telefono, email, montoCuota, tipo, 0, "");

		return voad;
	}

	//Aqui va el promedio de todas las materias (incluso si la calificacion es cero)
	public float promedioAprobacion(boolean total) {
		return this.inscripciones.promedioAprobacion(total);
		
	}

	public int ultimaInscripcion() {
		return inscripciones.ultimaInscripcion();

	}
	public Inscripcion obtenerInscripcion(int nroIns) {

		return inscripciones.obtenerInscripcion(nroIns);
	}

	public boolean asignaturaAprobada(String codigo) {
		return inscripciones.asignaturaAprobada(codigo);

	}

	public boolean asignaturaEnCurso(String codigo, int anio) {
		return inscripciones.asignaturaEnCurso(codigo, anio);

	}
	public boolean anioInscripcionValido(int anio) {
		return inscripciones.anioInscripcionValido(anio);

	}

}


