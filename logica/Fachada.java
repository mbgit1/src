package logica;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import configuracion.Configuracion;
import exception.AsignaturaYaExisteException;
import exception.ListaLlenaException;
import logica.alumno.Alumno;
import logica.alumno.Alumnos;
import logica.asignatura.Asignatura;
import logica.asignatura.Asignaturas;
import logica.vo.VOAlumno;
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
		
		public void registrarAlumno( VOAlumno voAlumno ){
			Alumno alumno = new Alumno( voAlumno.getCedula(), voAlumno.getNombre(), voAlumno.getApellido(), voAlumno.getDomicilio(), voAlumno.getTelefono(), voAlumno.getEmail() );
			/*if( !alumnos.contiene( alumno.getCedula() ) ) {
				alumnos.poner( alumno.getCedula(), alumno);
			}*/
		}
		
		public void registrarBecado( VOBecado voBecado ) {
			
		}
		
		public void modificarAlumno( VOAlumnoModificar voAlumnoModificar ){
			
		}
		
		public List<VOAsignatura> listarAsignaturas(){//revisar si no deberia devolver un vo especifico para el listado
			monitor.comienzoLectura();
			List<VOAsignatura> lista = asignaturas.listarAsignaturas();
			monitor.terminoLectura();
			
			return lista;
		}
		
		public List<VOAlumnoListado> listarAlumnos( String apellido ){
			return null;
		}
		
		public List<VOAlumno> listadoDetalleAlumnos( int noMeAcuerdo ){
			return null;
		}
		
		public void inscripcionAsignatura( String niIdea1, int niIdea2, VOAlumnoListado voAlumnoListado ) {
			
		}
		
		public void registrarCalificacion( int cedula, int niIdea, int nota ) {
			
		}
		
		public int montoRecaudado( int cedula, int niIdea ) {
			return 1;
		}
		
		public List<VOEscolaridad> escolaridad( int cedula, boolean listadCorto ){
			return null;
		}
		
		public List<VOEgresado> listadoEgresados( boolean listadoCorto ){
			return null;
		}
		
}
