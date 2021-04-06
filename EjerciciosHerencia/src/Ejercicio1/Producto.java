package Ejercicio1;

import java.util.Date;

public class Producto {
	private Date fechaDeCaducidad;
	private int numeroLote;
	
	public Producto(Date fechaDeCaducidad, int numeroLote) {
		this.fechaDeCaducidad = fechaDeCaducidad;
		this.numeroLote = numeroLote;
	}

	public Date getFechaDeCaducidad() {
		return fechaDeCaducidad;
	}

	public void setFechaDeCaducidad(Date fechaDeCaducidad) {
		this.fechaDeCaducidad = fechaDeCaducidad;
	}

	public int getNumeroLote() {
		return numeroLote;
	}

	public void setNumeroLote(int numeroLote) {
		this.numeroLote = numeroLote;
	}
	
	
	
	
}
