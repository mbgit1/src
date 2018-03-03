package prueba;

import java.util.Iterator;

import exception.AsignaturaYaExisteException;
import exception.ListaLlenaException;
import logica.asignatura.Asignatura;
import logica.asignatura.Asignaturas;
import logica.vo.VOAsignatura;

public class TestAsignaturas {
	private static Asignaturas as;

	public static void main( String args[] ) {
		as = new Asignaturas();
		boolean hayerrores = false;
		
		hayerrores = hayerrores || existeAsignatura( "lala", false );
		hayerrores = hayerrores || obtengoAsignatura( "lala", true );
		hayerrores = hayerrores || addAsignatura( "1", "primero", "la primera", false );
		hayerrores = hayerrores || existeAsignatura( "1", true );
		
		hayerrores = hayerrores || estaLlena( false );

		hayerrores = hayerrores || addAsignatura( "2", "segundo", "el segundo", false );
		hayerrores = hayerrores || addAsignatura( "3", "tercero", "el tercero", false );
		hayerrores = hayerrores || addAsignatura( "4", "cuarto", "el cuarto", false );
		hayerrores = hayerrores || addAsignatura( "5", "quinto", "el quinto", false );
		hayerrores = hayerrores || addAsignatura( "6", "sexto", "el sexto", false );
		hayerrores = hayerrores || addAsignatura( "7", "septimo", "el septimo", false );
		hayerrores = hayerrores || addAsignatura( "8", "octavo", "el octavo", false );
		hayerrores = hayerrores || addAsignatura( "9", "noveno", "el noveno", false );
		hayerrores = hayerrores || addAsignatura( "10", "decimo", "el decimo", false );
		hayerrores = hayerrores || addAsignatura( "11", "decimpo primero", "el decimpo primero", true );
		
		hayerrores = hayerrores || estaLlena( true );
		
		hayerrores = hayerrores || compararDatos( "5", "quinto", "el quinto" );
		
		if( !hayerrores ) {
			System.out.println( "0 errores" );
		}else {
			System.out.println( "\n\nHAY ERRORES" );
		}
		
		
		//List<VOAsignatura> voas = as.listarAsignaturas();
		System.out.println( "\n\nLISTADO:" );
		Iterator<VOAsignatura> it = as.listarAsignaturas().iterator();
		while( it.hasNext() ) {
			VOAsignatura voa = it.next();
			System.out.println( "codigo: " + voa.getCodigo() + ", nombre: " + voa.getNombre() + ", descripcion: " + voa.getDescripcion() );
		}
		
	}
	
	private static boolean existeAsignatura( String codigo, boolean existe ) {
		if( as.existeAsignatura( codigo ) != existe ) {
			System.out.println( "Error en Existe Asignatura: " + codigo );
			return true;
		}
		return false;
	}
	
	private static boolean obtengoAsignatura( String codigo, boolean error ) {
		Asignatura a = as.obtenerAsignatura( codigo );
		a.getDescripcion();
		if( error )
			System.out.println( "error en obtengoAsignatura, la asignatura NO debe existir" );
		return error;
	}
	
	private static boolean addAsignatura( String codigo, String nombre, String descripcion, boolean error ) {
		as.addAsignatura( new Asignatura( codigo, nombre, descripcion ) );
		if( error )
			System.out.println( "error la asignatura NO deberia haberse agregado" );
		return error;
	}
	
	private static boolean estaLlena( boolean llena ) {
		if( as.estaLlena() != llena ) {
			System.out.print( "error la lista deberia estar " );
			if( llena ) {
				System.out.println( "llena" );
			}else {
				System.out.println( "NO llena" );
			}
			return true;
		}
		return false;
	}
	
	private static boolean compararDatos( String codigo, String nombre, String descripcion ) {
		Asignatura a = as.obtenerAsignatura( "5" );
		if( a.getCodigo() != codigo ) {
			System.out.println( "el codigo no coincide: " + codigo );
			return true;
		}
		
		if( a.getNombre() != nombre ) {
			System.out.println( "el nombre no coincide: " + nombre );
			return true;
		}
		
		if( a.getDescripcion() != descripcion ) {
			System.out.println( "la descripcion no coincide: " + descripcion );
			return true;
		}
		return false;
	}
}
