package cliente;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;

import configuracion.Configuracion;
import logica.IFachada;


public class Cliente {
	
	private static IFachada fachada; 
	
	public static void main (String [] args) throws FileNotFoundException, IOException, NotBoundException {
		
		String servidorIp;
		String servidorPuerto;

		servidorIp = Configuracion.getProperty("ServidorIp");
		servidorPuerto = Configuracion.getProperty("ServidorPuerto");
		fachada = (IFachada) Naming.lookup("//" + servidorIp + ":" + servidorPuerto + "/fachada");
	
	}

}
