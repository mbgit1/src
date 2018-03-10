package grafica.controlador.inscripciones;

import java.rmi.RemoteException;
import java.util.List;

import exception.AlumnoNoExisteException;
import exception.AlumnoYaInscriptoException;
import exception.ErrorAnioInscripcionException;
import exception.AsignaturaNoExisteException;
import exception.AsignaturaYaAprobadaException;

import grafica.controlador.Controlador;
import grafica.ventana.inscripciones.InscripcionNueva;
import logica.vo.VOInscripcion;
import logica.vo.VOAsignatura;


public class ControladorInscripcionNueva extends Controlador{

	public ControladorInscripcionNueva( InscripcionNueva inscripcionNueva) {

		super( inscripcionNueva );

	}	
	
	public List<logica.vo.VOAsignatura> listarAsignaturas( ){
		List<logica.vo.VOAsignatura> lvoa = null;

		try {
			lvoa = getFachada().listarAsignaturas();				
		} catch (RemoteException e) {
			showMessageDialog( "El servidor está caído" );
		} 
		
		//showMessageDialog( Integer.toString(lvoa.size()) );
		return lvoa;
		
	}

	public void crear( String cedula, String codigo, String anio, String monto) {
		
		//System.out.println(cedula);
		
		if (cedula.trim().isEmpty()) {
			showMessageDialog( "La cédula no puede ser vacío" );
			//System.out.println("todo bien");
			
		}else if(!soloNumeros(cedula)){			
			showMessageDialog( "La cédula debe ser numérica");		
		
		}else if( codigo.trim().isEmpty() ) {
			showMessageDialog( "Debe seleccionar una asignatura" );
			
		}else if( anio.trim().isEmpty() ) {
			showMessageDialog( "El año no puede ser vacío" );
			
		}else if( monto.trim().isEmpty() ) {
			showMessageDialog( "El monto no puede ser vacío" );
			
		}else if( !soloNumeros( anio.trim() ) ) {
			showMessageDialog( "La año debe ser numérica");
			
		}else if( !soloNumeros( monto.trim() ) ) {
			showMessageDialog( "El monto debe ser numérico" );
			
		}else {
			int intCedula	= Integer.parseInt( cedula );
			int intAnio		= Integer.parseInt( anio );
			int intMonto	= Integer.parseInt( monto );
			
			

			VOInscripcion voInscripcion = new VOInscripcion( intCedula, codigo, intAnio, intMonto );
				
			try {
				getFachada().inscripcionAsignatura(voInscripcion);
				showMessageDialog( "Nueva inscripción OK" );
				getVentana().dispose();
			} catch (RemoteException e) {
				showMessageDialog( "El servidor está caído" );
			} catch (AlumnoNoExisteException e) {
				showMessageDialog( "El alumno no existe" );
			} catch (AlumnoYaInscriptoException e) {
				showMessageDialog( "El alumno ya está inscripto a esta asignatura" );
			} catch (ErrorAnioInscripcionException e) {
				showMessageDialog( "El año lectivo no es correcto" );
			} catch (AsignaturaNoExisteException e) {
				showMessageDialog( "La asignatura no existe" );
			} catch (AsignaturaYaAprobadaException e) {
				showMessageDialog( "La asignatura ya está aprobada" );
			}
		}
		
	}	
	
}
