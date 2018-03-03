package logica.inscripcion;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import logica.alumno.Alumno;
import logica.inscripcion.Inscripcion;
import logica.vo.VOEscolaridad;

public class Inscripciones implements Serializable  {
	LinkedList<Inscripcion> inscripciones;
	
	public Inscripciones() {
		inscripciones = new LinkedList<Inscripcion>();
	}	
	
	public void addInscripcion( Inscripcion inscripcion ) {
		inscripciones.add( inscripcion );
	}	
	
	public List<VOEscolaridad> listarEscolaridad(boolean parcial) {
		List<VOEscolaridad> lista = new LinkedList<VOEscolaridad>();

		for(Inscripcion i: inscripciones) {
			if (!parcial)
				lista.add( new VOEscolaridad( i.numero, i.anioLectivo, i.montoBase, i.calificacion, i.asignatura.getNombre() ) );
			else if (i.aprobada())
				lista.add( new VOEscolaridad( i.numero, i.anioLectivo, 0 , i.calificacion, i.asignatura.getNombre() ) );
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
		
		return monto*10;
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
		boolean anioValido = true;
		
		if(!inscripciones.isEmpty()) {
			anioValido = anioLectivo >= this.inscripciones.getLast().anioLectivo;
		}
		
		return anioValido;
	}
	
	public boolean asignaturaAprobada(String codigoAsignatura) {
		boolean yaAprobada = false;
		
		int num = 0;
		
		while( inscripciones.size() > num && !yaAprobada) {
			
		    Inscripcion ins = inscripciones.get(num);
			
			if( ins.getAsignatura().getCodigo().equals(codigoAsignatura) ) {
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
			
			if( ins.getAsignatura().getCodigo() == codigoAsignatura) {
				if(ins.getAnio() == anioLectivo) 
					enCurso = true;					
			}
			
			num++;
			
		}
		
		return enCurso;	
	}	

	//1= parcial, 0= total
	public float promedioAprobacion (boolean total) {
		float suma = 0;
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
	
	
}
