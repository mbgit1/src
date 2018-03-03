package persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import exception.PersistenciaException;
import logica.alumno.Alumnos;
import logica.asignatura.Asignaturas;
import logica.vo.VOFachada;

public class Persistencia {
	
	public static void respaldar ( String nomArch, VOFachada vofachada ) throws PersistenciaException {
		// Abro el archivo y creo un flujo de comunicaci�n hacia �l
		FileOutputStream f;
		try {
			f = new FileOutputStream( nomArch );
			ObjectOutputStream o = new ObjectOutputStream( f );
			
			// Escribo el archivo a trav�s del flujo
			o.writeObject( vofachada );
			o.close();
			f.close();
		} catch (FileNotFoundException e) {
			throw new PersistenciaException("Error el archivo no existe");
		} catch (IOException e) {
			throw new PersistenciaException("Error de lectura del archivo de respaldo");
		}
		
		System.out.println("grabo el archivo");
	}
	
	public static VOFachada recuperar ( String nomArch ) throws IOException, ClassNotFoundException {
		VOFachada voFachada = null;
		
		try {
			// Abro el archivo y creo un flujo de comunicaci�n hacia �l
			FileInputStream f = new FileInputStream( nomArch );
			ObjectInputStream o = new ObjectInputStream(f);
			
			// Leo el arreglo de veh�culos desde el archivo a trav�s del flujo
			voFachada = (VOFachada) o.readObject();
			o.close();
			f.close();
		} catch( java.io.EOFException ex ) {
			System.out.println("el archivo est� vac�o");
		} catch (FileNotFoundException e) {
			System.out.println("el archivo no existe");
		} finally {
			voFachada = new VOFachada( new Asignaturas(), new Alumnos() );
		}
		
		return voFachada;
	}


}