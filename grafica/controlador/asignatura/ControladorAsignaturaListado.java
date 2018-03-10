package grafica.controlador.asignatura;

import java.rmi.RemoteException;
import java.util.List;

import grafica.controlador.Controlador;
import grafica.ventana.asignatura.AsignaturaListado;
 

public class ControladorAsignaturaListado extends Controlador {
	
	public ControladorAsignaturaListado( AsignaturaListado asignaturaListado) {
		super( asignaturaListado );
		 
	}
	
	public List<logica.vo.VOAsignatura> listarAsignaturas(){
		
		List<logica.vo.VOAsignatura> lvoasig = null;
		
		try {
			lvoasig = getFachada().listarAsignaturas();
		} catch (RemoteException e) {
			showMessageDialog( "El servidor está caído" );
		}
		
		return lvoasig;
	}
	
	@Override
	public void showMessageDialog( String string ) {
		 
		getVentana().showMessageDialog( string );
	}

}
