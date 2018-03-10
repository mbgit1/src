package grafica.controlador;


import java.io.IOException;

import exception.PersistenciaException;


import grafica.ventana.VentanaMenu;


public class ControladorMenuPrincipal extends Controlador {

	public ControladorMenuPrincipal(VentanaMenu vmPrincipal) {
		
		super(vmPrincipal);
		// TODO Auto-generated constructor stub
	}
	
	public void respaldar() {
		try {
			getFachada().respaldar();
			showMessageDialog("Los datos fueron respaldados con exito");
			 
			
		}catch(PersistenciaException | IOException e) {
			showMessageDialog( "El servidor está caído" );
	
			 }
	}
	
	
	

	
	
	
	 
}
