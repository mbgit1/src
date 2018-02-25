package logica.vo;

@SuppressWarnings("serial")
public class VOBecado extends VOAlumno{
	private int descuento;
	private String descripcion;
	
	public VOBecado( int cedula, String nombre, String apellido, String domicilio, int telefono, String email, int descuento, String descripcion ) {
		super( cedula, nombre, apellido, domicilio, telefono, email );
		this.descuento		= descuento;
		this.descripcion	= descripcion;
	}
	
	public int getDescuento() {
		return descuento;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
}
