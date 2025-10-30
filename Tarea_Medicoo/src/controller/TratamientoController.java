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
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * clase que cotrola la vista de tratamientos
 */
public class TratamientoController {

	private panelAñadirTratamiento vista;
	private Usuario usuarioActual;
	private panelUser panelPrincipal;

	/**
	 * constructor del controlador
	 * 
	 * @param vista
	 * @param usuarioActual
	 * @param panelPrincipal
	 */
	public TratamientoController(panelAñadirTratamiento vista, Usuario usuarioActual, panelUser panelPrincipal) {
		this.vista = vista;
		this.usuarioActual = usuarioActual;
		this.panelPrincipal = panelPrincipal;

		vista.cargarMedicamentos(usuarioActual.getMedicamentos());

		addListeners();
	}

	/**
	 * añade los eventos a los botones e la vista
	 */
	private void addListeners() {
		vista.getCBMedicamento().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actualizarDatosMedicamento();
			}
		});

		vista.getBtnAgregar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				agregarTratamiento();
			}
		});

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
			}
		});

		vista.getBtnMiSalud().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelPrincipal.removeAll();
				panelMiSalud miSalud = new panelMiSalud();
				new MiSaludController(miSalud, usuarioActual, panelPrincipal);
				panelPrincipal.add(miSalud, BorderLayout.CENTER);
				panelPrincipal.revalidate();
				panelPrincipal.repaint();
			}
		});

		vista.getBtnCerrarSesion().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cerrarSesion();
			}
		});
	}

	/**
	 * actualiza los datos de los medicamentos
	 */
	private void actualizarDatosMedicamento() {
		String medicamentoNombre = (String) vista.getCBMedicamento().getSelectedItem();

		if (medicamentoNombre == null || medicamentoNombre.equals("Seleccione un medicamento")) {
			vista.getTxtTipoMedicamento().setText("");
			vista.getTxtDescripcion().setText("");
			return;
		}

		for (Medicamento med : usuarioActual.getMedicamentos()) {
			if (med.getNombre().equals(medicamentoNombre)) {
				vista.getTxtTipoMedicamento().setText(med.getTipo().toString());
				vista.getTxtDescripcion().setText(med.getDescripcion());
				break;
			}
		}
	}

	/**
	 * agrega tratamiento al usuario Actual
	 */
	private void agregarTratamiento() {
		if (usuarioActual.getMedicamentos().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Primero debes añadir medicamentos antes de crear un tratamiento",
					"Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		String medicamentoNombre = (String) vista.getCBMedicamento().getSelectedItem();
		String descripcion = vista.getTxtDescripcion().getText().trim();
		Date fechaInicio = vista.getDateInicio().getDate();
		Date fechaFin = vista.getDateFin().getDate();
		int comprimidos = (Integer) vista.getSpinnerComprimidos().getValue();
		int horas = (Integer) vista.getSpinnerHoras().getValue();

		if (medicamentoNombre == null || medicamentoNombre.equals("Seleccione un medicamento")) {
			JOptionPane.showMessageDialog(null, "Debes seleccionar un medicamento", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (descripcion.isEmpty()) {
			JOptionPane.showMessageDialog(null, "La descripción es obligatoria", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (fechaInicio == null || fechaFin == null) {
			JOptionPane.showMessageDialog(null, "Debes seleccionar las fechas de inicio y fin", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (fechaFin.before(fechaInicio)) {
			JOptionPane.showMessageDialog(null, "La fecha de fin no puede ser anterior a la fecha de inicio", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		Medicamento medicamentoSeleccionado = null;
		for (Medicamento med : usuarioActual.getMedicamentos()) {
			if (med.getNombre().equals(medicamentoNombre)) {
				medicamentoSeleccionado = med;
				break;
			}
		}

		if (medicamentoSeleccionado == null) {
			JOptionPane.showMessageDialog(null, "Error al encontrar el medicamento", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		Tratamiento nuevoTratamiento = new Tratamiento(medicamentoSeleccionado, fechaInicio, fechaFin, comprimidos,
				horas);

		usuarioActual.getMisTratamientos().add(nuevoTratamiento);

		JOptionPane.showMessageDialog(null, "Tratamiento añadido correctamente\n\n", "Éxito",
				JOptionPane.INFORMATION_MESSAGE);

		limpiarCampos();
	}

	/**
	 * limpia lo campos de la vista
	 */
	private void limpiarCampos() {
		vista.getCBMedicamento().setSelectedIndex(0);
		vista.getTxtDescripcion().setText("");
		vista.getDateInicio().setDate(null);
		vista.getDateFin().setDate(null);
		vista.getSpinnerComprimidos().setValue(1);
		vista.getSpinnerHoras().setValue(8);
	}

	/**
	 * cierra la sesion abierta
	 */
	private void cerrarSesion() {
		int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres cerrar sesión?",
				"Confirmar", JOptionPane.YES_NO_OPTION);

		if (confirmacion == JOptionPane.YES_OPTION) {
			MainView.contentPane.removeAll();
			MainView.contentPane.add(MainView.mainPanel, BorderLayout.CENTER);
			MainView.contentPane.revalidate();
			MainView.contentPane.repaint();
		}
	}
}