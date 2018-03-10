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
			showMessageDialog( "La cédula no puede ser vacío" );
		}else if( domicilio.isEmpty() ) {
			showMessageDialog( "El domicilio no puede ser vacío" );
		}else if( telefono.isEmpty() ) {
			showMessageDialog( "El telefono no puede ser vacío" );
		}else if( email.isEmpty() ) {
			showMessageDialog( "El email no puede ser vacío" );
		}else if ( !soloNumeros( cedula ) ) {
			showMessageDialog( "La cédula debe ser numérica");
		}else if ( !soloNumeros( telefono ) ) {
			showMessageDialog( "El teléfono debe ser numérico" );
		}else {
			int intCedula	= Integer.parseInt( cedula );
			int intTelefono	= Integer.parseInt( telefono );
			VOAlumnoModificar voAlumnoModificar = new VOAlumnoModificar( intCedula, domicilio, intTelefono, email );
			try {
				getFachada().modificarAlumno(voAlumnoModificar);
				showMessageDialog( "Alumno modificado" );
				getVentana().dispose();
			} catch (RemoteException e) {
				showMessageDialog( "El servidor está caído" );
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
			showMessageDialog( "El servidor está caído" );
			getVentana().dispose();
		} catch (AlumnoNoExisteException e) {
			showMessageDialog( "El alumno no existe" );
			getVentana().dispose();
		}
		
		return voad;
	}
	
}
