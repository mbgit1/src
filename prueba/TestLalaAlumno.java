package prueba;
import logica.vo.VOAlumnoListado;

public class TestLalaAlumno {
	
	public static void main( String args[] ) {
		VOAlumnoListado voal = new VOAlumnoListado( 38580006, "Guillermo", "Osores" );
		System.out.println( voal.getCedula() );
		System.out.println( voal.getNombre() );
		System.out.println( voal.getApellido() );
	}

}
