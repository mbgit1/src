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
	private Inscripciones inscpripciones;


public Alumno(int cedula, String nombre, String apellido, String domicilio, int telefono, String email)	{
	
	this.cedula = cedula;
	this.nombre = nombre;
	this.apellido = apellido;
	this.domicilio = domicilio;
	this.telefono = telefono;
	this.email = email;
	this.inscpripciones = new Inscripciones();
	
	
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
