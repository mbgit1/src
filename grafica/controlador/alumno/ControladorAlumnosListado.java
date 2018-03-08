package grafica.controlador.alumno;

import java.rmi.RemoteException;
import java.util.List;

import grafica.ventana.alumno.AlumnosListado;
import grafica.controlador.Controlador;

public class ControladorAlumnosListado extends Controlador {
	
	//AlumnosListado ventana;
	
	public ControladorAlumnosListado( AlumnosListado alumnosListado) {
		super( alumnosListado );
		//ventana = alumnosListado;
	}
	
	public List<logica.vo.VOAlumnoListado> listarAlumnos( String apellido ){
		List<logica.vo.VOAlumnoListado> lvoa = null;
		
		try {
			lvoa = fachada.listarAlumnos( apellido );
		} catch (RemoteException e) {
			showMessageDialog( "El servidor está caído" );
		}
		
		return lvoa;
	}
	
	@Override
	public void showMessageDialog( String string ) {
		//System.out.println("mensaje?: " + string);
		ventana.showMessageDialog( string );
	}

}
