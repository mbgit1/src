package prueba;

import java.util.Iterator;

import exception.AsignaturaYaExisteException;
import exception.ListaLlenaException;
import logica.asignatura.Asignatura;
import logica.asignatura.Asignaturas;
import logica.vo.VOAsignatura;

public class TestAsignaturas_old {
	private static Asignaturas as;

	public static void main( String args[] ) {
		as = new Asignaturas();
		int hayerrores = 0;
		
		hayerrores += existeAsignatura( "lala", 0 );
		hayerrores += obtengoAsignatura( "lala", 1 );
		hayerrores += addAsignatura( "1", "primero", "la primera", 0 );
		hayerrores += existeAsignatura( "1", 1 );
		
		hayerrores += estaLlena( false );

		hayerrores += addAsignatura( "2", "segundo", "el segundo", 0 );
		hayerrores += addAsignatura( "3", "tercero", "el tercero", 0 );
		hayerrores += addAsignatura( "4", "cuarto", "el cuarto", 0 );
		hayerrores += addAsignatura( "5", "quinto", "el quinto", 0 );
		hayerrores += addAsignatura( "6", "sexto", "el sexto", 0 );
		hayerrores += addAsignatura( "7", "septimo", "el septimo", 0 );
		hayerrores += addAsignatura( "8", "octavo", "el octavo", 0 );
		hayerrores += addAsignatura( "9", "noveno", "el noveno", 0 );
		hayerrores += addAsignatura( "10", "decimo", "el decimo", 0 );
		hayerrores += addAsignatura( "11", "decimpo primero", "el decimo primero", 1 );
		
		hayerrores += estaLlena( true );
		
		hayerrores += compararDatos( "5", "quinto", "el quinto" );
		
		if( hayerrores == 0 ) {
			System.out.println( "0 errores" );
		}else {
			System.out.println( "\n\nHAY " + hayerrores + " ERRORES" );
		}
		
		
		//List<VOAsignatura> voas = as.listarAsignaturas();
		System.out.println( "\n\nLISTADO:" );
		Iterator<VOAsignatura> it = as.listarAsignaturas().iterator();
		while( it.hasNext() ) {
			VOAsignatura voa = it.next();
			System.out.println( "codigo: " + voa.getCodigo() + ", nombre: " + voa.getNombre() + ", descripcion: " + voa.getDescripcion() );
		}
		
	}
	
	private static int existeAsignatura( String codigo, int existe ) {
		if( as.existeAsignatura( codigo ) != existe > 0 ) {
			System.out.println( "Error en Existe Asignatura: " + codigo );
			return 1;
		}
		return 0;
	}
	
	private static int obtengoAsignatura( String codigo, int error ) {
		Asignatura a = as.obtenerAsignatura( codigo );
		if( (a == null && error == 0) || (a != null && error > 0) )
			System.out.println( "error en obtengoAsignatura: \""+ codigo +"\", la asignatura NO debe existir" );
		return error;
	}
	
	private static int addAsignatura( String codigo, String nombre, String descripcion, int error ) {
		as.addAsignatura( new Asignatura( codigo, nombre, descripcion ) );
		if( error > 0 )
			System.out.println( "error la asignatura NO deberia haberse agregado" );
		return error;
	}
	
	private static int estaLlena( boolean llena ) {
		if( as.estaLlena() != llena ) {
			System.out.print( "error la lista deberia estar " );
			if( llena ) {
				System.out.println( "llena" );
			}else {
				System.out.println( "NO llena" );
			}
			return 1;
		}
		return 0;
	}
	
	private static int compararDatos( String codigo, String nombre, String descripcion ) {
		Asignatura a = as.obtenerAsignatura( "5" );
		if( a.getCodigo() != codigo ) {
			System.out.println( "el codigo no coincide: " + codigo );
			return 1;
		}
		
		if( a.getNombre() != nombre ) {
			System.out.println( "el nombre no coincide: " + nombre );
			return 1;
		}
		
		if( a.getDescripcion() != descripcion ) {
			System.out.println( "la descripcion no coincide: " + descripcion );
			return 1;
		}
		return 0;
	}
}
