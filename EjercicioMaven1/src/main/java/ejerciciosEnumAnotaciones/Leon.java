package ejerciciosEnumAnotaciones;

import lombok.Getter;
import lombok.Setter;

@AnimalMetadata(dia = "16/11/2020", pais = "Congo")
@Risk(riesgo = "8", tiporiesgo = "Riesgo por ataque alto")
public class Leon extends Zoo {
	
	public Leon(double tama�o, String nombre, int jaula) {
		super(tama�o, nombre, jaula);
	}

	
}
