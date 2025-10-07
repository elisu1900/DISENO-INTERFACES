package models;

public class Product {

	private String nombre;
	private double precio;
	private boolean perecedero;

	public Product(String nombre, double precio, boolean perecedero) {
		this.nombre = nombre;
		this.precio = precio;
		this.perecedero = perecedero;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public boolean isPerecedero() {
		return perecedero;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setPerecedero(boolean perecedero) {
		this.perecedero = perecedero;
	}

	@Override
	public String toString() {
		return nombre + "\t" + precio + "\t" + (perecedero ? "perecedero" : "no perecedero");
	}

}
