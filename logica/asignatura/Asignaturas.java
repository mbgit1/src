package logica.asignatura;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import logica.asignatura.Asignatura;
import logica.vo.VOAsignatura;

@SuppressWarnings("serial")
public class Asignaturas implements Serializable {
	
	private ArrayList<Asignatura> asignaturas;
	private static final int MAX = 10;

	public Asignaturas() {
		asignaturas = new ArrayList<Asignatura>();
	}
	
	public Asignaturas( Asignaturas asignaturas ) {
		this.asignaturas = asignaturas.asignaturas;
	}
	
	public void addAsignatura( Asignatura asignatura ) {
		asignaturas.add( asignatura );
	}
	
	public Asignatura obtenerAsignatura( String codigo ) {
		Asignatura a = null;
		int i = 0;
		boolean encontrada = false;
		
		while( i < asignaturas.size() && !encontrada ) {
			a = asignaturas.get( i );
			if( a.codigo == codigo )
				encontrada = true;
			i++;
		}
		return a;
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
		return ( asignaturas.size() == MAX );
	}
	
	public List<VOAsignatura> listarAsignaturas() {
		List<VOAsignatura> lista = new LinkedList<VOAsignatura>();
		
		for( int i = 0; i < asignaturas.size(); i++) {
			Asignatura a = asignaturas.get( i );
			lista.add( new VOAsignatura( a.codigo, a.nombre, a.descripcion ) );
		}
		
		return lista;
	}
}
