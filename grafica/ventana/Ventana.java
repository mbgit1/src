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
	
	protected boolean soloNumeros( String string ) {
        Pattern pattern = Pattern.compile( "^[0-9]*$" );

        Matcher matcher = pattern.matcher( string );
        boolean matches = matcher.matches();
        
        return matches;
		//return string.regionMatches(true, 0, "[0-9]", 0, string.length());
	}
}
