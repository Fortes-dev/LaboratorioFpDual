package Lógica;

import java.util.Scanner;

public class EjerciciosLogica {
	
	public void Ejercicio1() {
		

		System.out.println("Hola Carlos");
	}
	
	public void Ejercicio2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca su nombre");
		String nombre = sc.nextLine();
		for (int i = 0; i < nombre.length(); i++) {
			if (nombre.charAt(i) >= 0 || nombre.charAt(i) <= 9) {
				System.out.println("Hola " + nombre);
			}
		}
	}
	
	public void Ejercicio3() {
		
	}
	
	public void Ejercicio4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca la palabra");
		String frase = sc.nextLine();
		String fraseNueva = null;
		
		for (int i = 0; i < frase.length(); i++) {
			if (frase.charAt(i) >= 0 || frase.charAt(i) <= 9) {
				
				 fraseNueva = fraseNueva + frase.charAt(i);
			} 
		}
		System.out.println(fraseNueva);
	}
	
	public void Ejercicio5() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el parámetro");
		String frase=sc.nextLine();
	
		if (frase.length() - 1 % 2 == 0) {
			System.out.println(frase + ": Parámetro par");

		} else {
			System.out.println(frase + ": Parámetro impar");
		}
	}
	
	public void Ejercicio6() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca valor de la a: ");
		int a=sc.nextInt();
		
		System.out.println("Introduzca valor de la b: ");
		int b=sc.nextInt();
		
		System.out.println("Introduzca valor de la c: ");
		int c=sc.nextInt();

		if(a==b && b==c && a==c) {
			System.out.println("Es un triángulo equilátero.");
		}if(a==b && b!=c && a!=c) {
			System.out.println("Es un triángulo isósceles.");
		}if(a!=b && b!=c && a!=c) {
			System.out.println("Es un triángulo escaleno.");
		}
	}
	public void Ejercicio7() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un texto: ");
		String texto = sc.nextLine();
		texto.toLowerCase();
		int contador = 0;
		
		for (int i = 0; i<texto.length();i++) {
			if (texto.charAt(i)=='a' || texto.charAt(i)=='e' || texto.charAt(i)=='i' || texto.charAt(i)=='o' || texto.charAt(i)=='u') {
				contador++;
			}
		}
		System.out.println("El numero de vocales de la frase es: "+contador);
	}
	
	public int Ejercicio8(int n) {
		if (n>21) {
			return n-21;
		} else {
			return (21-n)*2;
		}
	}
	
	public boolean Ejercicio9(boolean diaDeSemana, boolean vacaciones) {
		if (!diaDeSemana && vacaciones) {
			return true;
		} else {
			return false;
		}
	}
	public boolean Ejercicio10(int n) {
		if ((100 - n) <= 10) {
			return true;
		}
		if ((200 - n) <= 10) {
			return true;
		}
		return false;
	}
	public String Ejercicio11(String frase) {
		return frase.charAt(frase.length()-1)+frase+frase.charAt(frase.length()-1);
	}
	
	public boolean Ejercicio12(String frase) {
		for (int i = 7; i<frase.length();i++)
			if (frase.contains("programa")) {
				return true;
		}
		return false;
	}
	public boolean Ejercicio13(int a, int b, int c) {
		if (a>=13||a<=19||b>=13||b<=19||c>=13||c<=19) {
			return true;
		}
		return false;
	}
	public boolean Ejercicio14(String frase) {
		int principio = 0;
		int fin = frase.length()-1;
		
		while ((principio<fin)) {
			if (frase.charAt(principio)==frase.charAt(fin)) {
				principio++;
				fin--;
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static void Ejercicio15() {//recibe array de strings, recorres array y confirma si hay digitos.
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un parámetro: ");
		String a = sc.nextLine();
		System.out.println("Introduce un segundo parámetro: ");
		String b = sc.nextLine();
		System.out.println("Introduce un tercer parámetro: ");
		String c = sc.nextLine();
		
		String cadena = a+b+c;
		
		
			if (cadena.matches("^[1-9]\\d*$")) {
				int resultado = Integer.parseInt(a) + Integer.parseInt(b) + Integer.parseInt(c);

				System.out.println("La suma de todos los parámetros es: " + resultado);
			} 
			
		}
	
	
	public void Ejercicio16() {
		System.out.println("    ");   
		System.out.println("         *"+"             +"+"              x"+"             o"+"              º"+"             I"+"              @"+"             v");
		System.out.println("        ***"+"           +++"+"            xxx"+"           ooo"+"            ººº"+"           III"+"            @@@"+"           vvv");
		System.out.println("       *****"+"         +++++"+"          xxxxx"+"         ooooo"+"          ººººº"+"         IIIII"+"          @@@@@"+"         vvvvv");
		System.out.println("      *******"+"       +++++++"+"        xxxxxxx"+"       ooooooo"+"        ººººººº"+"       IIIIIII"+"        @@@@@@@"+"       vvvvvvv");
		System.out.println("     *********"+"     +++++++++"+"      xxxxxxxxx"+"     ooooooooo"+"      ººººººººº"+"     IIIIIIIII"+"      @@@@@@@@@"+"     >>>>><<<<");
		System.out.println("      *******"+"       +++++++"+"        xxxxxxx"+"       ooooooo"+"        ººººººº"+"       IIIIIII"+"        @@@@@@@"+"       ^^^^^^^");
		System.out.println("       *****"+"         +++++"+"          xxxxx"+"         ooooo"+"          ººººº"+"         IIIII"+"          @@@@@"+"         ^^^^^");
		System.out.println("        ***"+"           +++"+"            xxx"+"           ooo"+"            ººº"+"           III"+"            @@@"+"           ^^^");
		System.out.println("         *"+"             +"+"              x"+"             o"+"              º"+"             I"+"              @"+"             ^");
	}
	
	public static void main (String[]args) {
		//solo las clases empiezan en mayusculas, todo lo demas miniscula
		Ejercicio15();
	}
	
}

