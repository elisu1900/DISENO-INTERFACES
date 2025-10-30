package controller;

import model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioController {

	private List<Usuario> usuarios;

	private Usuario usuarioLogueado;

	public UsuarioController() {
		usuarios = new ArrayList<>();

		Usuario usuarioPrueba = new Usuario("Usuario", "Prueba", "usuario", "usuario", new ArrayList<>());
		usuarios.add(usuarioPrueba);
	}

	public boolean registrarUsuario(String nombre, String apellidos, String email, String pass) {

		for (Usuario u : usuarios) {
			if (u.getEmail().equals(email)) {
				return false;
			}
		}
		Usuario nuevoUsuario = new Usuario(nombre, apellidos, email, pass, new ArrayList<>());
		usuarios.add(nuevoUsuario);
		return true;
	}

	public boolean iniciarSesion(String email, String pass) {

		for (Usuario u : usuarios) {
			if (u.getEmail().equals(email) && u.getPass().equals(pass)) {
				usuarioLogueado = u;
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
}