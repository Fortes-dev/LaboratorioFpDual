package ejerciciosEnumAnotaciones;


import lombok.Getter;
import lombok.Setter;

@AnimalMetadata(dia = "13/1/2021", pais = "Sri Lanka")
@Risk(riesgo = "5", tiporiesgo = "Bajo")
public class Elefante extends Zoo{
	
	public Elefante(double tamaño, String nombre, int jaula) {
		super(tamaño, nombre, jaula);
	}

}
