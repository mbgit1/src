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
			showMessageDialog( "La c�dula no puede ser vac�o" );
			
		}else if( nombre.trim().isEmpty() ) {
			showMessageDialog( "El nombre no puede ser vac�o" );
			
		}else if( apellido.trim().isEmpty() ) {
			showMessageDialog( "El apellido no puede ser vac�o" );
			
		}else if( domicilio.trim().isEmpty() ) {
			showMessageDialog( "El domicilio no puede ser vac�o" );
			
		}else if( telefono.trim().isEmpty() ) {
			showMessageDialog( "El telefono no puede ser vac�o" );
			
		}else if( email.trim().isEmpty() ) {
			showMessageDialog( "El email no puede ser vac�o" );
			
		}else if( !soloNumeros( cedula.trim() ) ) {
			showMessageDialog( "La c�dula debe ser num�rica");
			
		}else if( !soloNumeros( telefono.trim() ) ) {
			showMessageDialog( "El tel�fono debe ser num�rico" );
			
		}else if( becado && descuento.trim().isEmpty() ) {
			showMessageDialog( "El descuento no puede ser vac�o" );
			
		}else if( !becado && descuento.trim().isEmpty() ) {
			showMessageDialog( "Solo los becados pueden tener descuento" );
			
		}else if( becado && descripcion.trim().isEmpty() ) {
			showMessageDialog( "Al no tener desceunto la descripci�n deber�a estar vac�a" );
			
		}else if( !soloNumeros( descuento.trim() ) ) {
			showMessageDialog( "El descuento debe ser num�rica" );
			
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
				showMessageDialog( "El servidor est� ca�do" );
			} catch (AlumnoYaExisteException e) {
				showMessageDialog( "El alumno ya existe" );
			}
		}
	}

}
