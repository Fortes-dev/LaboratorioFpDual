package ejerciciosEnumAnotaciones;



public class ViaLacteaMain {


	public static void main(String[] args) {

		System.out.println("Planetas dentro del anillo de asteroides: ");
		/*Nos lista los planetas dentro del anillo interior, usando 
		* el metodo isInsideAnAseroid() de la clase ViaLactea
		*/
		for (ViaLactea planeta : ViaLactea.values()) {

			if (planeta.isInsideAnAsteroid(planeta) != null)
				System.out.println(planeta);
		}
		/*Nos lista los planetas con atmosfera, usando 
		* el metodo hasAnAtmosphere() de la clase ViaLactea
		*/
		System.out.println("=======================");
		System.out.println("Planetas con atmósfera: ");
		for (ViaLactea planeta : ViaLactea.values()) {
			if (planeta.hasAnAtmosphere(planeta) != null)
				System.out.println(planeta);
		}
		/*Nos lista el planeta más cercano al sol, usando 
		* el metodo distanceFromSun() de la clase ViaLactea
		*/
		System.out.println("=======================");
		System.out.println("Planeta más cercano al sol: ");
		for (ViaLactea planeta : ViaLactea.values()) {
			if (planeta.distanceFromSun(planeta) != null)
				System.out.println(planeta);
		}
		/*Nos lista los planetas similares en condiciones a la tierra
		 *comparandolos por atmosfera y si están dentro del anillo de 
		 *asteroides.
		*/
		System.out.println("=======================");
		System.out.println("Planetas con condiciones similares a la tierra: ");
		for (ViaLactea planeta : ViaLactea.values()) {
			if (planeta.getAsteroidRing().matches(planeta.TIERRA.getAsteroidRing())
					&& planeta.getAtmosphere().matches(planeta.TIERRA.getAtmosphere()))
				System.out.println(planeta);
		}
	}
}
