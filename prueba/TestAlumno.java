package prueba;
import logica.alumno.Alumno;
import logica.alumno.Alumnos;
import logica.vo.VOAlumnoListado;

public class TestAlumno {
	
	//Alumnos alumnos;
	
	public static void main( String args[] ) {
		Alumnos alumnos = new Alumnos();
		Alumno alumno = new Alumno(123, "Guille", "Osores", "calle falsa 1234", 1235, "a@a.com");
		alumnos.addAlumno(alumno);
		
		if(alumnos.existeAlumno(1)) {
			System.out.println("existe");
		}else {
			System.out.println("NO existe");
		}
	}

}
