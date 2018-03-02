package logica;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import configuracion.Configuracion;
import exception.AlumnoNoExisteException;
import exception.AlumnoYaExisteException;
import exception.AsignaturaYaExisteException;
import exception.ListaLlenaException;
import logica.alumno.Alumno;
import logica.alumno.Alumnos;
import logica.asignatura.Asignatura;
import logica.asignatura.Asignaturas;
import logica.inscripcion.Inscripciones;
import logica.vo.VOAlumno;
import logica.vo.VOAlumnoDetallado;
import logica.vo.VOAlumnoListado;
import logica.vo.VOAlumnoModificar;
import logica.vo.VOAsignatura;
import logica.vo.VOBecado;
import logica.vo.VOEgresado;
import logica.vo.VOEscolaridad;
import logica.vo.VOFachada;
import persistencia.Persistencia;
import logica.IFachada;
import logica.Monitor;
 


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
					asignaturas = new Asignaturas( voFachadaPersistencia.getAsignaturas() );
					alumnos = new Alumnos( voFachadaPersistencia.getAlumnos() );
				}else {
					asignaturas = new Asignaturas();
					alumnos = new Alumnos();
				}
				
				monitor = new Monitor();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		/*
		public void respaldar() throws RemoteException, IOException {
			monitor.comienzoEscritura();
			
			VOFachada voFachada = new VOFachada( asignaturas, alumnos );
			Persistencia.respaldar( Configuracion.getProperty("ArchivoRespaldo"), voFachada );
			
			monitor.terminoEscritura();
		}
		
		public void registrarAsignatura( VOAsignatura voAsignatura) throws ListaLlenaException, AsignaturaYaExisteException {
			monitor.comienzoEscritura();
			
			if( !asignaturas.estaLlena() ) {
				if( !asignaturas.existeAsignatura( voAsignatura.getCodigo() ) ) {
					Asignatura asignatura = new Asignatura( voAsignatura.getCodigo(), voAsignatura.getNombre(), voAsignatura.getDescripcion() );
					asignaturas.addAsignatura( asignatura );
				}else {
					monitor.terminoEscritura();
					throw new AsignaturaYaExisteException();
				}
			}else {
				monitor.terminoEscritura();
				throw new ListaLlenaException();
			}
			
			monitor.terminoEscritura();
		}
*/
		//Requerimiento 1: Registro de Asignatura		
				public void registrarAsignatura( VOAsignatura voAsignatura) throws AsignaturaYaExisteException, ListaLlenaException {
					
					monitor.comienzoEscritura();
					Asignatura asignatura = new Asignatura( voAsignatura.getCodigo(), voAsignatura.getNombre(), voAsignatura.getDescripcion() );
					if(asignaturas.estaLlena() ) {
						monitor.terminoEscritura();
						throw new ListaLlenaException("Ya se ingresaron 10 asignaturas");
					}
					else {
						
						if(asignaturas.existeAsignatura(asignatura.getCodigo())) {
							monitor.terminoEscritura();
							throw new AsignaturaYaExisteException("Ya existe una asignatura con el mismo codigo");
							
						}
					}
					asignaturas.addAsignatura( asignatura );
					monitor.terminoEscritura();
				}
				
				
		//Requerimiento 2:Inscripcion de Alumno	
				
				public void registrarAlumno( VOAlumno voAlumno ) throws AlumnoYaExisteException{
					
					monitor.comienzoEscritura();
					Alumno alumno = new Alumno( voAlumno.getCedula(), voAlumno.getNombre(), voAlumno.getApellido(), voAlumno.getDomicilio(), voAlumno.getTelefono(), voAlumno.getEmail() );
					
					if(alumnos.contiene( Integer.toString(alumno.getCedula()) ) ) {
						monitor.terminoEscritura();
						throw new AlumnoYaExisteException("Ya se registro un alumno con la misma cedula");
					}
					else {
						//la pregunta de si es becado o no, la  hace el metodo addAlumno en Alumnos
					    alumnos.addAlumno(alumno); 
					    monitor.terminoEscritura();
					}
		         }
				

				
		//Requerimiento 3: Modificacion de datos de alumno		
				public void modificarAlumno( VOAlumnoModificar voAlumnoModificar ) throws AlumnoNoExisteException{
					
					monitor.comienzoEscritura();
					Alumno alumno = alumnos.obtener(Integer.toString(voAlumnoModificar.getCedula()));
					 
					if(!alumnos.contiene(Integer.toString(voAlumnoModificar.getCedula()))) {
						monitor.terminoEscritura();
						throw new AlumnoNoExisteException("No existe un alumno con esa cedula");
					}	
					else {
						
						alumno.modificarAlumno(alumno.getDomicilio(),alumno.getTelefono(),alumno.getEmail());
						monitor.terminoEscritura();
					}
		
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
					List<VOAlumnoListado> listarAlumnos = null;
					listarAlumnos=  alumnos.listarAlumnosPorApellido(apellido);
					monitor.terminoLectura();
					return listarAlumnos;
				}
				
		//Requerimiento 6: Listado detallado por cedula
				public VOAlumnoDetallado listadoDetalleAlumno( int cedula ) throws AlumnoNoExisteException{
					 
					monitor.comienzoLectura();
					Alumno alumno = alumnos.obtener(Integer.toString(cedula));
					VOAlumnoDetallado voad = new VOAlumnoDetallado(0," "," "," ",0," ",0," "); 
					if(!alumnos.contiene(Integer.toString(cedula))) {
						monitor.terminoLectura();
						throw new AlumnoNoExisteException("No existe un alumno con esa cedula");
					}	
					else {
						
						voad = alumno.listadoDetalleAlumno(); 
						 
						
					}
					monitor.terminoLectura();
					return voad;
				}

		//Requerimiento 7: Inscripcion a asignatura
				public void inscripcionAsignatura( String codigo, int cedula, VOAlumnoListado voAlumnoListado ) {
				//lo dejo para hacerlo con lo de gaby.. cuando lo baje
				}
				
				
		//Requerimiento 8: Registro de resultado de una asignatura		
				public void registrarCalificacion( int cedula, int nroInscripcion, int nota ) {
					monitor.comienzoEscritura();
					Alumno alumno = alumnos.obtener(Integer.toString(cedula));
					Inscripciones inscripciones = (Inscripciones) alumno.getInscripciones();
					
					inscripciones.registrarCalificacion(nroInscripcion, nota); 	
					monitor.terminoEscritura();
				}
				
		//Requerimiento 9: Monto recaudado por inscripciones
				public int montoRecaudado( int cedula, int anioLectivo ) {
					monitor.comienzoLectura();
					Alumno alumno = alumnos.obtener(Integer.toString(cedula));
					monitor.terminoLectura();
					return alumno.montoRecaudado(anioLectivo);
					
				}
		//Requerimiento 10: Respaldo de datos
				public void respaldar() throws RemoteException, IOException {
					monitor.comienzoEscritura();
					
					VOFachada voFachada = new VOFachada( asignaturas, alumnos );
					Persistencia.respaldar( Configuracion.getProperty("ArchivoRespaldo"), voFachada );
					
					monitor.terminoEscritura();
				}

		//Requerimiento 11: Consulta de escolaridad
				public List<VOEscolaridad> escolaridad( int cedula, boolean parcial ){
					monitor.comienzoLectura();
					List<VOEscolaridad> listaVoe = null; 
					Alumno alumno = alumnos.obtener(Integer.toString(cedula));
					
					listaVoe =  alumno.escolaridad(parcial);
					monitor.terminoLectura();
					return listaVoe;
				}

				
		//Requerimiento 12: Listado de egresados
				public List<VOEgresado> listadoEgresados( boolean parcial ){
					monitor.comienzoLectura();
					List<VOEgresado> listaEgre = null;
					monitor.terminoLectura();
					listaEgre =  alumnos.listadoEgresados(parcial); 
					monitor.terminoLectura(); 
					return listaEgre;
				}
				
		}
		
