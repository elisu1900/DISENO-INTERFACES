package controller;

import model.Medicamento;
import model.TipoMedicamento;
import model.Usuario;
import view.MainView;
import view.panelAñadirMed;
import view.panelAñadirTratamiento;
import view.panelMiSalud;
import view.panelUser;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * Controlador de medicamentos
 */
public class MedicamentoController {

	private panelAñadirMed vista;
	private Usuario usuarioActual;
	private panelUser panelPrincipal;

	/**
	 * constructor de medicamentoController
	 * 
	 * @param vista
	 * @param usuarioActual
	 * @param panelPrincipal
	 */
	public MedicamentoController(panelAñadirMed vista, Usuario usuarioActual, panelUser panelPrincipal) {
		this.vista = vista;
		this.usuarioActual = usuarioActual;
		this.panelPrincipal = panelPrincipal;
		addListeners();
	}

	/**
	 * añade los Eventos a los botones de la pantalla
	 */
	private void addListeners() {
		vista.getBtnAdd().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				añadirMedicamento();
			}
		});

		vista.getBtnAddMedicamento().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// estamos aqui
			}
		});

		vista.getBtnAddTratamiento().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (usuarioActual.getMedicamentos().isEmpty()) {
					JOptionPane.showMessageDialog(null,
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
	 * metodo que añade un medicamento al usuario al que esta linkeado
	 */
	private void añadirMedicamento() {
		String nombre = vista.getTxtNombreMed().getText().trim();
		String laboratorio = vista.getTxtLaboratorioMed().getText().trim();
		TipoMedicamento tipo = (TipoMedicamento) vista.getCBTipo().getSelectedItem();
		String descripcion = vista.getTxtDescripcionMed().getText().trim();

		if (nombre.isEmpty() || laboratorio.isEmpty() || descripcion.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debes completar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		Medicamento nuevoMedicamento = new Medicamento(nombre, laboratorio, tipo, descripcion);

		usuarioActual.getMedicamentos().add(nuevoMedicamento);

		JOptionPane.showMessageDialog(null, "Medicamento añadido correctamente", "Mensaje",
				JOptionPane.INFORMATION_MESSAGE);

		limpiarCampos();
	}

	private void limpiarCampos() {
		vista.getTxtNombreMed().setText("");
		vista.getTxtLaboratorioMed().setText("");
		vista.getTxtDescripcionMed().setText("");
		vista.getCBTipo().setSelectedIndex(0);
	}

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

	public List<Medicamento> obtenerMedicamentos() {
		return usuarioActual.getMedicamentos();
	}
}