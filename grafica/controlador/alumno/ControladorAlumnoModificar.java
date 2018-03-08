package grafica.controlador.alumno;

import java.rmi.RemoteException;

import exception.AlumnoNoExisteException;
import grafica.controlador.Controlador;
import grafica.ventana.alumno.AlumnoModificar;
import logica.vo.VOAlumnoDetallado;
import logica.vo.VOAlumnoModificar;

public class ControladorAlumnoModificar extends Controlador {

	//AlumnoModificar ventana;
	
	public ControladorAlumnoModificar( AlumnoModificar alumnoModificar ) {
		super( alumnoModificar );
		//ventana = alumnoModificar;
	}
	
	public void grabar( int cedula, String domicilio, int telefono, String email ) {
		showMessageDialog( "domicilio en controlador: " + domicilio);
		VOAlumnoModificar voAlumnoModificar = new VOAlumnoModificar( cedula, domicilio, telefono, email );
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
	
	@Override
	public void showMessageDialog( String string ) {
		//System.out.println("mensaje?: " + string);
		getVentana().showMessageDialog( string );
	}
	
	public VOAlumnoDetallado obtenerAlumno( int cedula ) {
		VOAlumnoDetallado voad = null;
		
		try {
			voad = getFachada().listadoDetalleAlumno( cedula );
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			showMessageDialog( "El servidor está caído" );
			getVentana().dispose();
		} catch (AlumnoNoExisteException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			showMessageDialog( "El alumno no existe" );
			getVentana().dispose();
		}
		
		return voad;
	}
	
}
