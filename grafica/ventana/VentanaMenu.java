package grafica.ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import grafica.controlador.ControladorMenuPrincipal;
import grafica.ventana.alumno.AlumnoNuevo;
import grafica.ventana.alumno.AlumnoPorCedula;
import grafica.ventana.alumno.AlumnosListado;
import grafica.ventana.asignatura.AsignaturaListado;
import grafica.ventana.asignatura.AsignaturaNueva;
import grafica.ventana.inscripciones.InscripcionCalificar;
import grafica.ventana.inscripciones.InscripcionNueva;
import grafica.ventana.inscripciones.InscripcionesListado;

public class VentanaMenu extends Ventana {

	private JPanel contentPane;
	ControladorMenuPrincipal controlador;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenu frame = new VentanaMenu();
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
	public VentanaMenu() {

		controlador = new ControladorMenuPrincipal(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 917, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JMenuBar menu = new JMenuBar();
		menu.setBounds(0, 0, 0, 0);
		contentPane.add(menu, BorderLayout.NORTH);

		JMenuItem itemRespaldar = new JMenuItem("Respaldar Datos");
		itemRespaldar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemRespaldarActionPerformed(e);
			}
		});
		menu.add(itemRespaldar);

		JMenuItem itemEscolaridad = new JMenuItem("Consulta Escolaridad");
		itemEscolaridad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemEscolaridadActionPerformed(e);
			}
		});
		menu.add(itemEscolaridad);

		JMenuItem itemEgresados = new JMenuItem("Listado de Egresados");
		itemEgresados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemEgresadosActionPerformed(e);
			}
		});
		menu.add(itemEgresados);


		JMenu asignaturas = new JMenu("Asignaturas");
		menu.add(asignaturas);

		JMenu alumnos = new JMenu("Alumnos");
		menu.add(alumnos);

		JMenu inscripciones = new JMenu("Inscripciones");
		menu.add(inscripciones);

		//Asignaturas
		JMenuItem mnRegistrarAsignatrua = new JMenuItem("Registrar Asignatura");
		mnRegistrarAsignatrua.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mnRegistrarAsignatruaActionPerformed(e);
			}
		});
		asignaturas.add(mnRegistrarAsignatrua);

		JMenuItem mnListarAsignatrua = new JMenuItem("Listar Asignatura");
		mnListarAsignatrua.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mnListarAsignatruaActionPerformed(e);
			}
		});
		asignaturas.add(mnListarAsignatrua);

		//Alumnos
		JMenuItem mnRegistrarAlumno = new JMenuItem("Registrar Alumno");
		mnRegistrarAlumno.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mnRegistrarAlumnoActionPerformed(e);
			}
		});
		alumnos.add(mnRegistrarAlumno);

		JMenuItem mnModificarAlumno = new JMenuItem("Modificar Alumno");
		mnModificarAlumno.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mnModificarAlumnoActionPerformed(e);
			}
		});
		alumnos.add(mnModificarAlumno);

		JMenuItem mnListarAlumno = new JMenuItem("Listar Alumnos Apellido");
		mnListarAlumno.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mnListarAlumnoActionPerformed(e);
			}
		});
		alumnos.add(mnListarAlumno);

		JMenuItem mnDetalleAlumno = new JMenuItem("Detalle Alumno");
		mnDetalleAlumno.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mnDetalleAlumnoActionPerformed(e);
			}
		});
		alumnos.add(mnDetalleAlumno);

		//Inscripciones
		JMenuItem mnRegistrarInscripcion = new JMenuItem("Registrar Inscripcion");
		mnRegistrarInscripcion.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mnRegistrarInscripcionActionPerformed(e);
			}
		});
		inscripciones.add(mnRegistrarInscripcion);

		JMenuItem mnRegistrarCalificacion = new JMenuItem("Registrar Calificacion");
		mnRegistrarCalificacion.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mnRegistrarCalificacionActionPerformed(e);
			}
		});
		inscripciones.add(mnRegistrarCalificacion);

		JMenuItem mnCalcularMonto = new JMenuItem("Calcular Monto");
		mnCalcularMonto.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mnCalcularMontoActionPerformed(e);
			}
		});
		inscripciones.add(mnCalcularMonto);

	}



	//ACCCION DE ITEMRESPALDAR

	private void itemRespaldarActionPerformed(ActionEvent e) {
		 controlador.respaldar();

	}
	//ACCCION DE ITEMESCOLARIDAD
	private void itemEscolaridadActionPerformed(ActionEvent e) {

		InscripcionesListado ventana = new InscripcionesListado();
		ventana.setVisible(true);

	}

	//ACCCION DE ITEMEGRESADOS
	private void itemEgresadosActionPerformed(ActionEvent e) {
		//falta hacer 

	}

	//ACCION DE  mnRegistrarAsignatrua REGISTRAR ASIGNATURA
	private void mnRegistrarAsignatruaActionPerformed(ActionEvent e) {
		AsignaturaNueva ventana = new AsignaturaNueva();
		ventana.setVisible(true);

	}

	//ACCION DE  mnListarAsignatrua LISTAR ASIGNATURA
	private void mnListarAsignatruaActionPerformed(ActionEvent e) {
		AsignaturaListado ventana = new AsignaturaListado();
		ventana.setVisible(true);

	}

	//ACCION DE  mnRegistrarAlumno REGISTRAR ALUMNO 
	private void mnRegistrarAlumnoActionPerformed(ActionEvent e) {
		AlumnoNuevo ventana = new AlumnoNuevo();
		ventana.setVisible(true);

	}

	//ACCION DE  mnModificarAlumno MODIFICAR ALUMNO
	private void mnModificarAlumnoActionPerformed(ActionEvent e) {
		AlumnosListado ventana = new AlumnosListado();
		ventana.setVisible(true);

	}

	//ACCION DE  mnListadoAlumno LISTAR ALUMNO POR APELLIDO
	private void mnListarAlumnoActionPerformed(ActionEvent e) {
		AlumnosListado ventana = new AlumnosListado();
		ventana.setVisible(true);

	}

	//ACCION DE  mnDetalleAlumno  ALUMNO DETALLADO  
	private void mnDetalleAlumnoActionPerformed(ActionEvent e) {
		 AlumnoPorCedula ventana = new AlumnoPorCedula();
		 ventana.setVisible(true);

	}


	//ACCION DE  mnRegistrarInscripcion REGISTRAR INSCRIPCION
	private void mnRegistrarInscripcionActionPerformed(ActionEvent e) {
		 InscripcionNueva ventana = new InscripcionNueva("");
		 ventana.setVisible(true);

	}

	//ACCION DE  mnRegistrarCalificacion REGISTRAR CALIFICACION
	private void mnRegistrarCalificacionActionPerformed(ActionEvent e) {
		 InscripcionCalificar ventana = new InscripcionCalificar("",0);
		 ventana.setVisible(true);

	}

	//ACCION DE  mnCalcularMonto CALCULAR MONTO POR INSCRIPCIONES  
	private void mnCalcularMontoActionPerformed(ActionEvent e) {
		// AlumnosPorCedula ventana = new AlumnosPorCedula();
		// ventana.setVisible(true);

	}
}
