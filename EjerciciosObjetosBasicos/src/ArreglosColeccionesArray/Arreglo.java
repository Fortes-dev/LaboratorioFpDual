package ArreglosColeccionesArray;

import java.util.ArrayList;
import java.util.Arrays;


public class Arreglo {
	
	private ArrayList <Integer>numeros;
	private ArrayList <String>cadenas;
	
	public static void main(String[] args) {
		ArrayList <Integer> numeros = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		ArrayList <String> cadena = new ArrayList<>(Arrays.asList("Pepe", "123", "Antonio", "32"));
		System.out.println("\n==== 1 ====");
		System.out.println(metodo1(numeros));
		System.out.println("\n==== 2 ====");
		System.out.println(metodo2(numeros));
		System.out.println("\n==== 3 ====");
		System.out.println(metodo3(numeros));
		System.out.println("\n==== 4 ====");
		System.out.println(metodo4(numeros));
		System.out.println("\n==== 5 ====");
		System.out.println(metodo5(cadena));
	}


	public Arreglo(ArrayList<Integer> numeros, ArrayList <String>cadenas) {
		this.numeros=numeros;
		this.cadenas=cadenas;
	}
	
	public ArrayList <String> getCadenas() {
		return cadenas;
	}


	public void setCadenas(ArrayList <String> cadenas) {
		this.cadenas = cadenas;
	}

	

	public ArrayList<Integer> getNumeros() {
		return numeros;
	}

	public void setNumeros(ArrayList<Integer> numeros) {
		this.numeros = numeros;
	}
	
	public static boolean metodo1(ArrayList<Integer> numeros) {
		
		if (numeros.get(0)==6 || numeros.get(numeros.size()-1)==6) {
			return true;
		} else
		
		return false;
	}
	
	public static boolean metodo2(ArrayList<Integer> numeros) {
	
			if (numeros.contains(2) || numeros.contains(3)) {
			return false;
			} else
	
		return true;
	}
	
	public static ArrayList<Integer> metodo3 (ArrayList<Integer>numeros) {
		int posicionCentral;
		posicionCentral = numeros.size()/2;
		ArrayList<Integer> numeros2 = new ArrayList<Integer>();
		
		if (numeros.size()%2==0) {
			numeros2.add(numeros.get(posicionCentral-1));
			numeros2.add(numeros.get(posicionCentral));
			
		} else {
			System.out.println("El array es impar");
		}
		
		return numeros2;
	}
	public static ArrayList<Integer> metodo4 (ArrayList<Integer>numeros) {
	
		int number = numeros.get(0);
		
		numeros.set(0, numeros.get(numeros.size()-1));
		numeros.set(numeros.size()-1, number);
		
		return numeros;
	}
	
	public static ArrayList<String> metodo5 (ArrayList<String>cadenas) {
		String regex = "[0-9]+";
		ArrayList<String>cadenas2 = new ArrayList<String>();
		for (int i = 0; i<cadenas.size(); i++) {
			if (cadenas.get(i).matches(regex)) {
				cadenas2.add(cadenas.get(i));
		} 
			
		
		}
		return cadenas2;
	
	}
}
