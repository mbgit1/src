package grafica.ventana;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Ventana extends JFrame {

	public Ventana() {
		super();
	}
	
	public void showMessageDialog( String mensaje ) {
		//System.out.println("ventana mensaje?: " + mensaje);
		javax.swing.JOptionPane.showMessageDialog( null, mensaje );
	}
	
}
