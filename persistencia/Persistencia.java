package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import logica.alumno.Alumnos;
import logica.asignatura.Asignaturas;
import logica.vo.VOFachada;

public class Persistencia {
	
	public static void respaldar ( String nomArch, VOFachada vofachada ) throws IOException {
		// Abro el archivo y creo un flujo de comunicaci�n hacia �l
		FileOutputStream f = new FileOutputStream( nomArch );
		ObjectOutputStream o = new ObjectOutputStream( f );
		
		// Escribo el arreglo de veh�culos en el archivo a trav�s del flujo
		o.writeObject( vofachada );
		o.close();
		f.close();
	}
	
	public static VOFachada recuperar ( String nomArch ) throws IOException, ClassNotFoundException {
		VOFachada voFachada;
		
		try {
			// Abro el archivo y creo un flujo de comunicaci�n hacia �l
			FileInputStream f = new FileInputStream( nomArch );
			ObjectInputStream o = new ObjectInputStream(f);
			
			// Leo el arreglo de veh�culos desde el archivo a trav�s del flujo
			voFachada = (VOFachada) o.readObject();
			o.close();
			f.close();
		} catch( java.io.EOFException ex ) {
			//no hay info grabada
		} finally {
			voFachada = new VOFachada( new Asignaturas(), new Alumnos() );
		}
		
		return voFachada;
	}


}