package logica.vo;

import java.io.Serializable;

import logica.alumno.Alumnos;
import logica.asignatura.Asignaturas;

@SuppressWarnings("serial")
public class VOFachada implements Serializable {
	
	private Asignaturas asignaturas;
	private Alumnos alumnos;
	
	public VOFachada(Asignaturas asignaturas, Alumnos alumnos ) {
		this.asignaturas = asignaturas;
		this.alumnos = alumnos;
	}
	
	public Asignaturas getAsignaturas() {
		return asignaturas;
	}
	
	public void setAsignatruas(Asignaturas asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	public Alumnos getAlumnos() {
		return alumnos;
	}
	
	public void setAlumnos(Alumnos alumnos) {
		this.alumnos = alumnos;
	}
	
	
}