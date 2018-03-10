package grafica.ventana.inscripciones;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import javax.swing.JLabel;

import grafica.controlador.inscripciones.ControladorInscripcionesListado;

import grafica.ventana.Ventana;

import grafica.ventana.inscripciones.InscripcionNueva;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import logica.vo.VOEscolaridad;


@SuppressWarnings("serial")
public class InscripcionesListado extends Ventana{

	private JPanel contentPane;
	private JTextField txtCedula;
	private JTable table;
	private JButton btnAgregar;
	private JButton btnModificar;
	private InscripcionNueva inscripcionNueva;
	private InscripcionCalificar inscripcionCalificar;

	
	ControladorInscripcionesListado controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscripcionesListado frame = new InscripcionesListado();
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
	public InscripcionesListado() {
		controlador = new ControladorInscripcionesListado( this );
		
		setTitle("Listado de Inscripciones");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFltCedula = new JLabel("Cedula:");
		lblFltCedula.setBounds(10, 34, 66, 14);
		contentPane.add(lblFltCedula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(113, 31, 151, 20);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);
		
		JButton btnBuscar = new JButton("Obtener");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					cargarTabla();
				} catch (Exception a) {
					//showMessageDialog( "Vuelva a intentar con otra cédula" );
				}
			}
		});
		btnBuscar.setBounds(280, 31, 90, 20);
		contentPane.add(btnBuscar);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"N\u00B0 Inscripci\u00F3n", "Nombre Asignatura", "A\u00F1o Lectivo", "Calificaci\u00F3n", "Monto Base"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(10, 106, 454, 211);
		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(10, 109, 561, 211);
		contentPane.add(jScrollPane);
		
		btnAgregar = new JButton("Nueva Inscripción");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cedula	= txtCedula.getText();
				
				if (inscripcionNueva != null)
					inscripcionNueva.dispose();
				inscripcionNueva = new InscripcionNueva(cedula);
				inscripcionNueva.setVisible(true);
			}
		});
		btnAgregar.setBounds(380, 31, 142, 20);
		contentPane.add(btnAgregar);
		
		btnModificar = new JButton("Calificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if( table.getSelectedRow() >= 0 ) {
					String cedula	= txtCedula.getText();
					int numeroInsc = (int)table.getValueAt(table.getSelectedRow(), 0);
					
					if (inscripcionCalificar != null)
						inscripcionCalificar.dispose();
					inscripcionCalificar = new InscripcionCalificar(cedula, numeroInsc);
					inscripcionCalificar.setVisible(true);
				}else {
					showMessageDialog( "Seleccione una inscripción para calificar" );
				}
			}
		});
		btnModificar.setBounds(10, 74, 102, 20);
		contentPane.add(btnModificar);
		
		JLabel lblModoListado = new JLabel("Modo Listado:");
		lblModoListado.setBounds(10, 11, 90, 14);
		contentPane.add(lblModoListado);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Completo", "Parcial"}));
		comboBox.setBounds(113, 8, 151, 20);
		contentPane.add(comboBox);
		
		//cargarTabla();
	}
	
	private void cargarTabla(){		
		String strCedula	= txtCedula.getText();
		
		DefaultTableModel dtm = ((DefaultTableModel)table.getModel());
		

		List<logica.vo.VOEscolaridad> lvoe = controlador.listarInscripciones(strCedula, false);
		
		for(int row = table.getModel().getRowCount() - 1 ; row >= 0 ; row--)
			dtm.removeRow(row);
		
		for(logica.vo.VOEscolaridad voe : lvoe) {
			dtm.addRow(new Object[]{voe.getNumero(), voe.getAsignaturaNombre(), voe.getAnioLectivo(), voe.getCalificacion(), voe.getMontoBase()});;
		}
		table.repaint();

	}
	
	public void showMessageDialog( String mensaje ) {

		javax.swing.JOptionPane.showMessageDialog( null, mensaje );
	}
}
