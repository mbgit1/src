package grafica.controlador.asignatura;

import java.rmi.RemoteException;

import exception.AlumnoYaExisteException;
import exception.AsignaturaYaExisteException;
import exception.ListaLlenaException;
import grafica.controlador.Controlador;
import grafica.ventana.alumno.AlumnoNuevo;
import grafica.ventana.asignatura.AsignaturaNueva;
import logica.vo.VOAlumno;
import logica.vo.VOAsignatura;

public class ControladorAsignaturaNueva extends Controlador {
	
	
	public ControladorAsignaturaNueva (AsignaturaNueva asignaturaNueva) {
		
		super(asignaturaNueva);
	}
	
	public void grabar(String codigo, String nombre, String descripcion) {
		
		VOAsignatura voAsig = new VOAsignatura(codigo,nombre,descripcion);
		try {
			getFachada().registrarAsignatura(voAsig);
			
			showMessageDialog("Asignatura registrada");
			getVentana().dispose();
		}catch(RemoteException e) {
			showMessageDialog( "El servidor está caído" );
		} catch (ListaLlenaException e) {
			showMessageDialog( "No se admiten mas asignaturas " );
		}catch (AsignaturaYaExisteException e) {
			showMessageDialog( "La asignatura ya existe" );
		}
		
	}
	
	@Override
	public void showMessageDialog( String string ) {
		 
		getVentana().showMessageDialog( string );
	}

}

