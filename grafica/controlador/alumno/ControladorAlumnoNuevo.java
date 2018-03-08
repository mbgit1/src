package grafica.controlador.alumno;

import java.rmi.RemoteException;

import exception.AlumnoYaExisteException;
import grafica.controlador.Controlador;
import grafica.ventana.alumno.AlumnoNuevo;
import logica.vo.VOAlumno;

public class ControladorAlumnoNuevo extends Controlador {
	
	//AlumnoNuevo ventana;
	
	public ControladorAlumnoNuevo( AlumnoNuevo alumnoNuevo) {
		//super(alumnoNuevo);
		super( alumnoNuevo );
		//ventana = alumnoNuevo;
	}
	
	public void grabar( int cedula, String nombre, String apellido, String domicilio, int telefono, String email ) {
		VOAlumno voAlumno = new VOAlumno( cedula, nombre, apellido, domicilio, telefono, email );
		try {
			fachada.registrarAlumno( voAlumno );
			showMessageDialog( "Alumno creado" );
			ventana.dispose();
		} catch (RemoteException e) {
			showMessageDialog( "El servidor está caído" );
		} catch (AlumnoYaExisteException e) {
			showMessageDialog( "El alumno ya existe" );
		}
	}
	
	@Override
	public void showMessageDialog( String string ) {
		//System.out.println("mensaje?: " + string);
		ventana.showMessageDialog( string );
	}
}
