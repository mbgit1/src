package servidor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import configuracion.Configuracion;
import logica.Fachada;


public class Servidor {
	
	public static void main (String [] args) {
		
		String ipServidor;
		String puertoServidor;

		try {
			
			ipServidor = Configuracion.getProperty("ServidorIp");
			puertoServidor = Configuracion.getProperty("ServidorPuerto");
			
			LocateRegistry.createRegistry(Integer.parseInt(puertoServidor));
			Fachada fachada = new Fachada();
			Naming.rebind("//" + ipServidor + ":" + puertoServidor + "/fachada", fachada);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(2);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(3);
		}

        System.out.println("Corriendo... ");
        
	}
	
}
