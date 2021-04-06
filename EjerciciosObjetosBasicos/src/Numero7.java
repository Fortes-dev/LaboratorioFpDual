import java.util.Scanner;

public class Numero7 {
	private String etiqueta;
	private String palabra;
	
	public Numero7(String etiqueta, String palabra) {
		this.etiqueta = etiqueta;
		this.palabra = palabra;
	}
	
	public void htmlImprimir() {
		Scanner sc = new Scanner (System.in);
		System.out.println("Escriba su palabra:");
		setPalabra(sc.nextLine());
		System.out.println("Escriba la etiqueta HTML");
		setEtiqueta(sc.nextLine());
		
		System.out.println("<"+etiqueta+">"+palabra+"</"+etiqueta+">");
		sc.close();
	}
	
	
	public String getEtiqueta() {
		return etiqueta;
	}
	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	public String getPalabra() {
		return palabra;
	}
	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	public static void main(String[] args) {
		
		String palabra = null;
		String etiqueta = null;
		
		Numero7 hola = new Numero7(palabra, etiqueta);
		
		hola.htmlImprimir();
	}
	
}
