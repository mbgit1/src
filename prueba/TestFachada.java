package prueba;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.List;

import configuracion.Configuracion;
import exception.AlumnoNoExisteException;
import exception.AlumnoYaExisteException;
import exception.AlumnoYaInscriptoException;
import exception.AsignaturaNoExisteException;
import exception.AsignaturaYaAprobadaException;
import exception.AsignaturaYaCalificadaException;
import exception.AsignaturaYaExisteException;
import exception.ErrorAnioInscripcionException;
import exception.InscripcionNoExisteException;
import exception.ListaLlenaException;
import exception.PersistenciaException;
import logica.IFachada;
import logica.vo.VOAlumno;
import logica.vo.VOAlumnoDetallado;
import logica.vo.VOAlumnoListado;
import logica.vo.VOAlumnoModificar;
import logica.vo.VOAsignatura;
import logica.vo.VOBecado;
import logica.vo.VOEgresado;
import logica.vo.VOEscolaridad;
import logica.vo.VOInscripcion;

public class TestFachada {
	
	public static void main(String args[]) throws FileNotFoundException, IOException, NotBoundException {
		String servidorIp;
		String servidorPuerto;

		servidorIp = Configuracion.getProperty("ServidorIp");
		servidorPuerto = Configuracion.getProperty("ServidorPuerto");
		IFachada fachada = (IFachada) Naming.lookup("//" + servidorIp + ":" + servidorPuerto + "/fachada");
		
		/*
		Fachada fachada = null;
		try {
			fachada = new Fachada();
		} catch (ClassNotFoundException e3) {
			System.out.println("ClassNotFoundException");
		}*/
		
		int cantErrores = 0;
		
		
		System.out.println("--- ESCOLARIDAD LARGA ---");
		try {
			List<VOEscolaridad>lvoe = fachada.escolaridad(123, false);
			for(VOEscolaridad voe : lvoe) {
				System.out.println("numero: " + voe.getNumero() + ", aignatura: " + voe.getAsignaturaNombre() + ", año lectivo: " + voe.getAnioLectivo() + ", calificacion: " + voe.getCalificacion() + ", monto base: " + voe.getMontoBase() );
			}
		} catch (AlumnoNoExisteException e) {
			System.out.println("AlumnoNoExisteException");
		}
		System.out.println("\n\n\n");
		
		
		
		System.out.println("--- REGISTRAR ASIGNATURA ---");
		VOAsignatura voAsignatura = new VOAsignatura("MD", "Matemática discreta", "difícil");
		try {
			fachada.registrarAsignatura(voAsignatura);
			System.out.println("ok");
		} catch (ListaLlenaException e) {
			System.out.println("la lista esta llena");
			cantErrores ++;
		} catch (AsignaturaYaExisteException e) {
			System.out.println("ERROR: la asignatura ya existe");
			cantErrores ++;
		}
		System.out.println("\n\n\n");
		
		
		
		System.out.println("--- REGISTRAR BECADO ---");
		VOBecado voBecado= new VOBecado(456, "Gabriel", "Novasco", "cuidad de la costa", 415, "gatutus@gmail.com", 30, "treinta");
		try {
			fachada.registrarAlumno(voBecado);
			System.out.println("ok");
		} catch (AlumnoYaExisteException e2) {
			System.out.println("Elbecado ya existe");
		}
		System.out.println("\n\n\n");
		
		
		
		System.out.println("--- REGISTRAR ALUMNO ---");
		VOAlumno voAlumno= new VOAlumno(123, "Guille", "Osores", "calle falsa 1234", 12345, "a@a.com");
		try {
			fachada.registrarAlumno(voAlumno);
			System.out.println("ok");
		} catch (AlumnoYaExisteException e2) {
			System.out.println("Alumno ya existe");
		}
		System.out.println("\n\n\n");
		
		
		
		System.out.println("--- MODIFICAR ALUMNO ---");
		VOAlumnoModificar voAlumnoModificar = new VOAlumnoModificar(123, "mi casa 123", 6543, "elguille@gmail.com");
		try {
			fachada.modificarAlumno(voAlumnoModificar);
			System.out.println("ok");
		} catch (AlumnoNoExisteException e1) {
			System.out.println("Alumno no existe");
		}
		System.out.println("\n\n\n");
		
		
		
		System.out.println("--- LISTADO DE ASIGNATURAS ---");
		List<VOAsignatura> lvoa = fachada.listarAsignaturas();
		for(VOAsignatura voa : lvoa) {
			System.out.println("codigo: " + voa.getCodigo() + ", nombre: " + voa.getNombre() + ", descripcion: " + voa.getDescripcion());
		}
		System.out.println("\n\n\n");
		
		
		
		System.out.println("--- LISTADO DE ALUMNOS POR APELLIDO---");
		List<VOAlumnoListado> lvoalL = fachada.listarAlumnos("o");
		for(VOAlumnoListado voa : lvoalL) {
			System.out.println("cedula: " + voa.getCedula() + ", nombre: " + voa.getNombre() + ", apellido: " + voa.getApellido() + ", tipo: " + voa.getTipo());
		}
		System.out.println("\n\n\n");
		
		
		
		System.out.println("--- LISTADO DETALLE ALUMNO---");
		VOAlumnoDetallado voad;
		try {
			voad = fachada.listadoDetalleAlumno(123);
			System.out.println("cedula: " + voad.getCedula() + ", nombre: " + voad.getNombre() + ", apellido: " + voad.getApellido() + ", domicilio: " + voad.getDomicilio() + ", telefono: " + voad.getTelefono() + ", email: " + voad.getEmail() + ", monto cuota: " + voad.getMontoCuota() + ", tipo: " + voad.getTipo());
			voad = fachada.listadoDetalleAlumno(456);
			System.out.println("cedula: " + voad.getCedula() + ", nombre: " + voad.getNombre() + ", apellido: " + voad.getApellido() + ", domicilio: " + voad.getDomicilio() + ", telefono: " + voad.getTelefono() + ", email: " + voad.getEmail() + ", monto cuota: " + voad.getMontoCuota() + ", tipo: " + voad.getTipo());
		} catch (AlumnoNoExisteException e) {
			System.out.println("Alumno no existe");
		}	
		System.out.println("\n\n\n");
		

		System.out.println("--- INSCRIPCION ASIGNATURA ---");
		VOInscripcion voInscripcion = new VOInscripcion(123, "MD", 2017, 1000);
		try {
			fachada.inscripcionAsignatura(voInscripcion);
			System.out.println("OK");
		} catch (AsignaturaNoExisteException e1) {
			System.out.println("Asignatura No existe");
		} catch (AlumnoNoExisteException e1) {
			System.out.println("Alumno no existe");
		} catch (AsignaturaYaAprobadaException e1) {
			System.out.println("Asignatura ya aprovada");
		} catch (ErrorAnioInscripcionException e1) {
			System.out.println("Error año inscripcion");
		} catch (AlumnoYaInscriptoException e1) {
			System.out.println("Aluno ya inscripto");
		}
		System.out.println("\n\n\n");
		
		
		
		System.out.println("--- REGISTRAR CALIFICACION ---");
		try {
			fachada.registrarCalificacion(123, 1, 10);
			System.out.println("OK");
		} catch (AlumnoNoExisteException e) {
			System.out.println("AlumnoNoExisteException");
		} catch (AsignaturaYaCalificadaException e) {
			System.out.println("AsignaturaYaCalificadaException");
		} catch (InscripcionNoExisteException e) {
			System.out.println("InscripcionNoExisteException");
		}
		System.out.println("\n\n\n");
		
		
		/*solo prueba de egresado*/
		System.out.println("--- Egreso a 123 ---");
		try {
			fachada.registrarAsignatura(new VOAsignatura("as1", "Asignatura 1", "Desc As 1"));
			fachada.registrarAsignatura(new VOAsignatura("as2", "Asignatura 2", "Desc As 2"));
			fachada.registrarAsignatura(new VOAsignatura("as3", "Asignatura 3", "Desc As 3"));
			fachada.registrarAsignatura(new VOAsignatura("as4", "Asignatura 4", "Desc As 4"));
			fachada.registrarAsignatura(new VOAsignatura("as5", "Asignatura 5", "Desc As 5"));
			fachada.registrarAsignatura(new VOAsignatura("as6", "Asignatura 6", "Desc As 6"));
			fachada.registrarAsignatura(new VOAsignatura("as7", "Asignatura 7", "Desc As 7"));
			fachada.registrarAsignatura(new VOAsignatura("as8", "Asignatura 8", "Desc As 8"));
			fachada.registrarAsignatura(new VOAsignatura("as9", "Asignatura 9", "Desc As 9"));
			//fachada.registrarAsignatura(new VOAsignatura("as10", "Asignatura 10", "Desc As 10"));
			
			fachada.inscripcionAsignatura(new VOInscripcion(123, "as1", 2018, 1200 ));
			fachada.inscripcionAsignatura(new VOInscripcion(123, "as2", 2018, 1200 ));
			fachada.inscripcionAsignatura(new VOInscripcion(123, "as3", 2018, 1200 ));
			fachada.inscripcionAsignatura(new VOInscripcion(123, "as4", 2018, 1200 ));
			fachada.inscripcionAsignatura(new VOInscripcion(123, "as5", 2018, 1200 ));
			fachada.inscripcionAsignatura(new VOInscripcion(123, "as6", 2018, 1200 ));
			fachada.inscripcionAsignatura(new VOInscripcion(123, "as7", 2018, 1200 ));
			fachada.inscripcionAsignatura(new VOInscripcion(123, "as8", 2018, 1200 ));
			fachada.inscripcionAsignatura(new VOInscripcion(123, "as9", 2018, 1200 ));
			
			fachada.registrarCalificacion(123, 2, 7);
			fachada.registrarCalificacion(123, 3, 8);
			fachada.registrarCalificacion(123, 4, 8);
			fachada.registrarCalificacion(123, 5, 9);
			fachada.registrarCalificacion(123, 6, 12);
			fachada.registrarCalificacion(123, 7, 7);
			fachada.registrarCalificacion(123, 8, 11);
			fachada.registrarCalificacion(123, 9, 6);
			fachada.registrarCalificacion(123, 10, 8);
			
		} catch (AsignaturaYaExisteException | ListaLlenaException | AlumnoNoExisteException | AsignaturaYaAprobadaException | ErrorAnioInscripcionException | AlumnoYaInscriptoException | AsignaturaNoExisteException | InscripcionNoExisteException | AsignaturaYaCalificadaException e1) {
			System.out.println("error por querer egresarlo mas de una vez");
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		/**/
		
		
		
		System.out.println("--- MONTO RECAUDADO ---");
		try {
			System.out.println(fachada.montoRecaudado(123, 2018));
			System.out.println("OK");
		} catch (AlumnoNoExisteException e) {
			System.out.println("AlumnoNoExisteException");
		}
		System.out.println("\n\n\n");
		
		
		
		System.out.println("--- ESCOLARIDAD CORTA ---");
		List<VOEscolaridad> lvoe;
		try {
			lvoe = fachada.escolaridad(123, true);
			for(VOEscolaridad voe : lvoe) {
				System.out.println("numero: " + voe.getNumero() + ", asignatura: " + voe.getAsignaturaNombre() + ", año lectivo: " + voe.getAnioLectivo() );
			}
		} catch (AlumnoNoExisteException e) {
			System.out.println("AlumnoNoExisteException");
		}
		System.out.println("\n\n\n");
		
		
		
		
		System.out.println("--- ESCOLARIDAD LARGA ---");
		try {
			lvoe = fachada.escolaridad(123, false);
			for(VOEscolaridad voe : lvoe) {
				System.out.println("numero: " + voe.getNumero() + ", aignatura: " + voe.getAsignaturaNombre() + ", año lectivo: " + voe.getAnioLectivo() + ", calificacion: " + voe.getCalificacion() + ", monto base: " + voe.getMontoBase() );
			}
			
		} catch (AlumnoNoExisteException e) {
			System.out.println("AlumnoNoExisteException");
		}
		System.out.println("\n\n\n");
		
		
		
		
		System.out.println("--- EGRESADO CORTA ---");
		List<VOEgresado> lvoeg = fachada.listadoEgresados(true);
		for(VOEgresado voeg : lvoeg) {
			System.out.println("cedula: " + voeg.getCedula() + ", nombre: " + voeg.getNombre() + ", apellido: " + voeg.getApellido() + ", promedio aprobacion: " + voeg.getPromedioAprobacion() + ", promedio calificacion: " + voeg.getPromedioCalificacion());
		}
		System.out.println("\n\n\n");
		
		
		
		System.out.println("--- EGRESADO LARGA ---");
		lvoeg = fachada.listadoEgresados(false);
		for(VOEgresado voeg : lvoeg) {
			System.out.println("cedula: " + voeg.getCedula() + ", nombre: " + voeg.getNombre() + ", apellido: " + voeg.getApellido() + ", promedio aprobacion: " + voeg.getPromedioAprobacion() + ", promedio calificacion: " + voeg.getPromedioCalificacion());
		}
		System.out.println("\n\n\n");
		
		
		
		try {
			fachada.respaldar();
		} catch (PersistenciaException e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
