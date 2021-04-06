import java.util.Scanner;

public class Numero5 {
	private String palabra;
	private int numero;

	public Numero5(String palabra, int numero) {
		this.palabra = palabra;
		this.numero = numero;
	}
	

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void ImprimirMucho() {
		Scanner sc = new Scanner (System.in);
		System.out.println("Escriba su palabra:");
		setPalabra(sc.nextLine());
		System.out.println("Escriba el numero");
		setNumero(sc.nextInt());
		sc.close();
	    while (numero > 0) {
	        System.out.println(getPalabra());
	        numero--;
	    }  

	}
	
	public static void main(String[] args) {
		
		String palabra = null;
		int numero = 0;
		
		Numero5 hola = new Numero5(palabra, numero);
		
		hola.ImprimirMucho();
	}
}
