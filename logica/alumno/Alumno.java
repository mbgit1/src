package logica.alumno;

import java.io.Serializable;
import java.util.Calendar;

import logica.inscripcion.Inscripciones;

@SuppressWarnings("serial")
public class Alumno implements Serializable {

	private int cedula;
	private String nombre;
	private String apellido;
	private String domicilio;
	private int telefono;
	private String email;
	//private Inscripciones inscpripciones;


public Alumno(int cedula, String nombre, String apellido, String domicilio, int telefono, String email){
	
	this.cedula = cedula;
	this.nombre = nombre;
	this.apellido = apellido;
	this.domicilio = domicilio;
	this.telefono = telefono;
	this.email = email;
	
	
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
 

//public void addInscripcion(Inscripcion inscripcion) throw alumnoYaInscriptoException, asignaturaYaAprobadaException, errorAnioInscripcionException {
// 
//
//inscripciones.addInscripcion();
//de aqui para abajo no va lo hacen en inscripcion
//Inscripcion ins;
//Iterador<Inscripcion> iteInscripciones = iterador();
//
//	int nroInscripcion = inscripcion.getNumero();
//	int anioLectivo = inscripcion.getAnioLectivo();
//	String codigoAsignatrura = ;
//	if(anioLectivo > ultimoAnioInscripcion) {
//
//  while(iteradorExcursiones.hasNext()) {	
//		ins = iteInscripciones.next();
//        if (ins. CODIGO ASIGNATURA == CODIGO ASIGNATURA ) {
//        	if(ins.getCalificacion() < 6){
//            if(ins.getCalificacion() != 0 && anioLectivo == anioCorriente()){// fijarme esto
//               inscripciones.addInscripcion(inscripcion);
//
//            }
//            else throw alumnoYaInscriptoException();
//          }
//          else throw new asignaturaYaAprobadaException();
//        }
//	}

        			
//	}
//	else
//		throw new errorAnioInscripcionException();

//}

//public int ultimoAnioInscripcion() {
//        	return inscripciones.getUltima().getAnioLectivo();
//        	
//}
 
public int anioCorriente() {
	Calendar c = Calendar.getInstance();
	 return   c.YEAR;   	
}




//public int montoRecaudado (int anio) {
//	int monto = 0;
//	while (Inscripciones != null) {
//		if(inscripcion.anioLectivo == anio)
//				monto = monto + inscripcion.montoBase();	
//	}
//	return monto;
//}



//public List<VOEscolaridad> escolaridad(boolean parcial){

//	List<VOEscolaridad> listaEscolaridad = new ArrayList<VOEscolaridad>();
//	Inscripcion inscripcion;
//  Iterador<Inscripcion> iteInscripciones = iterador();
//	while(iteradorExcursiones.hasNext()) {
//		inscripcion = iteInscripciones.next();
//		if(parcial) {
//			if(inscripcion.getCalificacion > 0) {
//			ListaEscolaridad.add(inscripcion);
//			}
//		}
//		else {
//			ListaEscolaridad.add(inscripcion);
//		}
//		
//	}
//	return listaEscolaridad;
//}


 
//public List<VOInscripciones> getListaInscripciones(){
// 		
//return inscripciones.listarInscripciones();
//   
//}



//public boolean egresado() {

//inscripciones.egresado();

/*	
*boolean egresado = false;
*
*	int cantAsignaturas =0;
*Inscripcion inscripcion;
*Iterador<Inscripcion> iteInscripciones = iterador();
*while(iteradorExcursiones.hasNext()) {	
*		inscripcion = iteInscripciones.next();
*		if(inscripcion.getCalificacion() > 6 )
*			cantAsignaturas ++;
*	}
*	if (cantAsignaturas==10) {
*		egresado = true;
*	}
 * return egresado;
*/
//}

//esto no iria deberia estar en inscripciones
//public int promedio() {
// 	int promedio =0;
//	if (egresado) {
//Inscripcion inscripcion;
//Iterador<Inscripcion> iteInscripciones = iterador();
//  while(iteradorExcursiones.hasNext()) {	
//		 inscripcion = iteInscripciones.next();
//	     promedio = promedio + inscripcion.getCalificacion();
//				 
//		}		
//	}
//  return promedio/10;
//}
	
	
	
}
