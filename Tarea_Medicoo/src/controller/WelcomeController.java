package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Usuario;
import view.MainView;
import view.panelAñadirMed;
import view.panelAñadirTratamiento;
import view.panelMiSalud;
import view.panelUser;

/**
 * controlador de la vista de bienvenida
 */
public class WelcomeController {

	private panelUser panel;
	private Usuario usuarioActual;

	/**
	 * constructor de la clase WelcomeController
	 * 
	 * @param panel
	 * @param usuarioActual
	 */
	public WelcomeController(panelUser panel, Usuario usuarioActual) {
		this.panel = panel;
		this.usuarioActual = usuarioActual;
	}

	/**
	 * metodo que añade eventos a los botones de la vista
	 */
	public void addListeners() {
		panel.getBtnAddMedicamento().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();

				panelAñadirMed medicamento = new panelAñadirMed();

				new MedicamentoController(medicamento, usuarioActual, panel);

				panel.add(medicamento, BorderLayout.CENTER);

				panel.revalidate();
				panel.repaint();
			}
		});

		panel.getBtnAddTratamiento().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (usuarioActual.getMedicamentos().isEmpty()) {
					JOptionPane.showMessageDialog(panel,
							"Primero debes añadir medicamentos antes de crear un tratamiento", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				panel.removeAll();

				panelAñadirTratamiento tratamiento = new panelAñadirTratamiento();

				new TratamientoController(tratamiento, usuarioActual, panel);

				panel.add(tratamiento, BorderLayout.CENTER);

				panel.revalidate();
				panel.repaint();
			}
		});

		panel.getBtnMiSalud().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();

				panelMiSalud miSalud = new panelMiSalud();

				new MiSaludController(miSalud, usuarioActual, panel);

				panel.add(miSalud, BorderLayout.CENTER);

				panel.revalidate();
				panel.repaint();
			}
		});

		panel.getBtnCerrarSesion().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int confirmacion = JOptionPane.showConfirmDialog(panel, "¿Estás seguro de que quieres cerrar sesión?",
						"Confirmar", JOptionPane.YES_NO_OPTION);

				if (confirmacion == JOptionPane.YES_OPTION) {
					MainView.contentPane.removeAll();
					MainView.contentPane.add(MainView.mainPanel, BorderLayout.CENTER);
					MainView.contentPane.revalidate();
					MainView.contentPane.repaint();
				}
			}
		});
	}
}