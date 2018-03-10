package grafica.controlador.alumno;

import java.rmi.RemoteException;
import java.util.List;

import grafica.ventana.alumno.AlumnosListado;
import grafica.controlador.Controlador;

public class ControladorAlumnosListado extends Controlador {
	
	public ControladorAlumnosListado( AlumnosListado alumnosListado) {
		super( alumnosListado );
	}
	
	public List<logica.vo.VOAlumnoListado> listarAlumnos( String apellido ){
		List<logica.vo.VOAlumnoListado> lvoa = null;
		
		try {
			lvoa = getFachada().listarAlumnos( apellido );
		} catch (RemoteException e) {
			showMessageDialog( "El servidor está caído" );
		}
		
		return lvoa;
	}

}
