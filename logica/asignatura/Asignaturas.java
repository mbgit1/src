package logica.asignatura;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import exception.AsignaturaNoExisteException;
import exception.ListaLlenaException;
import logica.asignatura.Asignatura;
import logica.vo.VOAsignatura;

public class Asignaturas {
	ArrayList<Asignatura> asignaturas;

	public Asignaturas() {
		asignaturas = new ArrayList<Asignatura>();
	}
	
	//public Asignaturas( ArrayList<Asignatura> asignaturas ) {
	public Asignaturas( Asignaturas asignaturas ) {
		this.asignaturas = asignaturas.asignaturas;
	}
	
	public void addAsignatura( Asignatura asignatura ) throws ListaLlenaException {
		if( !estaLlena() ) {
			asignaturas.add( asignatura );
		}else {
			throw new ListaLlenaException();
		}
	}
	
	public Asignatura obtenerAsignatura( String codigo ) throws AsignaturaNoExisteException {
		int i = 0;
		
		while( i < asignaturas.size() ) {
			Asignatura a = asignaturas.get( i );
			if( a.codigo == codigo )
				return a;
			i++;
		}
		throw new AsignaturaNoExisteException(); 
	}
	
	public boolean existeAsignatura( String codigo ) {
		int i = 0;
		
		while( i < asignaturas.size() ) {
			Asignatura a = asignaturas.get( i );
			if( a.codigo == codigo )
				return true;
			i++;
		}
		return false; 
	}
	
	public boolean estaLlena() {
		return ( asignaturas.size() == 10 );
	}
	
	public List<VOAsignatura> listarAsignaturas() {
		List<VOAsignatura> lista = new LinkedList<VOAsignatura>();
		
		for( int i = 0; i < 10; i++) {
			Asignatura a = asignaturas.get( i );
			lista.add( new VOAsignatura( a.codigo, a.nombre, a.descripcion ) );
		}
		
		return lista;
	}
}
