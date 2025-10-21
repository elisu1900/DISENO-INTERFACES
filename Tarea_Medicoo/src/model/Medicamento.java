package model;

public class Medicamento {

	private String nombre;
	private String laboratorio;
	private String descripcion;
	private TipoMedicamento tipo;

	public Medicamento(String nombre, String laboratorio, TipoMedicamento tipo, String descripcion) {
		super();
		this.nombre = nombre;
		this.laboratorio = laboratorio;
		this.tipo = tipo;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public TipoMedicamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoMedicamento tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
