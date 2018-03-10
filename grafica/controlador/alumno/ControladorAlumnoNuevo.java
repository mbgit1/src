package grafica.controlador.alumno;

import java.rmi.RemoteException;

import exception.AlumnoYaExisteException;
import grafica.controlador.Controlador;
import grafica.ventana.alumno.AlumnoNuevo;
import logica.vo.VOAlumno;
import logica.vo.VOBecado;

public class ControladorAlumnoNuevo extends Controlador {

	public ControladorAlumnoNuevo( AlumnoNuevo alumnoNuevo) {
		super( alumnoNuevo );
	}

	public void grabar( String cedula, String nombre, String apellido, String domicilio, String telefono, String email, boolean becado, String descuento, String descripcion ) {
		if( cedula.trim().isEmpty() ) {
			showMessageDialog( "La cédula no puede ser vacío" );
			
		}else if( nombre.trim().isEmpty() ) {
			showMessageDialog( "El nombre no puede ser vacío" );
			
		}else if( apellido.trim().isEmpty() ) {
			showMessageDialog( "El apellido no puede ser vacío" );
			
		}else if( domicilio.trim().isEmpty() ) {
			showMessageDialog( "El domicilio no puede ser vacío" );
			
		}else if( telefono.trim().isEmpty() ) {
			showMessageDialog( "El telefono no puede ser vacío" );
			
		}else if( email.trim().isEmpty() ) {
			showMessageDialog( "El email no puede ser vacío" );
			
		}else if( !soloNumeros( cedula.trim() ) ) {
			showMessageDialog( "La cédula debe ser numérica");
			
		}else if( !soloNumeros( telefono.trim() ) ) {
			showMessageDialog( "El teléfono debe ser numérico" );
			
		}else if( becado && descuento.trim().isEmpty() ) {
			showMessageDialog( "El descuento no puede ser vacío" );
			
		}else if( !becado && descuento.trim().isEmpty() ) {
			showMessageDialog( "Solo los becados pueden tener descuento" );
			
		}else if( becado && descripcion.trim().isEmpty() ) {
			showMessageDialog( "Al no tener desceunto la descripción debería estar vacía" );
			
		}else if( !soloNumeros( descuento.trim() ) ) {
			showMessageDialog( "El descuento debe ser numérica" );
			
		}else if( Integer.parseInt( descuento.trim() ) > 100 || Integer.parseInt( descuento.trim() ) < 1 ) {
			showMessageDialog( "El descuento debe ser entre 1 y 100" );
			
		}else {
			int intCedula		= Integer.parseInt( cedula );
			int intTelefono		= Integer.parseInt( telefono );
			int intDescuento	= Integer.parseInt( descuento );
			VOAlumno voAlumno;
			
			if( becado )  
				voAlumno = new VOBecado( intCedula, nombre, apellido, domicilio, intTelefono, email, intDescuento, descripcion );
			else
				voAlumno = new VOAlumno( intCedula, nombre, apellido, domicilio, intTelefono, email );
			
			try {
				getFachada().registrarAlumno( voAlumno );
				showMessageDialog( "Alumno creado" );
				getVentana().dispose();
			} catch (RemoteException e) {
				showMessageDialog( "El servidor está caído" );
			} catch (AlumnoYaExisteException e) {
				showMessageDialog( "El alumno ya existe" );
			}
		}
	}

}
