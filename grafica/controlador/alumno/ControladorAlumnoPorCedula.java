package grafica.controlador.alumno;

import java.rmi.RemoteException;

import exception.AlumnoNoExisteException;
import grafica.controlador.Controlador;
import grafica.ventana.alumno.AlumnoPorCedula;
import logica.vo.VOAlumnoDetallado;

public class ControladorAlumnoPorCedula extends Controlador{
	
	public ControladorAlumnoPorCedula( AlumnoPorCedula ventana ) {
		super( ventana );
	}

	public VOAlumnoDetallado listar( String cedula ) {
		VOAlumnoDetallado voad = null;
		cedula = cedula.trim();
		
		if( cedula.isEmpty() ) {
			showMessageDialog( "La c�dula est� vac�a" );
		} else if( !soloNumeros( cedula ) ) {
			showMessageDialog( "La c�dula debe ser num�rica" );
		} else {
			int intCedula = Integer.parseInt( cedula );
			
			try {
				voad = getFachada().listadoDetalleAlumno( intCedula );
			} catch (RemoteException e) {
				showMessageDialog( "El servicor est� ca�do" );
			} catch (AlumnoNoExisteException e) {
				showMessageDialog( "El alumno no existe" );
			}
		}
		
		return voad;
	}
	
}
