package grafica;

import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

public class Alumnos extends JFrame {

	private JPanel contentPane;
	private JTextField txtFltApellido;
	private JTable table;
	private JButton btnAgregar;
	private JButton btnModificar;
	private Alumno alumno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alumnos frame = new Alumnos();
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
	public Alumnos() {
		setTitle("Alumnos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFltApellido = new JLabel("Apellido:");
		lblFltApellido.setBounds(10, 13, 46, 14);
		contentPane.add(lblFltApellido);
		
		txtFltApellido = new JTextField();
		txtFltApellido.setBounds(66, 10, 178, 20);
		contentPane.add(txtFltApellido);
		txtFltApellido.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarTabla();
			}
		});
		btnBuscar.setBounds(254, 10, 65, 20);
		contentPane.add(btnBuscar);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"CI", "Nombre", "Apellido", "Email", "Tel\u00E9fono"
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
		contentPane.add(table);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (alumno != null)
					alumno.dispose();
				alumno = new Alumno(0, 0);
				alumno.setVisible(true);
			}
		});
		btnAgregar.setBounds(481, 119, 71, 20);
		contentPane.add(btnAgregar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (alumno != null)
					alumno.dispose();
				alumno = new Alumno(1, (int)table.getValueAt(table.getSelectedRow(), 0) );
				alumno.setVisible(true);
			}
		});
		btnModificar.setBounds(481, 150, 71, 20);
		contentPane.add(btnModificar);
		
		cargarTabla();
	}
	
	private void cargarTabla() {
		try {
			DefaultTableModel dtm = ((DefaultTableModel)table.getModel());
			logica.Fachada fachada = new logica.Fachada();
			java.util.List<logica.vo.VOAlumnoListado> lvoa = fachada.listarAlumnos(txtFltApellido.getText());
			
			for(int row = 0; row < table.getModel().getRowCount(); row++)
				dtm.removeRow(row);
			
			for(logica.vo.VOAlumnoListado voa : lvoa) {
				dtm.addRow(new Object[]{voa.getCedula(), voa.getNombre(), voa.getApellido(), voa.getTipo()});;
			}
			table.repaint();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
