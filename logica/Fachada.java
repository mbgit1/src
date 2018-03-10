package logica;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
import exception.ListaLlenaException;
import exception.PersistenciaException;
import logica.alumno.Alumno;
import logica.alumno.Alumnos;
import logica.alumno.Becado;
import logica.asignatura.Asignatura;
import logica.asignatura.Asignaturas;
import logica.inscripcion.Inscripcion;
import logica.vo.VOAlumno;
import logica.vo.VOAlumnoDetallado;
import logica.vo.VOAlumnoListado;
import logica.vo.VOAlumnoModificar;
import logica.vo.VOAsignatura;
import logica.vo.VOBecado;
import logica.vo.VOEgresado;
import logica.vo.VOEscolaridad;
import logica.vo.VOFachada;
import logica.vo.VOInscripcion;
import persistencia.Persistencia;
import logica.IFachada;
import logica.Monitor;
import exception.InscripcionNoExisteException;

@SuppressWarnings("serial")
public class Fachada extends UnicastRemoteObject implements IFachada {

	private Asignaturas asignaturas;
	private Alumnos alumnos;
	private Monitor monitor;

	public Fachada() throws RemoteException, IOException, ClassNotFoundException {
		VOFachada voFachadaPersistencia;
		
		try {
			voFachadaPersistencia = Persistencia.recuperar( Configuracion.getProperty("ArchivoRespaldo") );

			if ( voFachadaPersistencia != null ) {
				asignaturas = voFachadaPersistencia.getAsignaturas();
				alumnos = voFachadaPersistencia.getAlumnos();
			}

			monitor = new Monitor();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(4);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(5);
		}
	}


	//Requerimiento 1: Registro de Asignatura		
	public void registrarAsignatura( VOAsignatura voAsignatura) throws AsignaturaYaExisteException, ListaLlenaException {
		monitor.comienzoEscritura();
		
		Asignatura asignatura = new Asignatura( voAsignatura.getCodigo(), voAsignatura.getNombre(), voAsignatura.getDescripcion() );
		if(asignaturas.estaLlena() ) {
			monitor.terminoEscritura();
			throw new ListaLlenaException();
		}
		else {

			if(asignaturas.existeAsignatura(asignatura.getCodigo())) {
				monitor.terminoEscritura();
				throw new AsignaturaYaExisteException();

			}
		}
		
		asignaturas.addAsignatura( asignatura );
		monitor.terminoEscritura();
	}


	//Requerimiento 2:Inscripcion de Alumno	

	public void registrarAlumno( VOAlumno voAlumno ) throws AlumnoYaExisteException{
		monitor.comienzoEscritura();
	
		Alumno alumno;
		
		if(alumnos.contiene( voAlumno.getCedula()) ) {
			monitor.terminoEscritura();
			throw new AlumnoYaExisteException("Ya se registro un alumno con la misma cedula");
		}
		else {
			if(voAlumno instanceof VOBecado) {
				alumno = new Becado( voAlumno.getCedula(), voAlumno.getNombre(), voAlumno.getApellido(), voAlumno.getDomicilio(), voAlumno.getTelefono(), voAlumno.getEmail(), ((VOBecado)voAlumno).getDescuento(), ((VOBecado)voAlumno).getDescripcion() );
			}else {
				alumno = new Alumno( voAlumno.getCedula(), voAlumno.getNombre(), voAlumno.getApellido(), voAlumno.getDomicilio(), voAlumno.getTelefono(), voAlumno.getEmail() );
			}
				
			alumnos.addAlumno(alumno); 			
		}
		
		monitor.terminoEscritura();
	}



	//Requerimiento 3: Modificacion de datos de alumno		
	public void modificarAlumno( VOAlumnoModificar voAlumnoModificar ) throws AlumnoNoExisteException{
		monitor.comienzoEscritura();
		
		Alumno alumno = null;

		if(!alumnos.contiene(voAlumnoModificar.getCedula())) {
			monitor.terminoEscritura();
			throw new AlumnoNoExisteException("No existe un alumno con esa cedula");
		}	
		else {
			alumno = alumnos.obtener(voAlumnoModificar.getCedula());
			alumno.modificarAlumno(voAlumnoModificar.getDomicilio(), voAlumnoModificar.getTelefono(), voAlumnoModificar.getEmail());
			
		}
		
		monitor.terminoEscritura();
	}

	//Requerimiento 4: Listado de asignaturas
	public List<VOAsignatura> listarAsignaturas(){

		monitor.comienzoLectura();
		List<VOAsignatura> listaAsignaturas = null;

		listaAsignaturas = asignaturas.listarAsignaturas();
		monitor.terminoLectura();

		return listaAsignaturas;
	}

	//Requerimiento 5:Listado de alumnos por apellido

	public List<VOAlumnoListado> listarAlumnos( String apellido ){
		monitor.comienzoLectura();
		
		List<VOAlumnoListado> listarAlumnos = alumnos.listarAlumnosPorApellido(apellido);
		
		monitor.terminoLectura();
		return listarAlumnos;
	}

	//Requerimiento 6: Listado detallado por cedula
	public VOAlumnoDetallado listadoDetalleAlumno( int cedula ) throws AlumnoNoExisteException{
		monitor.comienzoLectura();
		
		VOAlumnoDetallado voad = null;
		 
		//EL VALOR DE CUOTA VA EN CERO, PORQUE LUEGO DE HABLAR CON EL TUTOR SE DECIDIO QUE ERA UN REQUERIMIENTO
		//AMBIGUO Y SIN SENTIDO DEVOLVER ESE VALOR. 
		if(!alumnos.contiene(cedula)) {
			monitor.terminoLectura();
			throw new AlumnoNoExisteException("No existe un alumno con esa cedula");
		}	
		else {
			Alumno alumno = alumnos.obtener(cedula);
			voad = alumno.listadoDetalleAlumno(); 
		}
		
		monitor.terminoLectura();
		return voad;
	}

	//Requerimiento 7: Inscripcion a asignatura
	public void inscripcionAsignatura( VOInscripcion voInscripcion )throws AlumnoNoExisteException, AsignaturaYaAprobadaException, ErrorAnioInscripcionException, AlumnoYaInscriptoException, AsignaturaNoExisteException {
		monitor.comienzoEscritura();
		
		if(!alumnos.contiene( voInscripcion.getCedula()) ) {
			monitor.terminoEscritura();
			throw new AlumnoNoExisteException("No existe alumno con la misma cedula");
		}
		else {
			if(!asignaturas.existeAsignatura(voInscripcion.getCodigo()) ) {

				monitor.terminoEscritura();
				throw new AsignaturaNoExisteException("La asignatura no existe");
			}

			else {
				Alumno alumno = alumnos.obtener(voInscripcion.getCedula());
				if(alumno.asignaturaAprobada(voInscripcion.getCodigo())) {
					monitor.terminoEscritura();
					throw new AsignaturaYaAprobadaException("La asignatura ya fue aprobada");

				}
				else {
					if(alumno.asignaturaEnCurso(voInscripcion.getCodigo(), voInscripcion.getAnioLectivo())) {
						monitor.terminoEscritura();
						throw new AlumnoYaInscriptoException("El alumno ya esta inscripto a dicha asignatura");

					}
					else {

						if(!alumno.anioInscripcionValido(voInscripcion.getAnioLectivo())){
							monitor.terminoEscritura();
							throw new ErrorAnioInscripcionException("El anio de para la inscripcion no es correcto");	
						}
						else {
							//creo nueva inscripcion con (numeroInscripcion,anioLectivo,MontoBase,calificacion,Asignatura)
							Inscripcion nuevaIns = new Inscripcion(alumno.ultimaInscripcion() +1,voInscripcion.getAnioLectivo(),voInscripcion.getMontoBase(),asignaturas.obtenerAsignatura(voInscripcion.getCodigo()));
							alumno.addInscripcion(nuevaIns);
						}

					}
				}

			}

		}

		monitor.terminoEscritura();
	}


	//Requerimiento 8: Registro de resultado de una asignatura		
	public void registrarCalificacion( int cedula, int nroInscripcion, int nota ) throws AlumnoNoExisteException, InscripcionNoExisteException, AsignaturaYaCalificadaException {
		monitor.comienzoEscritura();

		if(!alumnos.contiene( cedula) ) {
			monitor.terminoEscritura();
			throw new AlumnoNoExisteException("No existe  alumno con la misma cedula");
		}
		else {
			Alumno alumno = alumnos.obtener(cedula);

			if(alumno.ultimaInscripcion() < nroInscripcion) { //chequea que exista ese nro de inscripcion

				monitor.terminoEscritura();
				throw new InscripcionNoExisteException("No existe una inscripcion con ese numero para el alumno");
			}
			else {

				Inscripcion i = alumno.obtenerInscripcion(nroInscripcion);
				if(i.getCalificacion()>0) {
					monitor.terminoEscritura();
					throw new AsignaturaYaCalificadaException();

				}
				else {
					i.setCalificacion(nota);
				}

			}


		}
		
		monitor.terminoEscritura();
	}

	//Requerimiento 9: Monto recaudado por inscripciones
	public float montoRecaudado( int cedula, int anioLectivo )throws AlumnoNoExisteException {
		monitor.comienzoLectura();
		
		float recaudacion = 0;
		if(!alumnos.contiene( cedula) ) {
			monitor.terminoLectura();
			throw new AlumnoNoExisteException("No existe  alumno con la misma cedula");
		}
		else {
			Alumno alumno = alumnos.obtener(cedula);
			recaudacion = alumno.montoRecaudado(anioLectivo);
			/*
			if(alumno instanceof Becado) {
				Becado becado  =  (Becado) alumnos.obtener(cedula);
				recaudacion = becado.montoRecaudado(anioLectivo);
			}
			else {
				recaudacion = alumno.montoRecaudado(anioLectivo);
			}
			*/
		}
		
		monitor.terminoLectura();
		return recaudacion;
	}
	
	//Requerimiento 10: Respaldo de datos
	public void respaldar() throws PersistenciaException, FileNotFoundException, IOException {
		monitor.comienzoEscritura();

		VOFachada voFachada = new VOFachada( asignaturas, alumnos );
		Persistencia.respaldar( Configuracion.getProperty("ArchivoRespaldo"), voFachada );

		monitor.terminoEscritura();
	}

	//Requerimiento 11: Consulta de escolaridad
	public List<VOEscolaridad> escolaridad( int cedula, boolean parcial )throws AlumnoNoExisteException {
		monitor.comienzoLectura();
		
		List<VOEscolaridad> listaVoe = null; 
		if(!alumnos.contiene(cedula) ) {
			monitor.terminoLectura();
			throw new AlumnoNoExisteException("No existe  alumno con esa cedula");
		}
		else {	
			Alumno alumno = alumnos.obtener(cedula);

			listaVoe =  alumno.escolaridad(parcial);
		
		}
		
		monitor.terminoLectura();
		return listaVoe;
	}


	//Requerimiento 12: Listado de egresados
	public List<VOEgresado> listadoEgresados( boolean parcial ){
		monitor.comienzoLectura();
		
		List<VOEgresado> listaEgre = null;
		listaEgre =  alumnos.listadoEgresados(parcial);
		
		monitor.terminoLectura(); 
		return listaEgre;
	}

}

