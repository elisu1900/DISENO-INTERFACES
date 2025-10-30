package controller;

import model.Usuario;

import view.MainView;
import view.panelUser;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class UsuarioController {

	private List<Usuario> usuarios;

	private Usuario usuarioLogueado;

	public UsuarioController() {
		usuarios = new ArrayList<>();

		Usuario usuarioPrueba = new Usuario("Usuario", "Prueba", "usuario", "usuario", new ArrayList<>());
		usuarios.add(usuarioPrueba);
	}

	public boolean registrarUsuario(String nombre, String apellidos, String email, String pass) {

		for (Usuario usuario : usuarios) {
			if (usuario.getEmail().equals(email)) {
				return false;
			}
		}
		Usuario nuevoUsuario = new Usuario(nombre, apellidos, email, pass, new ArrayList<>());
		usuarios.add(nuevoUsuario);
		return true;
	}

	public boolean iniciarSesion(String email, String pass) {

		for (Usuario usuario : usuarios) {
			if (usuario.getEmail().equals(email) && usuario.getPass().equals(pass)) {
				usuarioLogueado = usuario;
				return true;
			}
		}

		return false;
	}

	public Usuario getUsuarioLogueado() {
		return usuarioLogueado;
	}

	public void cerrarSesion() {
		usuarioLogueado = null;
	}

	public void addListeners() {
		MainView.btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = MainView.txtEmail.getText();
				String password = new String(MainView.txtPassword.getPassword());

				if (email.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Introduce email y contraseña", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				boolean loginCorrecto = iniciarSesion(email, password);

				if (loginCorrecto) {
					Usuario usuario = getUsuarioLogueado();
					JOptionPane.showMessageDialog(null, "¡Bienvenido " + usuario.getNombre() + "!", "Login correcto",
							JOptionPane.INFORMATION_MESSAGE);

					MainView.txtEmail.setText("");
					MainView.txtPassword.setText("");

					MainView.contentPane.remove(MainView.mainPanel);
					panelUser welcomePanel = new panelUser();
					MainView.contentPane.add(welcomePanel, BorderLayout.CENTER);
					MainView.contentPane.revalidate();
					MainView.contentPane.repaint();
				} else {
					JOptionPane.showMessageDialog(null, "Email o contraseña incorrectos", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}

}
