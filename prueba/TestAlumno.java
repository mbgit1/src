package prueba;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import logica.alumno.Alumno;
import logica.alumno.Becado;
import logica.asignatura.Asignatura;
import logica.inscripcion.Inscripcion;
import logica.inscripcion.Inscripciones;
import logica.alumno.Alumnos;
import logica.vo.VOAlumnoListado;
import logica.vo.VOEgresado;
import logica.vo.VOEscolaridad;


public class TestAlumno {
	
	//Alumnos alumnos;
	
	public static void main( String args[] ) {
		//creamos 10 saignaturas
		Asignatura as1  = new Asignatura("as1", "Asignatura 1", "Desc As 1");
		Asignatura as2  = new Asignatura("as2", "Asignatura 2", "Desc As 2");
		Asignatura as3  = new Asignatura("as3", "Asignatura 3", "Desc As 3");
		Asignatura as4  = new Asignatura("as4", "Asignatura 4", "Desc As 4");
		Asignatura as5  = new Asignatura("as5", "Asignatura 5", "Desc As 5");
		Asignatura as6  = new Asignatura("as6", "Asignatura 6", "Desc As 6");
		Asignatura as7  = new Asignatura("as7", "Asignatura 7", "Desc As 7");
		Asignatura as8  = new Asignatura("as8", "Asignatura 8", "Desc As 8");
		Asignatura as9  = new Asignatura("as9", "Asignatura 9", "Desc As 9");
		Asignatura as10 = new Asignatura("as10", "Asignatura 10", "Desc As 10");		
		//
		
		Alumnos alumnos = new Alumnos();
		
		System.out.println("Agregamos alumnos...\n");
		Alumno alumno1 = new Alumno(40000100, "Guille", "Osores", "calle 1", 95000100, "gosores@a.com");
		alumnos.addAlumno(alumno1);

		Alumno alumno2 = new Alumno(40000101, "José", "Osomano", "calle 2", 95000101, "josomano@a.com");
		alumnos.addAlumno(alumno2);		
		
		System.out.println("Agregamos becados...\n");
		Becado becado1 = new Becado(40000200, "Gabriel", "Novasco", "calle 3", 94000200, "gnovasco@a.com", 93,"desc de prueba");		
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

		System.out.println("\nAgregamos 10 asignaturas aprobadas para el alumno (40000100 - Osores)...\n");		
		//

		Inscripciones ins = alumno1.getInscripciones();	
		int idIns = alumno1.ultimaInscripcion();		
				
		alumno1.addInscripcion(new Inscripcion(++idIns, 2015, 1000, as1));				
		alumno1.addInscripcion(new Inscripcion(++idIns, 2015, 1000, as2));						
		alumno1.addInscripcion(new Inscripcion(++idIns, 2015, 1000, as3));						
		alumno1.addInscripcion(new Inscripcion(++idIns, 2015, 1000, as4));						
		alumno1.addInscripcion(new Inscripcion(++idIns, 2015, 1000, as5));						
		alumno1.addInscripcion(new Inscripcion(++idIns, 2015, 1000, as6));						
		alumno1.addInscripcion(new Inscripcion(++idIns, 2015, 1000, as7));						
		alumno1.addInscripcion(new Inscripcion(++idIns, 2015, 1000, as8));							
		alumno1.addInscripcion(new Inscripcion(++idIns, 2015, 1000, as9));						
		alumno1.addInscripcion(new Inscripcion(++idIns, 2015, 1000, as10));		

		ins.registrarCalificacion(1, 10);
		ins.registrarCalificacion(2, 10);
		ins.registrarCalificacion(3, 12);	
		ins.registrarCalificacion(4, 8);		
		ins.registrarCalificacion(5, 8);		
		ins.registrarCalificacion(6, 9);
		ins.registrarCalificacion(7, 11);		
		ins.registrarCalificacion(8, 10);
		ins.registrarCalificacion(9, 10);
		ins.registrarCalificacion(10, 12);		
		
		//
		System.out.println("\nAgregamos 10 asignaturas aprobadas para el alumno (40000200 - Gabriel)...\n");		
		//

		Inscripciones ins2 = becado1.getInscripciones();	
		int idIns2 = becado1.ultimaInscripcion();		
				
		becado1.addInscripcion(new Inscripcion(++idIns2, 2015, 1000, as1));				
		becado1.addInscripcion(new Inscripcion(++idIns2, 2015, 1000, as2));						
		becado1.addInscripcion(new Inscripcion(++idIns2, 2015, 1000, as3));						
		becado1.addInscripcion(new Inscripcion(++idIns2, 2015, 1000, as4));						
		becado1.addInscripcion(new Inscripcion(++idIns2, 2015, 1000, as5));						
		becado1.addInscripcion(new Inscripcion(++idIns2, 2015, 1000, as6));						
		becado1.addInscripcion(new Inscripcion(++idIns2, 2015, 1000, as7));						
		becado1.addInscripcion(new Inscripcion(++idIns2, 2015, 1000, as8));							
		becado1.addInscripcion(new Inscripcion(++idIns2, 2015, 1000, as9));						
		becado1.addInscripcion(new Inscripcion(++idIns2, 2015, 1000, as10));		

		ins2.registrarCalificacion(1, 6);
		ins2.registrarCalificacion(2, 6);
		ins2.registrarCalificacion(3, 12);	
		ins2.registrarCalificacion(4, 8);		
		ins2.registrarCalificacion(5, 8);		
		ins2.registrarCalificacion(6, 6);
		ins2.registrarCalificacion(7, 11);		
		ins2.registrarCalificacion(8, 8);
		ins2.registrarCalificacion(9, 10);
		ins2.registrarCalificacion(10, 12);		
		
				
		
		
		System.out.println("Promedio de aprobación para el alumno (40000100)...\n");
		
		float promedioTotal = alumnos.promedioAprobacion(40000100, true);
		
		System.out.println("El promedio de aprobación total para el alumno "+alumnos.obtenerAlumno(40000100).getApellido()+" es de: "+promedioTotal+"\n");

		float promedioParcial = alumnos.promedioAprobacion(40000100, false);
		
		System.out.println("El promedio de aprobación parcial para el alumno "+alumnos.obtenerAlumno(40000100).getApellido()+" es de: "+promedioParcial+"\n");		


		System.out.println("Promedio de aprobación para el alumno (40000200)...\n");
		
		promedioTotal = alumnos.promedioAprobacion(40000200, true);
		
		System.out.println("El promedio de aprobación total para el alumno "+alumnos.obtenerAlumno(40000200).getApellido()+" es de: "+promedioTotal+"\n");

		promedioParcial = alumnos.promedioAprobacion(40000200, false);
		
		System.out.println("El promedio de aprobación parcial para el alumno "+alumnos.obtenerAlumno(40000200).getApellido()+" es de: "+promedioParcial+"\n");		
		
		
		
		System.out.println("\nListado (parcial) de egresados...\n");
		
		List<VOEgresado> egresadosParcial = alumnos.listadoEgresados (true);		

		for(VOEgresado voe: egresadosParcial) {
			
			System.out.println("Nombre: "+voe.getNombre()+" "+voe.getApellido()+", Cedula: "+voe.getCedula());
			
		}		

		System.out.println("\nListado (completo) de egresados...\n");
		
		List<VOEgresado> egresadosCompleto = alumnos.listadoEgresados (false);		

		for(VOEgresado voe: egresadosCompleto) {
			
			System.out.println("Nombre: "+voe.getNombre()+" "+voe.getApellido()+", Cedula: "+voe.getCedula()+", Prom Calif. "+voe.getPromedioCalificacion()+", Prom Aprob.: "+voe.getPromedioAprobacion());
			
		}		

		System.out.print( "\nMonto Recaudado para 40000100: " + alumnos.obtener(40000100).montoRecaudado(2015) );
		System.out.print( "\nMonto Recaudado para 40000200: " + alumnos.obtener(40000200).montoRecaudado(2015) );
	}

}
