package logica.alumno;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import exception.AlumnoYaExisteException;
import logica.inscripcion.Inscripcion;
import logica.inscripcion.Inscripciones;

import logica.vo.VOAlumno;
import logica.vo.VOAlumnoDetallado;
import logica.vo.VOAlumnoListado;
import logica.vo.VOEgresado;
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
/*
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
 
	this.inscpripciones.addInscripcion(inscripcion); 
 
}


public int montoRecaudado (int anio) {

 return this.inscpripciones.montoRecaudado(anio);	
 
}



public List<VOEscolaridad> escolaridad(boolean parcial){

	List<VOEscolaridad> listaEscolaridad = new ArrayList<VOEscolaridad>();
	List<Inscripcion> inscripciones = this.getInscripciones();

	
	for(Inscripcion i: inscripciones) {
		VOEscolaridad voe = new VOEscolaridad(i.getNumero(),i.getAnio(),i.getMonto(),i.getCalificacion()," ");
		if(parcial) {
			if(i.aprobada()) {
		      listaEscolaridad.add(voe);
			}
			 
		}
		else {
			listaEscolaridad.add(voe);
		}
		
	}
	return listaEscolaridad;
}

 
public List<VOInscripcion> getListaInscripciones(){
 		
	return (List<VOInscripcion>) this.inscpripciones;
   
}

public List<Inscripcion> getInscripciones(){
		
	return (List<Inscripcion>) this.inscpripciones;
   
}

public boolean egresado() {

	return this.inscpripciones.egresado();

}

public VOAlumno voSalida() {
	return new VOAlumno(cedula,nombre,  apellido,  domicilio,  telefono,  email);
}

public VOAlumnoListado voAlumnoListado() {
	return new VOAlumnoListado(cedula,nombre,  apellido);
}





//El aux sería un entero, el cual si es -1 significará que la cadena no se encontraba en la apellido.
//Si no es -1 nos devolverá el índice de la primera ocurrencia de la cadena dentro del apellido.
public boolean contienePalabra(String cadena, String apellido) {
 
	int aux = apellido.indexOf("cadena");
	return aux !=-1;
 
}

public void modificarAlumno(String domicilio, int telefono, String email) {
     this.setDomicilio(domicilio);
	 this.setTelefono(telefono);
	 this.setEmail(email);
}

//aqui va el promedio de las materias que tienen mayor o igual que 6
public float promedioTotal(Alumno alumno) {
	// TODO Auto-generated method stub
	return 0;
}

//Aqui va el promedio de todas las materias (incluso si la calificacion es cero)
public float promedioAprobacion(Alumno alumno) {
	// TODO Auto-generated method stub
	return 0;
}

	
		
}
*/

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

 
public int montoRecaudado (int anio) {

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
	return new VOAlumno(cedula,nombre,  apellido,  domicilio,  telefono,  email);
}

public VOAlumnoListado voAlumnoListado() {
	return new VOAlumnoListado(cedula,nombre,  apellido," ");
}


		
public VOAlumnoDetallado voAlumnoDetallado() {
	return new VOAlumnoDetallado(cedula,apellido,nombre,domicilio,telefono,email,0, " ");
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
}

public VOAlumnoDetallado listadoDetalleAlumno(){
	 
	//Alumno alumno;
	//Iterator<Alumno> iteradorAlumno = iterador();
	//List<VOAlumnoDetallado> alumnoSalida = new ArrayList<VOAlumnoDetallado>();
	VOAlumnoDetallado voad = new VOAlumnoDetallado(0," "," "," ",0," ",0," "); 
	//while (iteradorAlumno.hasNext()) {
	//	alumno = iteradorAlumno.next();
		if ( this instanceof Becado) {
			 Becado becado = new Becado(this.getCedula(),this.getApellido(),this.getNombre(),this.getDomicilio(),this.getTelefono(),this.getEmail(),((Becado) this).getDescuento(),((Becado) this).getDescripcion());
		//aca preguntar con instans of si es becado o no.. y ahi hacer la diferencia de vo.. 
		//tomo de aqui si es becado (me devuelvo true) saco el tipo. 
		//agregar en VOAlumnoListado el atributo tipo 
			  voad.setCedula(becado.getCedula());
			  voad.setApellido(becado.getApellido());
			  voad.setNombre(becado.getNombre());
			  voad.setDomicilio(becado.getDomicilio());
			  voad.setTelefono(becado.getTelefono());
			  voad.setEmail(becado.getEmail());
			 // voad.setMontoCuota(becado.calcularCuota());
			  voad.setTipo("becado");
 
			
		}
		else {
			  voad.setCedula(this.getCedula());
			  voad.setApellido(this.getApellido());
			  voad.setNombre(this.getNombre());
			  voad.setDomicilio(this.getDomicilio());
			  voad.setTelefono(this.getTelefono());
			  voad.setEmail(this.getEmail());
			 // voad.setMontoCuota(this.calcularCuota());
			  voad.setTipo("comun");
		}	
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
	
}

