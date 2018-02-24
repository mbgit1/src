package configuracion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import exception.ConfiguracionException;

public final class Configuracion {

	private static final String RUTA_ARCHIVO_CONFIG = "config/config.properties";
	
	private Configuracion() {}
	
	public static String getProperty(String nombre) throws ConfiguracionException {
		
		Properties configuracion = new Properties();
		try {
			configuracion.load (new FileInputStream (RUTA_ARCHIVO_CONFIG));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new ConfiguracionException("No se encontró el archivo");
		} catch (IOException e) {
			e.printStackTrace();
			throw new ConfiguracionException("Error al cargar el archivo");
		}
		
		String propiedad = configuracion.getProperty(nombre);
		
		return propiedad;
	}
	
}
