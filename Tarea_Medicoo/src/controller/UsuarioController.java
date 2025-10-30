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

/*
 * case que controla usuarios
 */
public class UsuarioController {

	private List<Usuario> usuarios;
	private Usuario usuarioActual;

	/**
	 * constructor del controller de usuario
	 */
	public UsuarioController() {

		usuarios = new ArrayList<>();
		Usuario usuarioPrueba = new Usuario("Usuario", "Usuario", "usuario", "usuario", new ArrayList<>());
		usuarios.add(usuarioPrueba);
	}

	/**
	 * registro de un nuevo usuario
	 * 
	 * @param nombre
	 * @param apellidos
	 * @param email
	 * @param pass
	 * @return
	 */
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

	/**
	 * metodo que comprueba que el email es valido y si la contraseña es correcta
	 * 
	 * @param email
	 * @param pass
	 * @return
	 */
	public boolean iniciarSesion(String email, String pass) {
		for (Usuario usuario : usuarios) {
			if (usuario.getEmail().equals(email) && usuario.getPass().equals(pass)) {
				usuarioActual = usuario;
				return true;
			}
		}
		return false;
	}

	/**
	 * @return usuarioActual
	 */
	public Usuario getUsuarioLogueado() {
		return usuarioActual;
	}

	/**
	 * cierra la sesion actual
	 */
	public void cerrarSesion() {
		usuarioActual = null;
	}

	/**
	 * añade eventos a los botones
	 */
	public void addListeners() {
		MainView.btnIniciarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String email = MainView.txtEmail.getText();
				String password = new String(MainView.txtPassword.getPassword());

				if (email.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(null, "completa todos los campos.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				boolean loginExitoso = iniciarSesion(email, password);

				if (loginExitoso) {

					panelUser panel = new panelUser(usuarioActual);
					MainView.mainPanel.removeAll();
					MainView.mainPanel.setLayout(new BorderLayout());
					MainView.mainPanel.add(panel, BorderLayout.CENTER);
					MainView.mainPanel.revalidate();
					MainView.mainPanel.repaint();
				} else {
					JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
