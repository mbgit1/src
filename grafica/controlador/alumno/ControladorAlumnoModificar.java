package grafica.controlador.alumno;

import java.rmi.RemoteException;

import exception.AlumnoNoExisteException;
import exception.AlumnoYaExisteException;
import grafica.controlador.Controlador;
import grafica.ventana.alumno.AlumnoModificar;
import grafica.ventana.alumno.AlumnoNuevo;
import logica.vo.VOAlumno;
import logica.vo.VOAlumnoDetallado;
import logica.vo.VOAlumnoModificar;

public class ControladorAlumnoModificar extends Controlador {

	AlumnoModificar ventana;
	
	public ControladorAlumnoModificar( AlumnoModificar alumnoModificar ) {
		super();
		ventana = alumnoModificar;
	}
	
	public void grabar( int cedula, String domicilio, int telefono, String email ) {
		VOAlumnoModificar voAlumnoModificar = new VOAlumnoModificar( cedula, domicilio, telefono, email );
		try {
			fachada.modificarAlumno(voAlumnoModificar);
			showMessageDialog( "Alumno modificado" );
			ventana.dispose();
		} catch (RemoteException e) {
			showMessageDialog( "El servidor está caído" );
		} catch (AlumnoNoExisteException e) {
			showMessageDialog( "El alumno no existe" );
		}
	}
	
	@Override
	public void showMessageDialog( String string ) {
		//System.out.println("mensaje?: " + string);
		ventana.showMessageDialog( string );
	}
	
	public VOAlumnoDetallado obtenerAlumno( int cedula ) {
		VOAlumnoDetallado voad = null;
		
		try {
			voad = fachada.listadoDetalleAlumno( cedula );
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			showMessageDialog( "El servidor está caído" );
			ventana.dispose();
		} catch (AlumnoNoExisteException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			showMessageDialog( "El alumno no existe" );
			ventana.dispose();
		}
		
		return voad;
	}
	
}
