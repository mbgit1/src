package cliente;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import configuracion.Configuracion;
import logica.IFachada;
import exception.ConfiguracionException;



public class Cliente {
	
	private static IFachada fachada; 
	
	public static void main (String [] args) {
		
		String ipServidor;
		String puertoServidor;

		try {

			ipServidor = Configuracion.getProperty("ipServidor");
			puertoServidor = Configuracion.getProperty("puertoServidor");
			fachada = (IFachada) Naming.lookup("//" + ipServidor + ":" + puertoServidor + "/fachada");
	//		fachada.listarBuses();
			
		} catch (ConfiguracionException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
	}

}
