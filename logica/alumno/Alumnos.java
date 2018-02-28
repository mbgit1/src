package logica.alumno;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.Iterator;

import java.util.List;

import logica.Diccionario;

import logica.vo.VOAlumno;
import logica.vo.VOAlumnoListado;
import logica.vo.VOEgresado;





@SuppressWarnings("serial")
public class Alumnos extends Diccionario<String,Alumno> implements Serializable {

	
	public Alumnos() {
		super();	
    }
	
	public Alumnos( Alumnos alumnos ) {
		this.ponerTodos(alumnos);
	}
	
	public void addAlumno(Alumno alumno) {
		 
		poner(Integer.toString(alumno.getCedula()), alumno);
	}

	
	public boolean existeAlumno(int cedula) {
		
		return contiene(Integer.toString(cedula));
	}
	
	public Alumno obtenerAlumno(int cedula) {
		
		return obtener(Integer.toString(cedula));
	}
	
	public List<VOAlumno> listarAlumnos(){
		 
		Alumno alumno;
		Iterator<Alumno> iteradorAlumno = iterador();
		List<VOAlumno> alumnoSalida = new ArrayList<VOAlumno>();
		
		while (iteradorAlumno.hasNext()) {
			alumno = iteradorAlumno.next();
			alumnoSalida.add( new VOAlumno( alumno.getCedula(), alumno.getNombre(), alumno.getApellido(), alumno.getDomicilio(), alumno.getTelefono(), alumno.getEmail() ) );
		}
		
		return alumnoSalida;	 
		 
		
	}
 
public List<VOAlumnoListado> listarAlumnosPorApellido(String palabra){
	
	Alumno alumno;
	Iterator<Alumno> iteradorAlumno = iterador();
	List<VOAlumnoListado> alumnoSalida = new ArrayList<VOAlumnoListado>();
	
	while (iteradorAlumno.hasNext()) {
		alumno = iteradorAlumno.next();
		if(alumno.contienePalabra(palabra, alumno.getApellido())){
			//aca preguntar con instans of si es becado o no.. y ahi hacer la diferencia de vo.. 
			//tomo de aqui si es becado (me devuelvo true) saco el tipo. 
			//agregar en VOAlumnoListado el atributo tipo 
			alumnoSalida.add(alumno.voAlumnoListado());
		}
	}
	return alumnoSalida;

}

public void modificarAlumno(Alumno alumno) {
//	alumno.modificarAlumno(alumno.getDomicilio()domicilio,telefono,email);
	
}

//aqui va el promedio de las materias que tienen mayor o igual que 6
public float promedioAprobacion (Alumno alumno) {
	return alumno.promedioAprobacion(alumno);
}

//Aqui va el promedio de todas las materias (incluso si la calificacion es cero)
public float promedioTotal (Alumno alumno) {
	
	return 0;
}
 public VOEgresado voEgresados(Alumno alumno) {
	
	return new VOEgresado(alumno.getCedula(),alumno.getNombre(), alumno.getApellido(),alumno.promedioTotal(alumno), promedioAprobacion(alumno));
}

 
public List<VOEgresado> listadoEgresados (boolean parcial){
	Alumno alumno;
	Iterator<Alumno> iteradorAlumno = iterador();
	List<VOEgresado> alumnoSalida = new ArrayList<VOEgresado>();
	VOEgresado voe= null; 
	
	while (iteradorAlumno.hasNext()) {
		alumno = iteradorAlumno.next();
		if (alumno.egresado()) {
			if(parcial) {
			 voe = new VOEgresado(alumno.getCedula(),alumno.getNombre(),alumno.getApellido(),0,0);
		    alumnoSalida.add(voe);
			}
			else {
				voe = new VOEgresado(alumno.getCedula(),alumno.getNombre(),alumno.getApellido(),alumno.promedioTotal(alumno),alumno.promedioAprobacion(alumno));
			    alumnoSalida.add(voe);
			}
		}
	}
	
	return alumnoSalida;	 
	 	 
}
}


	

