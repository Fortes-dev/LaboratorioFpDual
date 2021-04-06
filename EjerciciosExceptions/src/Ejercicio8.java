
public class Ejercicio8 {

	public static void main(String[] args) {
		int listaInt [] = new int [4];
		
		try {
			int i = listaInt[6];
			System.out.println("El indice es accesible");
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("El índice del array al que quieres acceder no existe");
		} finally {
			System.out.println("El programa acaba");
		}

	}

}
