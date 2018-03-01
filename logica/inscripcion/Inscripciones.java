package logica.inscripcion;

import java.util.LinkedList;
import java.util.List;

import logica.alumno.Alumno;
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
	

	public List<VOInscripcion> listarInscripciones(boolean total) {
		List<VOInscripcion> lista = new LinkedList<VOInscripcion>();

		for(Inscripcion i: inscripciones) {
			if (i.aprobada())
				lista.add( new VOInscripcion( i.numero, i.codigoAsignatura, i.anioLectivo, i.montoBase, i.calificacion ) );
			else if (total)
				lista.add( new VOInscripcion( i.numero, i.codigoAsignatura, i.anioLectivo, i.montoBase, i.calificacion ) );
		}
		
		return lista;
	}	
	
	public Inscripcion obtenerInscripcion( int numero ) { 
		int pos = --numero; 
		
		return inscripciones.get(pos);
	}
	
	public int ultimaInscripcion() {
		int ultimaIns = 0;
		
		if (!inscripciones.isEmpty())
			ultimaIns = inscripciones.getLast().numero;
		
		return ultimaIns;
	}
	
	public void registrarCalificacion(int numero, int calificacion) {
		int pos = --numero;
		inscripciones.get(pos).setCalificacion(calificacion);
	}	
	
	public boolean calificada(int numero) {
		int pos = --numero;
		return inscripciones.get(pos).calificada();
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
		
		int num = 0;
		
		while( inscripciones.size() > num && !yaAprobada) {
			
		    Inscripcion ins = inscripciones.getFirst();
			
			if( ins.getCodigoAsignatura() == codigoAsignatura) {
				if(ins.aprobada()) 
					yaAprobada = true;					
			}
			
			num++;
			
		}
		
		return yaAprobada;
	}
	
	public boolean asignaturaEnCurso(String codigoAsignatura, int anioLectivo) {
		boolean enCurso = false;
		
		int num = 0;
		
		while( inscripciones.size() > num && !enCurso) {
			
		    Inscripcion ins = inscripciones.getFirst();
			
			if( ins.getCodigoAsignatura() == codigoAsignatura) {
				if(ins.getAnio() == anioLectivo) 
					enCurso = true;					
			}
			
			num++;
			
		}
		
		return enCurso;	
	}	

	//0= parcial, 1= total
	public float promedioAprobacion (boolean total) {
		int suma = 0;
		int cantidad = 0;
		float promedio = 0;

		if (!inscripciones.isEmpty()) {
			for(Inscripcion i: inscripciones) {
				if (i.aprobada()) {
					suma+= i.getCalificacion();
					cantidad++;
				}else if (total) {
					suma+= i.getCalificacion();
					cantidad++;				
				}				
			}	
			
			promedio = suma/cantidad;
		}
		
		return promedio;
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
