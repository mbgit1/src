package servidor;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import configuracion.Configuracion;
import logica.Fachada;


public class Servidor {
	
	public static void main (String [] args) throws ClassNotFoundException, IOException {
		
		String ipServidor;
		String puertoServidor;

		ipServidor = Configuracion.getProperty("ServidorIp");
		puertoServidor = Configuracion.getProperty("ServidorPuerto");
		
		// pongo a correr el rmiregistry
		LocateRegistry.createRegistry(Integer.parseInt(puertoServidor));
		// instancio mi Objeto Remoto y lo publico
		Fachada fachada = new Fachada();
		System.out.println("Antes de publicar");
		Naming.rebind("//" + ipServidor + ":" + puertoServidor + "/fachada", fachada);
        System.out.println("Luego de publicar");
        
	}
	
}
