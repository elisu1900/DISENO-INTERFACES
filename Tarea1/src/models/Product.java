package models;

public class Product {

	private String nombre;
	private Double precio;
	private boolean perecedero;

	public Product(int id, String nombre, Double precio, boolean perecedero) {
		this.nombre = nombre;
		this.precio = precio;
		this.perecedero = perecedero;
	}

	public String getNombre() {
		return nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public boolean isPerecedero() {
		return perecedero;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public void setPerecedero(boolean perecedero) {
		this.perecedero = perecedero;
	}

	@Override
	public String toString() {
		return "Products nombre=" + nombre + ", precio=" + precio + ", perecedero=" + perecedero + "]";
	}



}
