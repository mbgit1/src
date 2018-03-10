package grafica.controlador.alumno;

import java.rmi.RemoteException;

import exception.AlumnoNoExisteException;
import grafica.controlador.Controlador;
import grafica.ventana.alumno.AlumnoModificar;
import logica.vo.VOAlumnoDetallado;
import logica.vo.VOAlumnoModificar;

public class ControladorAlumnoModificar extends Controlador {
	
	public ControladorAlumnoModificar( AlumnoModificar alumnoModificar ) {
		super( alumnoModificar );
	}
	
	public void grabar( String cedula, String domicilio, String telefono, String email ) {
		if( cedula.isEmpty() ) {
			showMessageDialog( "La c�dula no puede ser vac�o" );
		}else if( domicilio.isEmpty() ) {
			showMessageDialog( "El domicilio no puede ser vac�o" );
		}else if( telefono.isEmpty() ) {
			showMessageDialog( "El telefono no puede ser vac�o" );
		}else if( email.isEmpty() ) {
			showMessageDialog( "El email no puede ser vac�o" );
		}else if ( !soloNumeros( cedula ) ) {
			showMessageDialog( "La c�dula debe ser num�rica");
		}else if ( !soloNumeros( telefono ) ) {
			showMessageDialog( "El tel�fono debe ser num�rico" );
		}else {
			int intCedula	= Integer.parseInt( cedula );
			int intTelefono	= Integer.parseInt( telefono );
			VOAlumnoModificar voAlumnoModificar = new VOAlumnoModificar( intCedula, domicilio, intTelefono, email );
			try {
				getFachada().modificarAlumno(voAlumnoModificar);
				showMessageDialog( "Alumno modificado" );
				getVentana().dispose();
			} catch (RemoteException e) {
				showMessageDialog( "El servidor est� ca�do" );
			} catch (AlumnoNoExisteException e) {
				showMessageDialog( "El alumno no existe" );
			}			
		}
	}
	
	public VOAlumnoDetallado obtenerAlumno( int cedula ) {
		VOAlumnoDetallado voad = null;
		
		try {
			voad = getFachada().listadoDetalleAlumno( cedula );
		} catch (RemoteException e) {
			showMessageDialog( "El servidor est� ca�do" );
			getVentana().dispose();
		} catch (AlumnoNoExisteException e) {
			showMessageDialog( "El alumno no existe" );
			getVentana().dispose();
		}
		
		return voad;
	}
	
}
