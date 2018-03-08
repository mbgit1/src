package grafica.ventana.alumno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import grafica.controlador.alumno.ControladorAlumnoNuevo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AlumnoNuevo extends JFrame{

	private JFrame frmNuevoAlumno;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDomicilio;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	
	ControladorAlumnoNuevo controladorAlumnoNuevo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlumnoNuevo window = new AlumnoNuevo();
					window.frmNuevoAlumno.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AlumnoNuevo() {
		initialize();
		controladorAlumnoNuevo = new ControladorAlumnoNuevo( this );
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNuevoAlumno = new JFrame();
		frmNuevoAlumno.setTitle("Nuevo Alumno");
		frmNuevoAlumno.setBounds(100, 100, 344, 301);
		frmNuevoAlumno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNuevoAlumno.getContentPane().setLayout(null);
		
		JLabel lblCedula = new JLabel("C\u00E9dula:");
		lblCedula.setBounds(34, 31, 46, 14);
		frmNuevoAlumno.getContentPane().add(lblCedula);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(34, 56, 46, 14);
		frmNuevoAlumno.getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(34, 81, 46, 14);
		frmNuevoAlumno.getContentPane().add(lblApellido);
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setBounds(34, 106, 46, 14);
		frmNuevoAlumno.getContentPane().add(lblDomicilio);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setBounds(34, 131, 46, 14);
		frmNuevoAlumno.getContentPane().add(lblTelefono);
		
		JLabel lblEmail = new JLabel("EMail:");
		lblEmail.setBounds(34, 156, 46, 14);
		frmNuevoAlumno.getContentPane().add(lblEmail);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(90, 28, 205, 20);
		frmNuevoAlumno.getContentPane().add(txtCedula);
		txtCedula.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(90, 53, 205, 20);
		frmNuevoAlumno.getContentPane().add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(90, 78, 205, 20);
		frmNuevoAlumno.getContentPane().add(txtApellido);
		
		txtDomicilio = new JTextField();
		txtDomicilio.setColumns(10);
		txtDomicilio.setBounds(90, 103, 205, 20);
		frmNuevoAlumno.getContentPane().add(txtDomicilio);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(90, 128, 205, 20);
		frmNuevoAlumno.getContentPane().add(txtTelefono);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(90, 153, 205, 20);
		frmNuevoAlumno.getContentPane().add(txtEmail);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ( soloNumeros( txtCedula.getText() ) && !txtCedula.getText().isEmpty() ) {
					if ( soloNumeros( txtTelefono.getText() ) && !txtTelefono.getText().isEmpty() ) {
						int cedula			= Integer.parseInt( txtCedula.getText() );
						String nombre		= txtNombre.getText();
						String apellido		= txtApellido.getText();
						String domicilio	= txtDomicilio.getText();
						int telefono		= Integer.parseInt( txtTelefono.getText() );
						String email		= txtEmail.getText();
						
						controladorAlumnoNuevo.grabar( cedula, nombre, apellido, domicilio, telefono, email );
					}else {
						javax.swing.JOptionPane.showMessageDialog( null, "El valor debe ser numérico" );
					}
				}else {
					javax.swing.JOptionPane.showMessageDialog( null, "El valor debe ser numérico");
					//javax.swing.JOptionPane pane = 
				}
			}
		});
		btnGuardar.setBounds(106, 214, 89, 23);
		frmNuevoAlumno.getContentPane().add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(205, 214, 89, 23);
		frmNuevoAlumno.getContentPane().add(btnCancelar);
	}
	
	private boolean soloNumeros( String string ) {
        Pattern pattern = Pattern.compile( "^[0-9]*$" );

        Matcher matcher = pattern.matcher( string );
        boolean matches = matcher.matches();
        
        return matches;
		//return string.regionMatches(true, 0, "[0-9]", 0, string.length());
	}
	
	public void showMessageDialog( String mensaje ) {
		System.out.println("ventana mensaje?: " + mensaje);
		javax.swing.JOptionPane.showMessageDialog( null, mensaje );
	}
}
