package grafica.controlador.inscripciones;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import exception.AlumnoNoExisteException;
import grafica.ventana.inscripciones.InscripcionesListado;
import grafica.controlador.Controlador;

import exception.AlumnoNoExisteException;

public class ControladorInscripcionesListado extends Controlador {
	
	
	
	public ControladorInscripcionesListado( InscripcionesListado inscripcionesListado) {
		super( inscripcionesListado );
	}
	
	public List<logica.vo.VOEscolaridad> listarInscripciones( String cedulaStr, boolean modo ){
		List<logica.vo.VOEscolaridad> lvoe = null;
		
		if (cedulaStr.trim().isEmpty()) {
			showMessageDialog( "La c�dula no puede ser vac�o" );	
			
		}else if(!soloNumeros(cedulaStr)){			
			showMessageDialog( "La c�dula debe ser num�rica");		
			
		}else {
			int cedula = Integer.parseInt( cedulaStr );
			
			try {
				lvoe = getFachada().escolaridad(cedula, modo);
				
			} catch (AlumnoNoExisteException e) {
				showMessageDialog("AlumnoNoExisteException");
				
			} catch (RemoteException e) {
				showMessageDialog( "El servidor est� ca�do" );
			}
						
		}
		
		return lvoe;
		
	}
	
	@Override
	public void showMessageDialog( String string ) {
		getVentana().showMessageDialog( string );
	}

}
