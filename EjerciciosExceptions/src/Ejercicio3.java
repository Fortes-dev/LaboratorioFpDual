
public class Ejercicio3 {
public static void main (String []args) throws CustomException {
	
	//Si no se declara la excepción no deja ejecutar.
	//Sin try, catch no me esta dejando ejecutar tampoco.
	try {
	System.out.println(sumar(6,8));
	} catch(CustomException e) {
		e.mensajeError();
		e.printStackTrace();
	} 
				
}
	
	public static int sumar(int a, int b) throws CustomException {
		if ((a+b)>10) {
			throw new CustomException("La suma supera 10");
		} else {
			return (a+b);
		}
	}
}
