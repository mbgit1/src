package grafica.ventana.asignatura;

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


import grafica.controlador.asignatura.ControladorAsignaturaListado;
import grafica.ventana.Ventana;



@SuppressWarnings("serial")
public class AsignaturaListado extends Ventana {

	private JPanel contentPane;
	private JTable table;
	
	ControladorAsignaturaListado controlador;
	
	
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AsignaturaListado frame = new AsignaturaListado();
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
	public AsignaturaListado() {
		
		controlador = new ControladorAsignaturaListado(this);
		
		setTitle("Listado de Asignaturas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 652, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarTabla();
			}
		});
		btnListar.setBounds(500, 61, 105, 25);
		contentPane.add(btnListar);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Codigo", "Nombre", "Descripcion" 
			}
		) {
			Class[] columnTypes = new Class[] {
				 String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		table.setBounds(10, 106, 454, 211);
		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(10, 55, 454, 211);
		contentPane.add(jScrollPane);
		
	}	
		
		private void cargarTabla() {
			DefaultTableModel dtm = ((DefaultTableModel)table.getModel());
			
			List<logica.vo.VOAsignatura > lvoasig = controlador.listarAsignaturas();
			
			for(int row = table.getModel().getRowCount() - 1 ; row >= 0 ; row--)
				dtm.removeRow(row);
			
			for(logica.vo.VOAsignatura voa : lvoasig) {
				dtm.addRow(new Object[]{voa.getCodigo(), voa.getNombre(), voa.getDescripcion()});;
			}
			table.repaint();
		}
		
		public void showMessageDialog( String mensaje ) {
			//System.out.println("ventana mensaje?: " + mensaje);
			javax.swing.JOptionPane.showMessageDialog( null, mensaje );
		} 
		


}
