package ejerciciosEnumAnotaciones;


import lombok.Getter;
import lombok.Setter;

@AnimalMetadata(dia = "13/1/2021", pais = "Sri Lanka")
@Risk(riesgo = "5", tiporiesgo = "Bajo")
public class Elefante extends Zoo{
	
	public Elefante(double tama�o, String nombre, int jaula) {
		super(tama�o, nombre, jaula);
	}

}
