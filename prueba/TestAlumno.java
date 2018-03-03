package prueba;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import logica.alumno.Alumno;
import logica.alumno.Becado;
import logica.alumno.Alumnos;
import logica.vo.VOAlumnoListado;
import logica.vo.VOEscolaridad;


public class TestAlumno {
	
	//Alumnos alumnos;
	
	public static void main( String args[] ) {
		Alumnos alumnos = new Alumnos();
		
		System.out.println("Agregamos alumnos...\n");
		Alumno alumno1 = new Alumno(40000100, "Guille", "Osores", "calle 1", 95000100, "gosores@a.com");
		alumnos.addAlumno(alumno1);

		Alumno alumno2 = new Alumno(40000101, "José", "Osomano", "calle 2", 95000101, "josomano@a.com");
		alumnos.addAlumno(alumno2);		
		
		System.out.println("Agregamos becados...\n");
		Becado becado1 = new Becado(40000200, "Gabriel", "Novasco", "calle 3", 94000200, "gnovasco@a.com", 30,"desc de prueba");		
		alumnos.addAlumno(becado1);

		Becado becado2 = new Becado(40000201, "Alex", "Novasco", "calle 4", 94000201, "anovasco@a.com", 40,"desc de prueba2");		
		alumnos.addAlumno(becado2);		
		
		System.out.println("Consultamos por un alumno agregado...");
		if(alumnos.existeAlumno(40000200)) {
			System.out.println("existe\n");
		}else {
			System.out.println("NO existe\n");
		}

		System.out.println("Consultamos por un alumno que no existe...");
		if(alumnos.existeAlumno(40000300)) {
			System.out.println("existe\n");
		}else {
			System.out.println("NO existe\n");
		}		
		
		System.out.println("Obtenemos a un alumno becado por su cedula (40000200)...\n");
		Alumno alumno = alumnos.obtenerAlumno(40000200);
		
		if (alumno instanceof Becado)
			System.out.println("El alumno "+alumno.getNombre()+" tiene una beca del: "+ ((Becado) alumno).getDescuento()+" %, "+ ((Becado) alumno).getDescripcion());
		
		System.out.println("\nObtenemos listado de alumnos por apellido (que contencan 'so')...\n");
		List<VOAlumnoListado> listado = alumnos.listarAlumnosPorApellido("so");
		
		
		for(VOAlumnoListado voal: listado) {
			
			System.out.println("Nombre: "+voal.getNombre()+" "+voal.getApellido()+", Cedula: "+voal.getCedula()+", Tipo: "+voal.getTipo());
			
		}
		
		System.out.println("\nObtenemos listado de alumnos por apellido (que contencan 'Novasco')...\n");
		List<VOAlumnoListado> listado2 = alumnos.listarAlumnosPorApellido("Novasco");
		
		
		for(VOAlumnoListado voal: listado2) {
			
			System.out.println("Nombre: "+voal.getNombre()+" "+voal.getApellido()+", Cedula: "+voal.getCedula()+", Tipo: "+voal.getTipo());
			
		}		

	}

}
