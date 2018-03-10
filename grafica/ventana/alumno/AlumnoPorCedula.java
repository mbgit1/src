package grafica.ventana.alumno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import grafica.controlador.alumno.ControladorAlumnoPorCedula;
import grafica.ventana.Ventana;
import logica.vo.VOAlumnoDetallado;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlumnoPorCedula extends Ventana {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtFltCedula;
	private JTextField txtDescripcion;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDomicilio;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JTextField txtTipo;
	private JTextField txtDescuento;
	
	ControladorAlumnoPorCedula controlador;
	private JLabel lblCedula;
	private JTextField txtCedula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlumnoPorCedula frame = new AlumnoPorCedula();
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
	public AlumnoPorCedula() {
		controlador = new ControladorAlumnoPorCedula( this );
		
		setTitle("Listado de alumno por c\u00E9dula");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 348, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFltCedula = new JLabel("C\u00E9dula:");
		lblFltCedula.setBounds(24, 11, 46, 14);
		contentPane.add(lblFltCedula);
		
		txtFltCedula = new JTextField();
		txtFltCedula.setBounds(98, 8, 111, 20);
		contentPane.add(txtFltCedula);
		txtFltCedula.setColumns(10);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VOAlumnoDetallado voad = controlador.listar( txtFltCedula.getText() );
				if( voad != null ) {
					txtCedula.setText( Integer.toString( voad.getCedula() ) );
					txtNombre.setText( voad.getNombre() );
					txtApellido.setText( voad.getApellido() );
					txtDomicilio.setText( voad.getDomicilio() );
					txtTelefono.setText( Integer.toString( voad.getTelefono() ) );
					txtEmail.setText( voad.getEmail() );
					txtTipo.setText( voad.getTipo() );
					txtDescuento.setText( Integer.toString( voad.getDescuento() ) );
					txtDescripcion.setText( voad.getDescripcion() );
				}
			}
		});
		btnListar.setBounds(219, 7, 89, 23);
		contentPane.add(btnListar);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(24, 79, 78, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(24, 104, 78, 14);
		contentPane.add(lblApellido);
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setBounds(24, 129, 78, 14);
		contentPane.add(lblDomicilio);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(24, 154, 78, 14);
		contentPane.add(lblTelfono);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(24, 179, 78, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(24, 204, 78, 14);
		contentPane.add(lblTipo);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setBounds(24, 229, 78, 14);
		contentPane.add(lblDescuento);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n:");
		lblDescripcion.setBounds(24, 254, 78, 14);
		contentPane.add(lblDescripcion);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setEditable(false);
		txtDescripcion.setBounds(98, 251, 210, 20);
		contentPane.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(98, 76, 210, 20);
		contentPane.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		txtApellido.setColumns(10);
		txtApellido.setBounds(98, 101, 210, 20);
		contentPane.add(txtApellido);
		
		txtDomicilio = new JTextField();
		txtDomicilio.setEditable(false);
		txtDomicilio.setColumns(10);
		txtDomicilio.setBounds(98, 126, 210, 20);
		contentPane.add(txtDomicilio);
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(98, 151, 210, 20);
		contentPane.add(txtTelefono);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(98, 176, 210, 20);
		contentPane.add(txtEmail);
		
		txtTipo = new JTextField();
		txtTipo.setEditable(false);
		txtTipo.setColumns(10);
		txtTipo.setBounds(98, 201, 210, 20);
		contentPane.add(txtTipo);
		
		txtDescuento = new JTextField();
		txtDescuento.setEditable(false);
		txtDescuento.setColumns(10);
		txtDescuento.setBounds(98, 226, 210, 20);
		contentPane.add(txtDescuento);
		
		lblCedula = new JLabel("C\u00E9dula:");
		lblCedula.setBounds(24, 54, 46, 14);
		contentPane.add(lblCedula);
		
		txtCedula = new JTextField();
		txtCedula.setEditable(false);
		txtCedula.setColumns(10);
		txtCedula.setBounds(98, 48, 210, 20);
		contentPane.add(txtCedula);
	}
}
