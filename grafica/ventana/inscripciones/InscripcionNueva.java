package grafica.ventana.inscripciones;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import grafica.controlador.inscripciones.ControladorInscripcionNueva;
import grafica.ventana.Ventana;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class InscripcionNueva extends Ventana {

	private JPanel contentPane;
	private JTextField anioLectivo;
	private JTextField montoBase;
	private JComboBox listAsignaturas;
	
	ControladorInscripcionNueva controlador;
	private JTextField textCedula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscripcionNueva frame = new InscripcionNueva("");
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
	public InscripcionNueva(String cedula) {
		setTitle("Nueva Inscripci\u00F3n");
		setResizable(false);
		controlador = new ControladorInscripcionNueva(this);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 480, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSeleccioneAsignatura = new JLabel("Select Asignatura: ");
		lblSeleccioneAsignatura.setBounds(27, 45, 112, 14);
		
		JLabel lblAoLectivo = new JLabel("A\u00F1o lectivo:");
		lblAoLectivo.setBounds(27, 86, 112, 14);
		
		anioLectivo = new JTextField();
		anioLectivo.setBounds(170, 82, 174, 23);
		anioLectivo.setColumns(10);
		
		JLabel lblMontoBase = new JLabel("Monto base:");
		lblMontoBase.setBounds(27, 120, 112, 14);
		
		montoBase = new JTextField();
		montoBase.setBounds(170, 116, 174, 23);
		montoBase.setColumns(10);

		listAsignaturas = new JComboBox();
		listAsignaturas.setBounds(170, 41, 174, 23);
		
				
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(380, 142, 74, 23);
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cedula = textCedula.getText();
				String anio = anioLectivo.getText();
				String monto = montoBase.getText();
				String codigo = (String)listAsignaturas.getSelectedItem();
				
				//showMessageDialog( codigo );
				controlador.crear(cedula, codigo, anio, monto);
				//showMessageDialog( codigo );
			}
		});
		contentPane.setLayout(null);
		contentPane.add(lblSeleccioneAsignatura);
		contentPane.add(lblAoLectivo);
		contentPane.add(lblMontoBase);
		contentPane.add(anioLectivo);
		contentPane.add(montoBase);
		contentPane.add(listAsignaturas);
		contentPane.add(btnCrear);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(27, 11, 46, 14);
		contentPane.add(lblCedula);
		
		textCedula = new JTextField();
		textCedula.setHorizontalAlignment(SwingConstants.LEFT);
		textCedula.setBounds(170, 8, 174, 23);
		contentPane.add(textCedula);
		textCedula.setColumns(10);
		
		textCedula.setText(cedula);
		
		cargarListaAsignaturas();
	}
	
	private void cargarListaAsignaturas(){	
		

		
		List<logica.vo.VOAsignatura> lvoas = controlador.listarAsignaturas();

		if (lvoas != null) {
			listAsignaturas.addItem("");
			for(logica.vo.VOAsignatura voa : lvoas) {
				listAsignaturas.addItem(voa.getCodigo());		
			}
		}else
			showMessageDialog( "Lista de asignaturas vacia" );
		
		/*
		Asignatura as = new Asignatura();
		as.setAsignatura("as1", "Asignatura 1");
		
		
		listAsignaturas.addItem(as.nombreAsignaura());
		*/		
	}
	
	public class Asignatura {
		   private String codigo;
		   private String nombreAs;

		   public void setAsignatura(String codigo, String nombreAs) {
			      this.codigo = codigo;
			      this.nombreAs = nombreAs;
		   }
		   public String nombreAsignaura() {
		      return nombreAs;
		   }
		   public String codigoAsignaura() {
			      return codigo;
		   }		   
		}
}


