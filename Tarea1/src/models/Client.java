package models;

public class Client {

	private String nombre;
	private String apellidos;
	private int edad;
	private String provincia;
	public Client(String nombre, String apellidos, int edad, String provincia) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.provincia = provincia;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public int getEdad() {
		return edad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	@Override
	public String toString() {
		return   nombre + " \t " + apellidos + "\t " + edad + "\t " + provincia;
	}
	
	
}
