package model;

import java.util.Date;

public class Tratamiento {

	Medicamento medicamento;
	Date fechaInicio;
	Date fechaFin;
	int comprimidos;
	int horas;

	public Tratamiento(Medicamento medicamento, Date fechaInicio, Date fechaFin, int comprimidos, int horas) {
		super();
		this.medicamento = medicamento;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.comprimidos = comprimidos;
		this.horas = horas;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getComprimidos() {
		return comprimidos;
	}

	public void setComprimidos(int comprimidos) {
		this.comprimidos = comprimidos;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

}
