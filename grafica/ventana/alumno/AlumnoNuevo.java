package grafica.ventana.alumno;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import grafica.controlador.alumno.ControladorAlumnoNuevo;
import grafica.ventana.Ventana;

@SuppressWarnings("serial")
public class AlumnoNuevo extends Ventana {

	private JPanel contentPane;
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
					AlumnoNuevo frame = new AlumnoNuevo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AlumnoNuevo() {
		controladorAlumnoNuevo = new ControladorAlumnoNuevo( this );
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 325, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCedula = new JLabel("C\u00E9dula:");
		lblCedula.setBounds(34, 31, 46, 14);
		contentPane.add(lblCedula);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(34, 56, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(34, 81, 46, 14);
		contentPane.add(lblApellido);
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setBounds(34, 106, 46, 14);
		contentPane.add(lblDomicilio);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setBounds(34, 131, 46, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblEmail = new JLabel("EMail:");
		lblEmail.setBounds(34, 156, 46, 14);
		contentPane.add(lblEmail);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(90, 28, 205, 20);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(90, 53, 205, 20);
		contentPane.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(90, 78, 205, 20);
		contentPane.add(txtApellido);
		
		txtDomicilio = new JTextField();
		txtDomicilio.setColumns(10);
		txtDomicilio.setBounds(90, 103, 205, 20);
		contentPane.add(txtDomicilio);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(90, 128, 205, 20);
		contentPane.add(txtTelefono);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(90, 153, 205, 20);
		contentPane.add(txtEmail);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String strCedula	= txtCedula.getText();
				String nombre		= txtNombre.getText();
				String apellido		= txtApellido.getText();
				String domicilio	= txtDomicilio.getText();
				String strTelefono	= txtTelefono.getText();
				String email		= txtEmail.getText();
				
				if( !strCedula.isEmpty() ) {
					if( !nombre.isEmpty() ) {
						if( !apellido.isEmpty() ) {
							if( ! domicilio.isEmpty() ) {
								if( !strTelefono.isEmpty() ) {
									if( !email.isEmpty() ) {
										if ( soloNumeros( txtCedula.getText() ) ) {
											if ( soloNumeros( txtTelefono.getText() ) ) {
												int cedula = Integer.parseInt( strCedula );
												int telefono = Integer.parseInt( strTelefono );
												
												controladorAlumnoNuevo.grabar( cedula, nombre, apellido, domicilio, telefono, email );
											}else {
												showMessageDialog( "El teléfono debe ser numérico" );
											}
										}else {
											showMessageDialog( "La cédula debe ser numérica");
										}
									}else {
										showMessageDialog( "El email no puede ser vacío" );
									}
								}else {
									showMessageDialog( "El telefono no puede ser vacío" );
								}
							}else {
								showMessageDialog( "El domicilio no puede ser vacío" );
							}
						}else {
							showMessageDialog( "El apellido no puede ser vacío" );
						}	
					}else {
						showMessageDialog( "El nombre no puede ser vacío" );
					}
				}else {
					showMessageDialog( "La cédula no puede ser vacío" );
				}
			}
		});
		btnGuardar.setBounds(111, 184, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(210, 184, 89, 23);
		contentPane.add(btnCancelar);
	}

}
