package prueba;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import cliente.Cliente;
import configuracion.Configuracion;
import exception.ListaLlenaException;
import exception.PersistenciaException;
import logica.IFachada;
import logica.vo.VOAsignatura;

public class Pruebas {

	private static IFachada fachada;
	
	public static void main( String args[]) {
		String servidorIp;
		String servidorPuerto;

		try {
			servidorIp = Configuracion.getProperty("ServidorIp");
			servidorPuerto = Configuracion.getProperty("ServidorPuerto");
			fachada = (IFachada) Naming.lookup("//" + servidorIp + ":" + servidorPuerto + "/fachada");
		} catch (IOException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		/*
		try {
			VOAsignatura voAsignatura = new VOAsignatura( "MD", "Matematica Discreta", "la peor" );
			fachada.registrarAsignatura( voAsignatura );
			fachada.respaldar();
		} catch (RemoteException | ListaLlenaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PersistenciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		try {
			List<VOAsignatura> listVoAsignatura = fachada.listarAsignaturas();
			for( VOAsignatura voAsignatura : listVoAsignatura) {
				System.out.println( "nombre: " + voAsignatura.getCodigo() + ", nombre: " + voAsignatura.getNombre() + ", descripcion: " + voAsignatura.getDescripcion() );
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
