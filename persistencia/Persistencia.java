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
		// Abro el archivo y creo un flujo de comunicación hacia él
		FileOutputStream f;
		try {
			f = new FileOutputStream( nomArch );
			ObjectOutputStream o = new ObjectOutputStream( f );
			
			// Escribo el archivo a través del flujo
			o.writeObject( vofachada );
			o.close();
			f.close();
		} catch (FileNotFoundException e) {
			throw new PersistenciaException("Error el archivo no existe");
		} catch (IOException e) {
			throw new PersistenciaException("Error de lectura del archivo de respaldo");
		}
	}
	
	public static VOFachada recuperar ( String nomArch ) throws IOException, ClassNotFoundException {
		VOFachada voFachada = null;
		
		try {
			// Abro el archivo y creo un flujo de comunicación hacia él
			FileInputStream f = new FileInputStream( nomArch );
			ObjectInputStream o = new ObjectInputStream(f);
			
			voFachada = (VOFachada) o.readObject();
			o.close();
			f.close();
		} catch( java.io.EOFException ex ) {
			System.out.println("el archivo está vacío");
			voFachada = new VOFachada( new Asignaturas(), new Alumnos() );
		} catch (FileNotFoundException e) {
			System.out.println("el archivo no existe");
			voFachada = new VOFachada( new Asignaturas(), new Alumnos() );
		}
		
		return voFachada;
	}


}