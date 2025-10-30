package controller;

import model.Medicamento;
import model.Tratamiento;
import model.Usuario;
import view.MainView;
import view.panelAñadirMed;
import view.panelAñadirTratamiento;
import view.panelMiSalud;
import view.panelUser;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * controlador de Mi Salud
 */
public class MiSaludController {

	private panelMiSalud vista;
	private Usuario usuarioActual;
	private panelUser panelPrincipal;
	private SimpleDateFormat sdf;

	/**
	 * constructor del controller de mi salud
	 * 
	 * @param vista
	 * @param usuarioActual
	 * @param panelPrincipal
	 */
	public MiSaludController(panelMiSalud vista, Usuario usuarioActual, panelUser panelPrincipal) {
		this.vista = vista;
		this.usuarioActual = usuarioActual;
		this.panelPrincipal = panelPrincipal;
		this.sdf = new SimpleDateFormat("dd/MM/yyyy");

		cargarMedicamentos();
		cargarTratamientos();

		addListeners();
	}

	/**
	 * Añade eventos a los botones
	 */
	private void addListeners() {
		vista.getBtnAddMedicamento().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelPrincipal.removeAll();
				panelAñadirMed medicamento = new panelAñadirMed();
				new MedicamentoController(medicamento, usuarioActual, panelPrincipal);
				panelPrincipal.add(medicamento, BorderLayout.CENTER);
				panelPrincipal.revalidate();
				panelPrincipal.repaint();
			}
		});

		vista.getBtnAddTratamiento().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (usuarioActual.getMedicamentos().isEmpty()) {
					JOptionPane.showMessageDialog(vista,
							"Primero debes añadir medicamentos antes de crear un tratamiento", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				panelPrincipal.removeAll();
				panelAñadirTratamiento tratamiento = new panelAñadirTratamiento();
				new TratamientoController(tratamiento, usuarioActual, panelPrincipal);
				panelPrincipal.add(tratamiento, BorderLayout.CENTER);
				panelPrincipal.revalidate();
				panelPrincipal.repaint();
			}
		});

		vista.getBtnMiSalud().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cargarMedicamentos();
				cargarTratamientos();
			}
		});

		vista.getBtnCerrarSesion().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cerrarSesion();
			}
		});

		// Botón de búsqueda de medicamentos - SIMPLIFICADO
		vista.getBtnBuscarMedicamento().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				filtrarMedicamentos();
			}
		});

		// Botón de búsqueda de tratamientos - SIMPLIFICADO
		vista.getBtnBuscarTratamiento().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				filtrarTratamientos();
			}
		});
	}

	/**
	 * muestra en la tabla los medicamentos que hay para el usuario actual
	 */
	public void cargarMedicamentos() {
		DefaultTableModel modelo = vista.getModeloMedicamentos();
		modelo.setRowCount(0);

		for (Medicamento med : usuarioActual.getMedicamentos()) {
			Object[] fila = { med.getNombre(), med.getLaboratorio(), med.getTipo(), med.getDescripcion() };
			modelo.addRow(fila);
		}
	}

	/**
	 * muestra los tratamientos que hay para los tratamientos del usuario
	 */
	public void cargarTratamientos() {
		DefaultTableModel modelo = vista.getModeloTratamientos();
		modelo.setRowCount(0);

		for (Tratamiento trat : usuarioActual.getMisTratamientos()) {
			Object[] fila = { trat.getMedicamento().getNombre(), sdf.format(trat.getFechaInicio()),
					sdf.format(trat.getFechaFin()), trat.getMedicamento().getTipo(), trat.getComprimidos(),
					trat.getHoras() };
			modelo.addRow(fila);
		}
	}

	/**
	 * metodo que filtra lo medicamentos
	 */
	private void filtrarMedicamentos() {
	}

	/**
	 * metodo que filtra tratamientos
	 */
	private void filtrarTratamientos() {
	}

	/**
	 * metodo que cierra la sesion iniciada
	 */
	private void cerrarSesion() {
		int confirmacion = JOptionPane.showConfirmDialog(vista, "¿Estás seguro de que quieres cerrar sesión?",
				"Confirmar", JOptionPane.YES_NO_OPTION);

		if (confirmacion == JOptionPane.YES_OPTION) {
			MainView.contentPane.removeAll();
			MainView.contentPane.add(MainView.mainPanel, BorderLayout.CENTER);
			MainView.contentPane.revalidate();
			MainView.contentPane.repaint();
		}
	}
}