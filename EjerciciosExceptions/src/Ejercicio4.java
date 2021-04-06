
public class Ejercicio4 {
	public static void main (String[]args) {
		
		//Sin try,catch y sin meterle una excepcion peta y abre el debugger
		//(a parte da NullPointerException y dice que no esta catcheada
		
		//Con un try,catch obviamente el programa se ejecuta, el catch atrapa la excepcion y nos dice gracias al .printStackTrace():
		//Cannot invoke "java.lang.Double.doubleValue()" because "n" is null
		
		try {
		Double n = null;
		Double x = 3.8;
		multiplicar(n,x);
		} catch(NullPointerException e) {
			e.printStackTrace();
			System.out.println("Uno de los parámetros no existe");
		} finally {
			System.out.println("El programa se ha ejecutado");
		}
		
		
	}
	public static Double multiplicar(Double n, Double x) {
		return (n*x);
	}
}
