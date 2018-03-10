package grafica.ventana.asignatura;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import grafica.controlador.asignatura.ControladorAsignaturaNueva;
import grafica.ventana.Ventana;


@SuppressWarnings("serial")
public class AsignaturaNueva extends Ventana {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtDescripcion;
  
	ControladorAsignaturaNueva controladorAsignaturaNueva;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AsignaturaNueva frame = new AsignaturaNueva();
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
	public AsignaturaNueva() {
		
		controladorAsignaturaNueva = new  ControladorAsignaturaNueva( this );
	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(34, 31, 46, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(34, 56, 79, 14);
		contentPane.add(lblNombre);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(34, 80, 79, 14);
		contentPane.add(lblDescripcion);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(125, 28, 205, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(125, 53, 205, 20);
		contentPane.add(txtNombre);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(125, 77, 205, 64);
		contentPane.add(txtDescripcion);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String codigo	    = txtCodigo.getText();
				String nombre		= txtNombre.getText();
				String descripcion  = txtDescripcion.getText();
				if( !codigo.isEmpty() ) {
					if( !nombre.isEmpty() ) {
						if( !descripcion.isEmpty() ) {
							
						
						controladorAsignaturaNueva.grabar( codigo, nombre, descripcion );
						}
						else {
							showMessageDialog( "La descripcion no puede ser vacía" );
						}
				}
				else {
					showMessageDialog( "El nombre no puede ser vacío" );
				}
			}
			else {
				showMessageDialog( "El codigo no puede ser vacío" );
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
 