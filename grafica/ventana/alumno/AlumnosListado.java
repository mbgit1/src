package grafica.ventana.alumno;

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

import grafica.controlador.alumno.ControladorAlumnosListado;
import grafica.ventana.Ventana;
import grafica.ventana.alumno.AlumnoNuevo;;

@SuppressWarnings("serial")
public class AlumnosListado extends Ventana{

	private JPanel contentPane;
	private JTextField txtFltApellido;
	private JTable table;
	private JButton btnAgregar;
	private JButton btnModificar;
	private AlumnoNuevo alumnoNuevo;
	private AlumnoModificar alumnoModificar;
	
	ControladorAlumnosListado controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlumnosListado frame = new AlumnosListado();
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
	public AlumnosListado() {
		controlador = new ControladorAlumnosListado( this );
		
		setTitle("Listado de Alumnos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFltApellido = new JLabel("Apellido:");
		lblFltApellido.setBounds(10, 13, 66, 14);
		contentPane.add(lblFltApellido);
		
		txtFltApellido = new JTextField();
		txtFltApellido.setBounds(60, 10, 178, 20);
		contentPane.add(txtFltApellido);
		txtFltApellido.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarTabla();
			}
		});
		btnBuscar.setBounds(248, 10, 90, 20);
		contentPane.add(btnBuscar);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"CI", "Nombre", "Apellido", "Tipo"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(10, 106, 454, 211);
		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(10, 55, 454, 211);
		contentPane.add(jScrollPane);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (alumnoNuevo != null)
					alumnoNuevo.dispose();
				alumnoNuevo = new AlumnoNuevo();
				alumnoNuevo.setVisible(true);
			}
		});
		btnAgregar.setBounds(474, 59, 100, 20);
		contentPane.add(btnAgregar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if( table.getSelectedRow() >= 0 ) {
					int cedula = (int)table.getValueAt(table.getSelectedRow(), 0);
					
					if (alumnoModificar != null)
						alumnoModificar.dispose();
					
					alumnoModificar = new AlumnoModificar( cedula );
					alumnoModificar.setVisible(true);	
				}else {
					showMessageDialog( "Seleccione un alumno para modificar" );
				}
			}
		});
		btnModificar.setBounds(474, 90, 100, 20);
		contentPane.add(btnModificar);
		
		cargarTabla();
	}
	
	private void cargarTabla() {
		DefaultTableModel dtm = ((DefaultTableModel)table.getModel());
		
		List<logica.vo.VOAlumnoListado> lvoa = controlador.listarAlumnos( txtFltApellido.getText() );
		
		for(int row = table.getModel().getRowCount() - 1 ; row >= 0 ; row--)
			dtm.removeRow(row);
		
		for(logica.vo.VOAlumnoListado voa : lvoa) {
			dtm.addRow(new Object[]{voa.getCedula(), voa.getNombre(), voa.getApellido(), voa.getTipo()});;
		}
		table.repaint();
	}
	
	public void showMessageDialog( String mensaje ) {
		//System.out.println("ventana mensaje?: " + mensaje);
		javax.swing.JOptionPane.showMessageDialog( null, mensaje );
	}

}
