package logica;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import configuracion.Configuracion;
import exception.ConfiguracionException;
import exception.PersistenciaException;
import logica.alumno.Alumnos;
import logica.asignatura.Asignaturas;
import logica.vo.VOFachadaPersistencia;
import persistencia.Persistencia;
import logica.IFachada;
import logica.Monitor;
 


@SuppressWarnings("serial")
public class Fachada extends UnicastRemoteObject implements IFachada {

		private Asignaturas asignaturas;
		private Alumnos alumnos;
		private Monitor monitor;
		
		public Fachada() throws RemoteException {
			asignaturas = new Asignaturas();
			alumnos = new Alumnos();
			monitor = new Monitor();
		}

		@Override
		public void respaldar() throws RemoteException, PersistenciaException, ConfiguracionException {

			VOFachadaPersistencia voFachada;
			String nombreArchivo = Configuracion.getProperty("archivorRespaldo");
			Persistencia persistencia = new Persistencia();
			
			monitor.comienzoLectura();
			
			voFachada = new VOFachadaPersistencia(asignaturas, alumnos);
			
			try {
				persistencia.respaldar(nombreArchivo,voFachada);
			} catch (PersistenciaException e) {
				monitor.terminoLectura();
				throw e;
			}
			
			monitor.terminoLectura();
		}
		
		@Override
		public void recuperar() throws RemoteException, PersistenciaException, ConfiguracionException {
			
			VOFachadaPersistencia voFachada = obtenerArchivoRecuperacion();
			
			monitor.comienzoEscritura();
			
			asignaturas = voFachada.getAsignaturas();
			alumnos = voFachada.getAlumnos();
			
			monitor.terminoEscritura();
		}
		
		private VOFachadaPersistencia obtenerArchivoRecuperacion() throws PersistenciaException, ConfiguracionException {
			
			VOFachadaPersistencia voFachada;
			Persistencia persistencia = new Persistencia();
			String nombreArchivo = Configuracion.getProperty("archivoRespaldo");
			
			voFachada = persistencia.recuperar(nombreArchivo);
			
			return voFachada;
		}
		
}
