package model;

import java.util.List;

public class Usuario {

	private String nombre;
	private String apellidos;
	private String email;
	private String pass;
	private List<Tratamiento> misTratamientos;

	public Usuario(String nombre, String apellidos, String email, String pass, List<Tratamiento> misTratamientos) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.pass = pass;
		this.misTratamientos = misTratamientos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<Tratamiento> getMisTratamientos() {
		return misTratamientos;
	}

	public void setMisTratamientos(List<Tratamiento> misTratamientos) {
		this.misTratamientos = misTratamientos;
	}

}
