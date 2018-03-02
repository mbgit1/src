package prueba;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.List;

import configuracion.Configuracion;
import exception.AlumnoNoExisteException;
import exception.AlumnoYaExisteException;
import exception.AsignaturaYaExisteException;
import exception.ListaLlenaException;
import exception.PersistenciaException;
import logica.Fachada;
import logica.IFachada;
import logica.vo.VOAlumno;
import logica.vo.VOAlumnoDetallado;
import logica.vo.VOAlumnoListado;
import logica.vo.VOAlumnoModificar;
import logica.vo.VOAsignatura;
import logica.vo.VOBecado;
import logica.vo.VOEgresado;
import logica.vo.VOEscolaridad;
import servidor.Servidor;

public class TestFachada {
	
	public static void main(String args[]) throws FileNotFoundException, IOException, NotBoundException {
		
		/*
		//Servidor servidor = new Servidor();
		try {
			Servidor.main(args);
		} catch (ClassNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		*/
		
		String servidorIp;
		String servidorPuerto;

		servidorIp = Configuracion.getProperty("ServidorIp");
		servidorPuerto = Configuracion.getProperty("ServidorPuerto");
		IFachada fachada = (IFachada) Naming.lookup("//" + servidorIp + ":" + servidorPuerto + "/fachada");
		
		int cantErrores = 0;
		
		
		VOAsignatura voAsignatura = new VOAsignatura("MD", "Matemática discreta", "difícil");
		try {
			fachada.registrarAsignatura(voAsignatura);
		} catch (ListaLlenaException | AsignaturaYaExisteException e) {
			System.out.println("la lista esta llena");
			cantErrores ++;
			e.printStackTrace();
		}
		
		
		
		VOAlumno voAlumno= new VOAlumno(123, "Guille", "Osores", "calle falsa 1234", 12345, "a@a.com");
		try {
			fachada.registrarAlumno(voAlumno);
		} catch (AlumnoYaExisteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
		VOBecado voBecado= new VOBecado(456, "Gabriel", "Novasco", "cuidad de la costa", 415, "gatutus@gmail.com", 30, "treinta");
		fachada.registrarBecado(voBecado);
		
		
		
		VOAlumnoModificar voAlumnoModificar = new VOAlumnoModificar(123, "mi casa 123", 6543, "elguille@gmail.com");
		try {
			fachada.modificarAlumno(voAlumnoModificar);
		} catch (AlumnoNoExisteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		System.out.println("--- LISTADO DE ASIGNATURAS ---");
		List<VOAsignatura> lvoa = fachada.listarAsignaturas();
		for(VOAsignatura voa : lvoa) {
			System.out.println("codigo: " + voa.getCodigo() + ", nombre: " + voa.getNombre() + ", descripcion: " + voa.getDescripcion());
		}
		System.out.println("\n\n\n");
		
		
		/*
		System.out.println("--- LISTADO DE ALUMNOS POR APELLIDO---");
		List<VOAlumnoListado> lvoalL = fachada.listarAlumnos("so");
		for(VOAlumnoListado voa : lvoalL) {
			System.out.println("cedula: " + voa.getCedula() + ", nombre: " + voa.getNombre() + ", apellido: " + voa.getApellido());
		}
		System.out.println("\n\n\n");
		*/
		
		
		System.out.println("--- LISTADO DETALLE ALUMNOS---");
		VOAlumnoDetallado voad;
		try {
			voad = fachada.listadoDetalleAlumno(123);
			System.out.println("cedula: " + voad.getCedula() + ", nombre: " + voad.getNombre() + ", apellido: " + voad.getApellido() + ", domicilio: " + voad.getDomicilio() + ", telefono: " + voad.getTelefono() + ", email: " + voad.getEmail() + ", monto cuota: " + voad.getMontoCuota() + ", tipo: " + voad.getTipo());
			System.out.println("\n\n\n");
		} catch (AlumnoNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		

		/*
		VOAlumnoListado voal = lvoalL.get(0);
		fachada.inscripcionAsignatura("MD", 2017, voal);
		*/
		
		
		fachada.registrarCalificacion(123, 1, 10);
		
		
		
		fachada.montoRecaudado(123, 0);
		
		
		
		System.out.println("--- ESCOLARIDAD CORTA ---");
		List<VOEscolaridad> lvoe = fachada.escolaridad(123, true);
		for(VOEscolaridad voe : lvoe) {
			System.out.println("numero: " + voe.getNumero() + ", aignatura: " + voe.getAsignaturaNombre() + ", año lectivo: " + voe.getAnioLectivo() + ", calificacion: " + voe.getCalificacion() + ", monto base: " + voe.getMontoBase() );
		}
		System.out.println("\n\n\n");
		
		
		
		System.out.println("--- ESCOLARIDAD LARGA ---");
		lvoe = fachada.escolaridad(123, false);
		for(VOEscolaridad voe : lvoe) {
			System.out.println("numero: " + voe.getNumero() + ", aignatura: " + voe.getAsignaturaNombre() + ", año lectivo: " + voe.getAnioLectivo() + ", calificacion: " + voe.getCalificacion() + ", monto base: " + voe.getMontoBase() );
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
		
		
		/*
		try {
			fachada.respaldar();
		} catch (PersistenciaException e) {
			System.out.println("Error al persistir");
			e.printStackTrace();
		}
		*/
		
		
	}

}
