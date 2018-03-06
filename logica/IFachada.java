package logica;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

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
import logica.vo.VOAlumno;
import logica.vo.VOAlumnoDetallado;
import logica.vo.VOAlumnoListado;
import logica.vo.VOAlumnoModificar;
import logica.vo.VOAsignatura;
import logica.vo.VOEgresado;
import logica.vo.VOEscolaridad;
import logica.vo.VOInscripcion;

public interface IFachada extends Remote {
	
	public void registrarAsignatura( VOAsignatura voAsignatura) throws RemoteException, AsignaturaYaExisteException, ListaLlenaException ;
	
	public void registrarAlumno( VOAlumno voAlumno ) throws RemoteException, AlumnoYaExisteException;
	
	public void modificarAlumno( VOAlumnoModificar voAlumnoModificar ) throws RemoteException, AlumnoNoExisteException;
	
	public List<VOAsignatura> listarAsignaturas() throws RemoteException; //revisar si no deberia devolver un vo especifico para el listado
	
	public List<VOAlumnoListado> listarAlumnos( String apellido ) throws RemoteException;
	
	public VOAlumnoDetallado listadoDetalleAlumno( int cedula ) throws AlumnoNoExisteException, RemoteException;
	
	public void inscripcionAsignatura( VOInscripcion voInscripcion ) throws RemoteException, AlumnoNoExisteException, AsignaturaYaAprobadaException, ErrorAnioInscripcionException, AlumnoYaInscriptoException, AsignaturaNoExisteException;

	public void registrarCalificacion( int cedula, int nroInscripcion, int nota ) throws RemoteException, AlumnoNoExisteException, InscripcionNoExisteException, AsignaturaYaCalificadaException ;
	
	public float montoRecaudado( int cedula, int anioLectivo ) throws RemoteException, AlumnoNoExisteException;
	
	public List<VOEscolaridad> escolaridad( int cedula, boolean parcial ) throws RemoteException, AlumnoNoExisteException;
	
	public List<VOEgresado> listadoEgresados( boolean parcial ) throws RemoteException;
	
	public void respaldar()  throws RemoteException, PersistenciaException, FileNotFoundException, IOException;



}
