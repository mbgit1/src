package logica.inscripcion;

import java.util.LinkedList;
import java.util.List;

import logica.inscripcion.Inscripcion;
import logica.vo.VOInscripcion;

public class Inscripciones {
	LinkedList<Inscripcion> inscripciones;
	
	public Inscripciones() {
		inscripciones = new LinkedList<Inscripcion>();
	}	
	
	public void addInscripcion( Inscripcion inscripcion ) {
		inscripciones.add( inscripcion );
	}	
	
	public List<VOInscripcion> listarInscripciones() {
		List<VOInscripcion> lista = new LinkedList<VOInscripcion>();

		for(Inscripcion i: inscripciones) {
			lista.add( new VOInscripcion( i.numero, i.codigoAsignatura, i.anioLectivo, i.montoBase ) );
		}
		
		return lista;
	}	
	
	public Inscripcion obtenerInscripcion( int numero ) { 
		
		return inscripciones.get(numero);
	}
	
	public int ultimaInscripcion() {
		return inscripciones.getLast().numero;
	}
	
	public void registrarInscripcion(int numero, int calificacion) {
		inscripciones.get(numero).setCalificacion(calificacion);
	}	
	
	public boolean calificada(int numero) {
		return inscripciones.get(numero).calificada();
	}	

	public int montoRecaudado(int anioLectivo) {
		int monto = 0;
		
		for(Inscripcion i: inscripciones) {
			if (i.anioLectivo == anioLectivo)
				monto+= i.montoBase;
		}
		
		return monto;
	}

	public boolean egresado() {
		int cantAprobadas = 0;
		
		for(Inscripcion i: inscripciones) {
			if (i.aprobada())
				cantAprobadas++;
		}
		
		return cantAprobadas == 10;
	}	

	public boolean anioInscripcionValido(int anioLectivo) {
		boolean anioValido = anioLectivo >= this.inscripciones.getLast().anioLectivo;
		return anioValido;
	}
	
	public boolean asignaturaAprobada(String codigoAsignatura) {
		boolean yaAprobada = false;
		LinkedList<Inscripcion> i = this.inscripciones;
		
		while( !i.isEmpty() && !yaAprobada) {
			
		    Inscripcion ins = i.getFirst();
			
			if( ins.getCodigoAsignatura() == codigoAsignatura) {
				if(ins.aprobada()) 
					yaAprobada = true;					
			}
			
			i.iterator();
		}
		
		return yaAprobada;
	}
	
	public boolean asignaturaEnCurso(String codigoAsignatura, int anioLectivo) {
		boolean enCurso = false;
		LinkedList<Inscripcion> i = this.inscripciones;
		
		while( !i.isEmpty() && !enCurso) {
			
		    Inscripcion ins = i.getFirst();
			
			if( ins.getCodigoAsignatura() == codigoAsignatura) {
				if(ins.getAnio() == anioLectivo) 
					enCurso = true;					
			}
			
			i.iterator();
		}
		
		return enCurso;		
	}	

/*	
	public boolean validarInscripcion(String codigoAsignatura, int anioLectivo) {

		LinkedList<Inscripcion> i = this.inscripciones;
		
		boolean yaAprobada = false;
		boolean enCurso = false;
		boolean anioValido = anioLectivo >= i.getLast().anioLectivo;
		boolean esValida = false;
		
		if (anioValido) {
			while( !i.isEmpty() && !yaAprobada && !enCurso) {
				
			    Inscripcion ins = i.getFirst();
				
				if( ins.getCodigoAsignatura() == codigoAsignatura) {
					if(ins.aprobada()) 
						yaAprobada = true;
					else if (ins.getAnio() == anioLectivo)
						enCurso = true;
						
				}
				
				i.iterator();
			}
			
			if (!yaAprobada || !enCurso)
				esValida = true;		
		}
				
		return esValida;
			
	}	
*/	
}
