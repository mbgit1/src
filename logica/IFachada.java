package logica;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import exception.ListaLlenaException;
import exception.PersistenciaException;
import logica.vo.VOAlumno;
import logica.vo.VOAlumnoListado;
import logica.vo.VOAlumnoModificar;
import logica.vo.VOAsignatura;
import logica.vo.VOBecado;
import logica.vo.VOEgresado;
import logica.vo.VOEscolaridad;



public interface IFachada extends Remote {
	
	public void registrarAsignatura( VOAsignatura voAsignatura) throws RemoteException, ListaLlenaException ;
	
	public void registrarAlumno( VOAlumno voAlumno ) throws RemoteException;
	
	public void registrarBecado( VOBecado voBecado ) throws RemoteException;
	
	public void modificarAlumno( VOAlumnoModificar voAlumnoModificar ) throws RemoteException;
	
	public List<VOAsignatura> listarAsignaturas() throws RemoteException; //revisar si no deberia devolver un vo especifico para el listado
	
	public List<VOAlumnoListado> listarAlumnos( String apellido ) throws RemoteException;
	
	public List<VOAlumno> listadoDetalleAlumnos( int noMeAcuerdo ) throws RemoteException;
	
	public void inscripcionAsignatura( String niIdea1, int niIdea2, VOAlumnoListado voAlumnoListado ) throws RemoteException;
	
	public void registrarCalificacion( int cedula, int niIdea, int nota ) throws RemoteException;
	
	public int montoRecaudado( int cedula, int niIdea ) throws RemoteException;
	
	public List<VOEscolaridad> escolaridad( int cedula, boolean listadCorto ) throws RemoteException;
	
	public List<VOEgresado> listadoEgresados( boolean listadoCorto ) throws RemoteException;
	
	public void respaldar()  throws RemoteException, PersistenciaException, IOException;


/*	
	public void registrarBus(VOBusEntrada voBus)
			throws YaExisteBusException,
			RemoteException, CapacidadInsuficienteException;

	public List<VOBusSalida> listarBuses() throws RemoteException;

	public List<VOExcursionSalida> listarExcursionesBus(String matricula)
			throws BusInexistenteException, RemoteException;

	public void registrarExcursion(VOExcursionEntrada voExcursion)
			throws YaExisteExcursionException, NoHayBusesDisponiblesException,
			RemoteException, PeriodoInvalidoException;

	public void reasignarExcursion(String codigo)
			throws NoExisteExcursionException, NoHayBusesDisponiblesException,
			RemoteException;

	
	public void venderBoleto(VOBoletoEntrada voBoleto)
			throws NoExisteExcursionException,
			NoHayAsientosDisponiblesException, RemoteException;

	public BigDecimal recaudacionExcursion(String codigo)
			throws NoExisteExcursionException, RemoteException;

	public List<VOBoletoSalida> listarBoletosExcursion(String codigo,
			TipoBoleto tipo) throws NoExisteExcursionException, RemoteException;

	public List<VOExcursionSalida> listarExcursionesHacia(String destino) throws RemoteException;

	public List<VOExcursionSalida> listarExcursionesEntrePrecios(
			BigDecimal precioMin, BigDecimal precioMax) throws RemoteException;
*/
}
