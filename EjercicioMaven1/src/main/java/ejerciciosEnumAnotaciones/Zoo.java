package ejerciciosEnumAnotaciones;

import java.util.ArrayList;

import EjemplosAnotaciones.Creacion;

import java.lang.annotation.Annotation;

import lombok.Getter;
import lombok.Setter;

public class Zoo {

	protected double tamaño;
	protected String nombre;
	protected int jaula;


	public Zoo(double tamaño, String nombre, int jaula) {
		this.tamaño = tamaño;
		this.nombre = nombre;
		this.jaula = jaula;
	}

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException {

		ArrayList<Zoo> animales = new ArrayList<Zoo>();


		Zoo leon1 = new Leon(3.48, "Pepe", 1);
		animales.add(leon1);


		Zoo leon2 = new Leon(4.11, "Simba", 2);
		animales.add(leon2);


		Zoo elefante1 = new Elefante(9.11, "Dumbo", 3);
		animales.add(elefante1);

		Zoo elefante2 = new Elefante(7.90, "Aladin", 4);
		animales.add(elefante2);

		AnimalMetadata leon = Leon.class.getAnnotation(AnimalMetadata.class);
		Risk riesgoleon = Leon.class.getAnnotation(Risk.class);
		AnimalMetadata elefante = Leon.class.getAnnotation(AnimalMetadata.class);
		Risk riesgoelefante = Elefante.class.getAnnotation(Risk.class);

		for (Zoo animal : animales) {
			System.out.println(animal.nombre + " " + animal.tamaño + " " + animal.jaula);
			System.out.println(leon.dia() + " " + leon.pais());
			System.out.println("Tipo de riesgo:"+riesgoleon.tiporiesgo() + " nivel de riesgo:" + riesgoleon.riesgo());
		}

	}
}
