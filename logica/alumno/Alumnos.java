package logica.alumno;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import logica.Diccionario;
import logica.vo.VOAlumnoListado;
import logica.vo.VOEgresado;

@SuppressWarnings("serial")
public class Alumnos extends Diccionario<Integer,Alumno> implements Serializable {


	public Alumnos() {
		super();	
	}

	public Alumnos( Alumnos alumnos ) {
		this.ponerTodos(alumnos);
	}


	public void addAlumno(Alumno alumno) {
		poner(alumno.getCedula(), alumno);
	}


	public boolean existeAlumno(int cedula) {
		return contiene(cedula);
	}

	public Alumno obtenerAlumno(int cedula) {
		return obtener(cedula);
	}
	/*	
	public List<VOAlumnoDetallado> listarAlumnos(){

		Alumno alumno;
		Iterator<Alumno> iteradorAlumno = iterador();
		List<VOAlumnoDetallado> alumnoSalida = new ArrayList<VOAlumnoDetallado>();

		while (iteradorAlumno.hasNext()) {
			alumno = iteradorAlumno.next();
			if ( alumno instanceof Becado) {
				 Becado becado = new Becado(alumno.getCedula(),alumno.getApellido(),alumno.getNombre(),alumno.getDomicilio(),alumno.getTelefono(),alumno.getEmail(),((Becado) alumno).getDescuento(),((Becado) alumno).getDescripcion());
			//aca preguntar con instans of si es becado o no.. y ahi hacer la diferencia de vo.. 
			//tomo de aqui si es becado (me devuelvo true) saco el tipo. 
			//agregar en VOAlumnoListado el atributo tipo 
				 ((VOAlumnoDetallado) alumnoSalida).setMontoCuota(alumno.calcularCuota()); 
				 ((VOAlumnoDetallado) alumnoSalida).setTipo("becado");
				 alumnoSalida.add(becado.voAlumnoDetallado());
			}	
    		 ((VOAlumnoDetallado) alumnoSalida).setMontoCuota(alumno.calcularCuota());     
			((VOAlumnoListado) alumnoSalida).setTipo("comun");
				alumnoSalida.add(alumno.voAlumnoDetallado());
		}


	return alumnoSalida;

	}
	 */

	public List<VOAlumnoListado> listarAlumnosPorApellido(String palabra){

		Alumno alumno;
		Iterator<Alumno> iteradorAlumno = iterador();
		List<VOAlumnoListado> alumnoSalida = new ArrayList<VOAlumnoListado>();

		while (iteradorAlumno.hasNext()) {
			alumno = iteradorAlumno.next();
			if(alumno.getApellido().contains(palabra)){
				alumnoSalida.add(alumno.voAlumnoListado());
			}
		}

		return alumnoSalida;

	}
	/*
public void modificarAlumno(Alumno alumno) {
   alumno.modificarAlumno(alumno.getDomicilio(),alumno.getTelefono(),alumno.getEmail());

}
	 */

	//aqui va el promedio de las materias que tienen mayor o igual que 6
	public float promedioAprobacion (int cedula,boolean total) {
		return obtener(cedula).promedioAprobacion(total);
		//return obtener(Integer.toString(cedula)).promedioAprobacion(total);

	}

	//Aqui va el promedio de todas las materias (incluso si la calificacion es cero)
	//public float promedioTotal (Alumno alumno) {

	//	return alumno.promedioTotal(alumno);
	//}
	public VOEgresado voEgresados(Alumno alumno) {

		return new VOEgresado(alumno.getCedula(),alumno.getNombre(), alumno.getApellido(),alumno.promedioAprobacion(true), alumno.promedioAprobacion(false));
	}


	public List<VOEgresado> listadoEgresados (boolean parcial){
		Alumno alumno;
		Iterator<Alumno> iteradorAlumno = iterador();
		List<VOEgresado> alumnoSalida = new ArrayList<VOEgresado>();
		VOEgresado voe= null; 

		while (iteradorAlumno.hasNext()) {
			alumno = iteradorAlumno.next();
			if (alumno.egresado()) {
				if(parcial) {
					voe = new VOEgresado(alumno.getCedula(),alumno.getNombre(),alumno.getApellido(),0,0);
					alumnoSalida.add(voe);
				}
				else {
					voe = new VOEgresado(alumno.getCedula(),alumno.getNombre(),alumno.getApellido(),alumno.promedioAprobacion(true), alumno.promedioAprobacion(false));
					alumnoSalida.add(voe);
				}
			}
		}

		return alumnoSalida;	 

	}
}
