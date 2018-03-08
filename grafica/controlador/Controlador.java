package grafica.controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;

import configuracion.Configuracion;
import grafica.ventana.Ventana;
import logica.IFachada;

public abstract class Controlador {
	
	protected Ventana ventana;
	protected IFachada fachada;
	
	public Controlador( Ventana ventana) {
		this.ventana = ventana;
		
		String servidorIp;
		String servidorPuerto;

		try {
			servidorIp = Configuracion.getProperty("ServidorIp");
			servidorPuerto = Configuracion.getProperty("ServidorPuerto");
			fachada = (IFachada) Naming.lookup("//" + servidorIp + ":" + servidorPuerto + "/fachada");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			showMessageDialog( "Falta el archivo de configuración" );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("antesde llamar al show");
			showMessageDialog( "El error al leer el archivo de configuración" );
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			showMessageDialog( "El servidor está caído" );
		}
		
	}
	
	public void showMessageDialog( String string ) {
		//System.out.println("mensaje en controlador?: " + string);
	}

}
