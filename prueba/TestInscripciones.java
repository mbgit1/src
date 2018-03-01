package prueba;

import java.util.List;

import logica.inscripcion.Inscripcion;
import logica.inscripcion.Inscripciones;
import logica.asignatura.Asignatura;
import logica.vo.VOEscolaridad;

public class TestInscripciones { 
	private static Inscripciones ins;
	
	public static void main( String args[] ) {
		ins = new Inscripciones();
		
		int idIns = ins.ultimaInscripcion();
		
		System.out.println("Al momento el último id de inscripción es: " + idIns + " (0 = 'sin inscripciones').");
		
		System.out.println();		
		System.out.println("//Agregamos asignatura con codigoAsignatura=as1, anoLectivo=2016, montoBase=1000");
		//System.out.println("//Obtenemos inscripción con numero=1:");
		//System.out.println("//Consultamos su califcación:");
		System.out.println();
		
		Asignatura as = new Asignatura("as1", "Asignatura 1", "Desc As 1");
		
		ins.addInscripcion(new Inscripcion(++idIns, 2015, 1000, as));	
		
		Inscripcion i = ins.obtenerInscripcion(1);			
		
		System.out.println("La calificación actual para la asignatura con códico: " + i.getAsignatura().getCodigo() + ", es: " + i.getCalificacion());

		
		//System.out.println();
		//System.out.println("//Consultamos si está aprobada:");
		//System.out.println();
		
		System.out.println("La asignatura con códico: " + i.getAsignatura().getCodigo() + ", está aprobada?: " + i.aprobada());

		System.out.println();
		System.out.println("//La calificamos con nota=4:");
		System.out.println();		
		
		ins.registrarCalificacion(1, 4);

		System.out.println("La asignatura con códico: " + i.getAsignatura().getCodigo() + ", está aprobada?: " + i.aprobada());		

		System.out.println();
		System.out.println("//La calificamos con nota=6:");
		System.out.println();		
	
		ins.registrarCalificacion(1, 6);
	
		System.out.println("La asignatura con códico: " + i.getAsignatura().getCodigo() + ", está aprobada?: " + i.aprobada());			

		System.out.println();
		System.out.println("//Consultamos si está aprobada (pasando código de asignatura)");
		System.out.println();		

		System.out.println("La asignatura está aprobada?: " + ins.asignaturaAprobada("as1"));
		
		System.out.println();
		System.out.println("//Agregamos 9 inscripciones más en los años 2015, 2016, 2017 y 2018...");
		System.out.println();			
		
		idIns = ins.ultimaInscripcion();
		Asignatura as2 = new Asignatura("as2", "Asignatura 2", "Desc As 2");
		ins.addInscripcion(new Inscripcion(++idIns, 2015, 1000, as2));
		
		idIns = ins.ultimaInscripcion();
		Asignatura as3 = new Asignatura("as3", "Asignatura 3", "Desc As 3");
		ins.addInscripcion(new Inscripcion(++idIns, 2015, 1000, as3));
		
		idIns = ins.ultimaInscripcion();
		Asignatura as4 = new Asignatura("as4", "Asignatura 4", "Desc As 4");
		ins.addInscripcion(new Inscripcion(++idIns, 2015, 1000, as4));
		
		idIns = ins.ultimaInscripcion();
		Asignatura as5 = new Asignatura("as5", "Asignatura 5", "Desc As 5");
		ins.addInscripcion(new Inscripcion(++idIns, 2016, 1000, as5));
		
		idIns = ins.ultimaInscripcion();
		Asignatura as6 = new Asignatura("as6", "Asignatura 6", "Desc As 6");
		ins.addInscripcion(new Inscripcion(++idIns, 2016, 1000, as6));
		
		idIns = ins.ultimaInscripcion();
		Asignatura as7 = new Asignatura("as7", "Asignatura 7", "Desc As 7");
		ins.addInscripcion(new Inscripcion(++idIns, 2016, 1000, as7));
		
		idIns = ins.ultimaInscripcion();
		Asignatura as8 = new Asignatura("as8", "Asignatura 8", "Desc As 8");
		ins.addInscripcion(new Inscripcion(++idIns, 2017, 1000, as8));
		
		idIns = ins.ultimaInscripcion();
		Asignatura as9 = new Asignatura("as9", "Asignatura 9", "Desc As 9");
		ins.addInscripcion(new Inscripcion(++idIns, 2017, 1000, as9));		
		
		idIns = ins.ultimaInscripcion();
		Asignatura as10 = new Asignatura("as10", "Asignatura 10", "Desc As 10");
		ins.addInscripcion(new Inscripcion(++idIns, 2018, 1000, as10));	

		//System.out.println();
		//System.out.println("//Consultamos el monto recaudado para el año 2015: (debiera ser: 4000)");
		//System.out.println();		
		
		System.out.println("El monto recaudado en el año 2015 fue de: " + ins.montoRecaudado(2015));		
		
		//System.out.println();
		//System.out.println("//Consultamos el monto recaudado para el año 2016: (debiera ser: 3000)");
		//System.out.println();		
		
		System.out.println("El monto recaudado en el año 2016 fue de: " + ins.montoRecaudado(2016));

		//System.out.println();
		//System.out.println("//Consultamos el monto recaudado para el año 2017: (debiera ser: 2000)");
		//System.out.println();		
		
		System.out.println("El monto recaudado en el año 2017 fue de: " + ins.montoRecaudado(2017));		

		//System.out.println();
		//System.out.println("//Consultamos el monto recaudado para el año 2018: (debiera ser: 1000)");
		//System.out.println();		
		
		System.out.println("El monto recaudado en el año 2018 fue de: " + ins.montoRecaudado(2018));		
		
		//System.out.println();
		//System.out.println("//Consultamos si es egresado: ");
		System.out.println();		
		
		System.out.println("El alumno es egresado?: " + ins.egresado());
		
		System.out.println();
		System.out.println("//calificamos las 10 asignaturas, 3 reprobadas, el resto con nota de aprobación...");
		System.out.println();
		
		ins.registrarCalificacion(2, 1);
		ins.registrarCalificacion(3, 2);
		ins.registrarCalificacion(4, 3);
		ins.registrarCalificacion(5, 8);
		ins.registrarCalificacion(6, 9);
		ins.registrarCalificacion(7, 11);
		ins.registrarCalificacion(8, 10);
		ins.registrarCalificacion(9, 10);
		ins.registrarCalificacion(10, 12);		
		
		System.out.println("El alumno es egresado?: " + ins.egresado());			

		System.out.println();
		System.out.println("//Reinscribimos las 3 asignaturas perdidas (comprobando año valido y que la materia no esté en curso) y le asignamos nota de aprobación...");
		System.out.println();		
		
		if (ins.anioInscripcionValido(2018)){
			
			idIns = ins.ultimaInscripcion();
			as2 = new Asignatura("as2", "Asignatura 2", "Desc As 2");
			if (!ins.asignaturaEnCurso(as2.getCodigo(), 2018) && !ins.asignaturaAprobada(as3.getCodigo())){
				ins.addInscripcion(new Inscripcion(++idIns, 2018, 1000, as2));
				ins.registrarCalificacion(ins.ultimaInscripcion(), 6);
			}else 
				System.out.println("La asignatura está en curso.");			
			
			idIns = ins.ultimaInscripcion();
			as3 = new Asignatura("as3", "Asignatura 3", "Desc As 3");
			if (!ins.asignaturaEnCurso(as3.getCodigo(), 2018) && !ins.asignaturaAprobada(as3.getCodigo())){
				ins.addInscripcion(new Inscripcion(++idIns, 2018, 1000, as3));
				ins.registrarCalificacion(ins.ultimaInscripcion(), 10);
			}else 
				System.out.println("La asignatura está en curso.");			
			
			idIns = ins.ultimaInscripcion();
			as4 = new Asignatura("as4", "Asignatura 4", "Desc As 4");
			if (!ins.asignaturaEnCurso(as4.getCodigo(), 2018) && !ins.asignaturaAprobada(as4.getCodigo())){
				ins.addInscripcion(new Inscripcion(++idIns, 2018, 1000, as4));
				ins.registrarCalificacion(ins.ultimaInscripcion(), 12);
			}else 
				System.out.println("La asignatura está en curso.");			
			
		
		}else 
			System.out.println("El año lectivo ingresado NO es valido!.");			
		
		System.out.println("El alumno es egresado?: " + ins.egresado());			
		
		System.out.println();
		System.out.println("Promedio de aprobación parcial del alumno: " + ins.promedioAprobacion(false));
		System.out.println();	
		System.out.println("Promedio de aprobación total del alumno: " + ins.promedioAprobacion(true));
		System.out.println();	
		
		System.out.println("Listado de inscripciones (escolaridad) total:");
		System.out.println();
		List<VOEscolaridad> lista = ins.listarEscolaridad(false);
		
		for(VOEscolaridad voe: lista) {
		
			System.out.println("N° inscripción: "+voe.getNumero()+"| Nombre asignatura: "+voe.getAsignaturaNombre()+"| Monto base: "+voe.getMontoBase() +"| Año lectivo: "+voe.getAnioLectivo()+"| Calificación: "+voe.getCalificacion());
			
		}
		

		System.out.println();			
		System.out.println("Listado de inscripciones (escolaridad) parcial:");
		System.out.println();
		lista = ins.listarEscolaridad(true);
		
		for(VOEscolaridad voe: lista) {
		
			System.out.println("N° inscripción: "+voe.getNumero()+"| Nombre asignatura: "+voe.getAsignaturaNombre()+"| Año lectivo: "+voe.getAnioLectivo()+"| Calificación: "+voe.getCalificacion());
			
		}		
		
	}	
	
}
