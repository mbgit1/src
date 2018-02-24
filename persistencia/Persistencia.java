package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import exception.PersistenciaException;
import logica.vo.VOFachadaPersistencia;

public class Persistencia {
	
	public void respaldar (String nomArch, VOFachadaPersistencia fachada) throws PersistenciaException {
		try
		{ // Abro el archivo y creo un flujo de comunicación hacia él
			FileOutputStream f = new FileOutputStream(nomArch);
			ObjectOutputStream o = new ObjectOutputStream(f);
			// Escribo el arreglo de vehículos en el archivo a través del flujo
			o.writeObject (fachada);
			o.close();
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new PersistenciaException("error respaldar");
		}
	}
	
	public VOFachadaPersistencia recuperar (String nomArch) throws PersistenciaException {
		try
		{ // Abro el archivo y creo un flujo de comunicación hacia él
			FileInputStream f = new FileInputStream(nomArch);
			ObjectInputStream o = new ObjectInputStream(f);
			// Leo el arreglo de vehículos desde el archivo a través del flujo
			VOFachadaPersistencia fachada = (VOFachadaPersistencia) o.readObject();
			o.close();
			f.close();
			return fachada;
		}
			catch (IOException e)
		{ 
				e.printStackTrace();
				throw new PersistenciaException("error recuperar");
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw new PersistenciaException("error recuperar");
			}
	}


}