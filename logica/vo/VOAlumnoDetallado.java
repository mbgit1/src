package logica.vo;
import java.io.Serializable;

@SuppressWarnings("serial")
public class VOAlumnoDetallado implements Serializable  {
	private int cedula;
	private String nombre;
	private String apellido;
	private String domicilio;
	private int telefono;
	private String email;
	private int montoCuota;
	private String tipo;
	
	public VOAlumnoDetallado( int cedula, String nombre, String apellido, String domicilio, int telefono, String email,int montoCuota,String tipo ) {
		this.cedula		= cedula;
		this.nombre		= nombre;
		this.apellido	= apellido;
		this.domicilio	= domicilio;
		this.telefono	= telefono;
		this.email		= email;
		this.montoCuota = montoCuota;
		this.tipo       = tipo;
	}
	
	public int getCedula() {
		return cedula;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public String getDomicilio() {
		return domicilio;
	}
	
	public int getTelefono() {
		return telefono;
	}
	
	public String getEmail() {
		return email;
	}
	
	public int getMontoCuota() {
		return montoCuota;
	}
	public void setMontoCuota(float f) {
		this.montoCuota = (int) f;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
