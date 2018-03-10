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
	private int descuento;
	private String descripcion;
	
	public VOAlumnoDetallado( int cedula, String nombre, String apellido, String domicilio, int telefono, String email,int montoCuota, String tipo, int descuento, String descripcion ) {
		this.cedula			= cedula;
		this.nombre			= nombre;
		this.apellido		= apellido;
		this.domicilio		= domicilio;
		this.telefono		= telefono;
		this.email			= email;
		this.montoCuota		= montoCuota;
		this.tipo       	= tipo;
		this.descuento		= descuento;
		this.descripcion	= descripcion;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMontoCuota() {
		return montoCuota;
	}

	public void setMontoCuota(int montoCuota) {
		this.montoCuota = montoCuota;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
