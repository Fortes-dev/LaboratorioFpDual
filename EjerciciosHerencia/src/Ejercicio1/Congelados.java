package Ejercicio1;

import java.util.Date;

public class Congelados extends Producto {

	private int temperaturaCongelacion;
		
	public Congelados(Date fechaDeCaducidad, int numeroLote, int temperaturaCongelacion) {
		super(fechaDeCaducidad, numeroLote);
		this.temperaturaCongelacion = temperaturaCongelacion;
	}


	public int getTemperaturaCongelacion() {
		return temperaturaCongelacion;
	}

	public void setTemperaturaCongelacion(int temperaturaCongelacion) {
		this.temperaturaCongelacion = temperaturaCongelacion;
	}

}
