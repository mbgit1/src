package logica;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import exception.ConfiguracionException;
import exception.PersistenciaException;



public interface IFachada extends Remote {
	
	
	public void respaldar() throws PersistenciaException, RemoteException, ConfiguracionException;

	public void recuperar() throws PersistenciaException, RemoteException, ConfiguracionException;

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
