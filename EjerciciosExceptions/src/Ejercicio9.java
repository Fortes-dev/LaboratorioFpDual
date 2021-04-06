
public class Ejercicio9 {
	public static void main (String []args) {
		/* En este ejercicio creamos un array que tiene como valor 4 en el indice 3, entonces creamos un loop
		 * con un while. Este loop continua hasta que i (el indice) sea 3, entonces nuestro if coincide en que ese indice en nuestro
		 * array vale 4. Siempre que entramos en el try, el valor de i decrece 1. Y hasta que no se cumpla que i==3, entramos en el catch
		 * y nos da la excepcion.
		 */
		int [] x = {1,2,3,4};
		int i = 8;
		
		while (i!=3) {
			try {
				i--;
				if (x[i]==4) {
					System.out.println("Hemos hecho bien el catch");
				}
				
			} catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
				System.out.println("Ha entrado en el catch");
				
			} finally {
				System.out.println("Entramos en el finally, pero aún no hemos salido del loop");
			}
		}
		
		System.out.println("Ya hemos salido del loop");
	}
}
