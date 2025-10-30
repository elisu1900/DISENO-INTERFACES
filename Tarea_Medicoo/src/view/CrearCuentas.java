package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import controller.UsuarioController;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CrearCuentas extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmar;

	private UsuarioController controlador;

	public static void main(String[] args) {
		try {
			CrearCuentas dialog = new CrearCuentas(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CrearCuentas(UsuarioController controlador) {
		this.controlador = controlador;

		getContentPane().setBackground(new Color(0, 128, 0));
		setBounds(100, 100, 500, 459);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 128, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 250, 205));
			panel.setForeground(new Color(0, 0, 0));
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 0;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 0, 0, 0 };
			gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
			gbl_panel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);

			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.gridx = 0;
			gbc_lblNombre.gridy = 0;
			panel.add(lblNombre, gbc_lblNombre);

			txtNombre = new JTextField();
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_txtNombre = new GridBagConstraints();
			gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
			gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtNombre.gridx = 1;
			gbc_txtNombre.gridy = 0;
			panel.add(txtNombre, gbc_txtNombre);
			txtNombre.setColumns(10);

			JLabel lblApelidos = new JLabel("Apellidos");
			lblApelidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_lblApelidos = new GridBagConstraints();
			gbc_lblApelidos.insets = new Insets(0, 0, 5, 5);
			gbc_lblApelidos.gridx = 0;
			gbc_lblApelidos.gridy = 1;
			panel.add(lblApelidos, gbc_lblApelidos);

			txtApellidos = new JTextField();
			txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_txtApellidos = new GridBagConstraints();
			gbc_txtApellidos.insets = new Insets(0, 0, 5, 0);
			gbc_txtApellidos.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtApellidos.gridx = 1;
			gbc_txtApellidos.gridy = 1;
			panel.add(txtApellidos, gbc_txtApellidos);
			txtApellidos.setColumns(10);

			JLabel lbllEmail = new JLabel("Email");
			lbllEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_lbllEmail = new GridBagConstraints();
			gbc_lbllEmail.insets = new Insets(0, 0, 5, 5);
			gbc_lbllEmail.gridx = 0;
			gbc_lbllEmail.gridy = 2;
			panel.add(lbllEmail, gbc_lbllEmail);

			txtEmail = new JTextField();
			txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_txtEmail = new GridBagConstraints();
			gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
			gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtEmail.gridx = 1;
			gbc_txtEmail.gridy = 2;
			panel.add(txtEmail, gbc_txtEmail);
			txtEmail.setColumns(10);

			JLabel lblPassword = new JLabel("Contraseña");
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_lblPassword = new GridBagConstraints();
			gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
			gbc_lblPassword.gridx = 0;
			gbc_lblPassword.gridy = 3;
			panel.add(lblPassword, gbc_lblPassword);

			txtPassword = new JPasswordField();
			txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_txtPassword = new GridBagConstraints();
			gbc_txtPassword.insets = new Insets(0, 0, 5, 0);
			gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtPassword.gridx = 1;
			gbc_txtPassword.gridy = 3;
			panel.add(txtPassword, gbc_txtPassword);
			txtPassword.setColumns(10);

			JLabel lblConfirmar = new JLabel("Confirmar contraseña");
			lblConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_lblConfirmar = new GridBagConstraints();
			gbc_lblConfirmar.insets = new Insets(0, 0, 0, 5);
			gbc_lblConfirmar.gridx = 0;
			gbc_lblConfirmar.gridy = 4;
			panel.add(lblConfirmar, gbc_lblConfirmar);

			txtConfirmar = new JPasswordField();
			txtConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_txtConfirmar = new GridBagConstraints();
			gbc_txtConfirmar.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtConfirmar.gridx = 1;
			gbc_txtConfirmar.gridy = 4;
			panel.add(txtConfirmar, gbc_txtConfirmar);
			txtConfirmar.setColumns(10);

			JLabel lblNewLabel = new JLabel("REGISTRO DE USUARIO");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBackground(new Color(0, 100, 0));
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
			getContentPane().add(lblNewLabel, BorderLayout.NORTH);

			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 100, 0));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					registrarUsuario();
				}
			});
			okButton.setActionCommand("OK");
			buttonPane.add(okButton);
			getRootPane().setDefaultButton(okButton);

			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
			buttonPane.add(cancelButton);
		}
	}

	/**
	 * metodo que registra a un usuario
	 */
	private void registrarUsuario() {
		String nombre = txtNombre.getText().trim();
		String apellidos = txtApellidos.getText().trim();
		String email = txtEmail.getText().trim();
		String pass = new String(txtPassword.getPassword());
		String confirmar = new String(txtConfirmar.getPassword());

		if (nombre.isEmpty() || apellidos.isEmpty() || email.isEmpty() || pass.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (!pass.equals(confirmar)) {
			JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		boolean registrado = controlador.registrarUsuario(nombre, apellidos, email, pass);

		if (registrado) {
			JOptionPane.showMessageDialog(null, "Cuenta creada correctamente", "Éxito",
					JOptionPane.INFORMATION_MESSAGE);
			dispose();
		} else {
			JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese email", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}