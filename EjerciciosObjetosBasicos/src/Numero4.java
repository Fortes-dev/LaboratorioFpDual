import java.util.Scanner;

public class Numero4 {
	private String palabra;
	
	public Numero4 (String palabra) {
		this.palabra=palabra;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	
	
	public void holaMundo(String palabra) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Escriba su palabra:");
		setPalabra(sc.nextLine());
		System.out.println("Hola"+palabra);
		sc.close();
	}
}
