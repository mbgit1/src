package prueba;

import java.util.Iterator;

import javax.crypto.ExemptionMechanismSpi;

import exception.AsignaturaNoExisteException;
import exception.ListaLlenaException;
import logica.asignatura.Asignatura;
import logica.asignatura.Asignaturas;
import logica.vo.VOAsignatura;

public class TestAsignaturas {
	private static Asignaturas as;

	public static void main( String args[] ) {
		as = new Asignaturas();
		boolean hayerrores = false;
		Asignatura a;
		
		hayerrores = hayerrores || existeAsignatura( "lala" );
		hayerrores = hayerrores || obtengoAsignatura( "lala", true );
		hayerrores = hayerrores || addAsignatura( "1", "primero", "la primera", false );
		hayerrores = hayerrores || existeAsignatura( "1" );

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
		
		System.out.print( "esta llena?: " );
		System.out.println( as.estaLlena() );
		
		
		try {
			a = as.obtenerAsignatura( "5" );
			System.out.println("codigo: " + a.getCodigo() );
			System.out.println("nombre: " + a.getNombre() );
			System.out.println("descripcion: " + a.getDescripcion() );
		} catch (AsignaturaNoExisteException e) {
			System.out.println( "esto no se deberia ver" );
		}
		/*
		//List<VOAsignatura> voas = as.listarAsignaturas();
		Iterator<VOAsignatura> it = as.listarAsignaturas().iterator();
		while( it.hasNext() ) {
			VOAsignatura voa = it.next();
			System.out.println( "codigo: " + voa.getCodigo() + ", nombre: " + voa.getNombre() + ", descripcion: " + voa.getDescripcion() );
		}
		*/
	}
	
	private static boolean existeAsignatura( String codigo ) {
		if( as.existeAsignatura( codigo ) ) {
			System.out.println( "Error en Existe Asignatura" );
			return true;
		}
		return false;
	}
	
	private static boolean obtengoAsignatura( String codigo, boolean error ) {
		try {
			Asignatura a = as.obtenerAsignatura( codigo );
			if( error )
				System.out.println( "error en obtengoAsignatura, la asignatura NO debe existir" );
			return error;
		} catch (AsignaturaNoExisteException e) {
			if( !error )
				System.out.println( "error la asignatura SI debe existir" );
			return !error;
		}
	}
	
	private static boolean addAsignatura( String codigo, String nombre, String descripcion, boolean error ) {
		try {
			as.addAsignatura( new Asignatura( codigo, nombre, descripcion ) );
			if( error )
				System.out.println( "error la asignatura NO deberia haberse agregado" );
			return error;
		} catch (ListaLlenaException e) {
			if( !error )
				System.out.println( "error la asignatura SI deberia haberse agregado" );
			return !error;
		}
	}
}
