package grafica.ventana.alumno;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import grafica.controlador.alumno.ControladorAlumnoModificar;
import grafica.ventana.Ventana;
import logica.vo.VOAlumnoDetallado;

@SuppressWarnings("serial")
public class AlumnoModificar extends Ventana {

	private JPanel contentPane;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDomicilio;
	private JTextField txtTelefono;
	private JTextField txtEmail;

	private ControladorAlumnoModificar controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlumnoModificar frame = new AlumnoModificar(0);
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
	public AlumnoModificar( int cedula ) {
		setTitle("Modificar alumno");
		controlador = new ControladorAlumnoModificar( this );

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 336, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

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
		txtCedula.setEnabled( false );
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(90, 53, 205, 20);
		txtNombre.setEnabled( false );
		contentPane.add(txtNombre);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(90, 78, 205, 20);
		txtApellido.setEnabled( false );
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

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String cedula		= txtCedula.getText();
				String domicilio	= txtDomicilio.getText();
				String telefono		= txtTelefono.getText();
				String email		= txtEmail.getText();

				controlador.grabar( cedula, domicilio, telefono, email );
				
			}
		});
		
		btnModificar.setBounds(100, 184, 89, 23);
		contentPane.add(btnModificar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(206, 184, 89, 23);
		contentPane.add(btnCancelar);

		cargoDatos( cedula );
	}

	private void cargoDatos( int cedula ) {
		VOAlumnoDetallado voad = controlador.obtenerAlumno( cedula );
		if( voad != null ) {
			txtCedula.setText( Integer.toString( voad.getCedula() ) );
			txtNombre.setText( voad.getNombre() );
			txtApellido.setText( voad.getApellido() );
			txtDomicilio.setText( voad.getDomicilio() );
			txtTelefono.setText( Integer.toString( voad.getTelefono() ) );
			txtEmail.setText( voad.getEmail() );
		}
	}

}
