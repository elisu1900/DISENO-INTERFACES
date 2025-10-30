package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import controller.WelcomeController;
import model.Usuario;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class panelUser extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton btnAddMedicamento;
	private JButton btnAddTratamiento;
	private JButton btnMiSalud;
	private JButton btnCerrarSesion;
	private Usuario usuarioActual;

	public panelUser(Usuario usuario) {
		this.usuarioActual = usuario;
		setLayout(new BorderLayout(0, 0));

		JPanel panelBtn = new JPanel();
		panelBtn.setBackground(new Color(152, 251, 152));
		add(panelBtn, BorderLayout.WEST);
		panelBtn.setLayout(new GridLayout(0, 1, 0, 0));

		btnAddMedicamento = new JButton("Añadir medicamento");
		btnAddMedicamento.setForeground(new Color(255, 255, 255));
		btnAddMedicamento.setBackground(new Color(9, 119, 33));
		panelBtn.add(btnAddMedicamento);

		btnAddTratamiento = new JButton("Añadir tratamiento");
		btnAddTratamiento.setBackground(new Color(9, 119, 33));
		btnAddTratamiento.setForeground(new Color(255, 255, 255));
		panelBtn.add(btnAddTratamiento);

		btnMiSalud = new JButton("Mi Salud");
		btnMiSalud.setForeground(new Color(255, 255, 255));
		btnMiSalud.setBackground(new Color(9, 119, 33));
		panelBtn.add(btnMiSalud);

		btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.setForeground(new Color(255, 255, 255));
		btnCerrarSesion.setBackground(new Color(9, 119, 33));
		panelBtn.add(btnCerrarSesion);

		JPanel panelWelcome = new JPanel();
		panelWelcome.setBackground(new Color(144, 238, 144));
		add(panelWelcome, BorderLayout.CENTER);
		panelWelcome.setLayout(new BorderLayout(0, 0));

		JLabel lblWelcome = new JLabel("Bienvenido/a a iSalud, la APP para gestionar tu bienestar");
		lblWelcome.setBackground(new Color(144, 238, 144));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelWelcome.add(lblWelcome, BorderLayout.NORTH);

		JLabel lblImage = new JLabel("");
		lblImage.setBackground(new Color(144, 238, 144));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);

		ImageIcon originalIcon = new ImageIcon("sources\\imgPrincipal.jpg");
		ImageIcon iconoEscalado = new ImageIcon(
				originalIcon.getImage().getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH));
		lblImage.setIcon(iconoEscalado);

		panelWelcome.add(lblImage, BorderLayout.CENTER);

		addListeners();
	}

	private void addListeners() {
		WelcomeController controller = new WelcomeController(this, usuarioActual);
		controller.addListeners();
	}

	public JButton getBtnAddMedicamento() {
		return btnAddMedicamento;
	}

	public JButton getBtnAddTratamiento() {
		return btnAddTratamiento;
	}

	public JButton getBtnMiSalud() {
		return btnMiSalud;
	}

	public JButton getBtnCerrarSesion() {
		return btnCerrarSesion;
	}

	public Usuario getUsuarioActual() {
		return usuarioActual;
	}
}