package grafica.ventana.alumno;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import grafica.controlador.alumno.ControladorAlumnoNuevo;
import grafica.ventana.Ventana;
import javax.swing.JRadioButton;

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
	private JTextField txtDescuento;
	private JTextField txtDescripcion;

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
		setTitle("Nuevo alumno");
		controladorAlumnoNuevo = new ControladorAlumnoNuevo( this );
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 381, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCedula = new JLabel("C\u00E9dula:");
		lblCedula.setBounds(34, 31, 71, 14);
		contentPane.add(lblCedula);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(34, 56, 71, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(34, 81, 71, 14);
		contentPane.add(lblApellido);
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setBounds(34, 106, 71, 14);
		contentPane.add(lblDomicilio);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setBounds(34, 131, 71, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblEmail = new JLabel("EMail:");
		lblEmail.setBounds(34, 156, 71, 14);
		contentPane.add(lblEmail);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(131, 28, 205, 20);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(131, 53, 205, 20);
		contentPane.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(131, 78, 205, 20);
		contentPane.add(txtApellido);
		
		txtDomicilio = new JTextField();
		txtDomicilio.setColumns(10);
		txtDomicilio.setBounds(131, 103, 205, 20);
		contentPane.add(txtDomicilio);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(131, 128, 205, 20);
		contentPane.add(txtTelefono);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(131, 153, 205, 20);
		contentPane.add(txtEmail);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(251, 282, 89, 23);
		contentPane.add(btnCancelar);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		JRadioButton rbtnTipoComun = new JRadioButton("com\u00FAn");
		rbtnTipoComun.setBounds(131, 180, 71, 23);
		rbtnTipoComun.setSelected( true );
		contentPane.add(rbtnTipoComun);
		buttonGroup.add(rbtnTipoComun);
		JRadioButton rbtnTipoBecado = new JRadioButton("becado");
		rbtnTipoBecado.setBounds(227, 180, 71, 23);
		contentPane.add(rbtnTipoBecado);
		buttonGroup.add(rbtnTipoBecado);				
		
		txtDescuento = new JTextField();
		txtDescuento.setColumns(10);
		txtDescuento.setBounds(131, 210, 205, 20);
		contentPane.add(txtDescuento);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(131, 241, 205, 20);
		contentPane.add(txtDescripcion);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setBounds(34, 213, 71, 14);
		contentPane.add(lblDescuento);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(34, 244, 71, 14);
		contentPane.add(lblDescripcin);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(34, 184, 71, 14);
		contentPane.add(lblTipo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String cedula		= txtCedula.getText();
				String nombre		= txtNombre.getText();
				String apellido		= txtApellido.getText();
				String domicilio	= txtDomicilio.getText();
				String telefono		= txtTelefono.getText();
				String email		= txtEmail.getText();
				boolean becado		= rbtnTipoBecado.isSelected();
				String descuento	= txtDescuento.getText();
				String descripcion	= txtDescripcion.getText();
				
				controladorAlumnoNuevo.grabar( cedula, nombre, apellido, domicilio, telefono, email, becado, descuento, descripcion );
		
			}
		});
		btnGuardar.setBounds(152, 282, 89, 23);
		contentPane.add(btnGuardar);
	}
}
