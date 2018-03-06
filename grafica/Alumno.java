package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exception.AlumnoNoExisteException;
import exception.PersistenciaException;
import logica.vo.VOAlumnoModificar;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Alumno extends JFrame {

	private JPanel contentPane;
	private JTextField txtCi;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private int modo;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alumno frame = new Alumno(0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public Alumno(int modo, int cedula) {
		this.modo = modo;
		setTitle("Alumno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 339, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(26, 50, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(26, 75, 46, 14);
		contentPane.add(lblApellido);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setBounds(26, 100, 46, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(26, 125, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setBounds(26, 150, 46, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblCi = new JLabel("CI");
		lblCi.setBounds(26, 22, 46, 14);
		contentPane.add(lblCi);
		
		txtCi = new JTextField();
		txtCi.setBounds(89, 19, 205, 20);
		contentPane.add(txtCi);
		txtCi.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(89, 47, 205, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(89, 72, 205, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(89, 97, 205, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(89, 122, 205, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(89, 147, 205, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(modo ==  0) { //agrego
					
				}else { //modifico
					logica.vo.VOAlumnoModificar voa = new logica.vo.VOAlumnoModificar(Integer.parseInt(txtCi.getText()), txtDireccion.getText(), Integer.parseInt(txtTelefono.getText()), txtEmail.getText());
					logica.Fachada fachada;
					try {
						fachada = new logica.Fachada();
						fachada.modificarAlumno(voa);
						fachada.respaldar();
						dispose();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (AlumnoNoExisteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (PersistenciaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnAceptar.setBounds(54, 199, 92, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(171, 199, 92, 23);
		contentPane.add(btnCancelar);
		
		if(modo != 0)
			cargoInformacion(cedula);
	}
	
	private void cargoInformacion(int cedula) {
		logica.Fachada fachada;
		try {
			fachada = new logica.Fachada();
			logica.vo.VOAlumnoDetallado voa = fachada.listadoDetalleAlumno(cedula);
			txtCi.setText(Integer.toString(voa.getCedula()));
			txtNombre.setText(voa.getNombre());
			txtApellido.setText(voa.getApellido());
			txtDireccion.setText(voa.getDomicilio());
			txtTelefono.setText(Integer.toString(voa.getTelefono()));
			txtEmail.setText(voa.getEmail());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlumnoNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
