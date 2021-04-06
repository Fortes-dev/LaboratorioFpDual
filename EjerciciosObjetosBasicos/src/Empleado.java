import java.util.Scanner;

public class Empleado {
	
	private String nombre;
	private String apellidos;
	private double sueldo;
	
	
	public Empleado(String nombre, String apellidos, double sueldo) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sueldo = sueldo;
	}


	public void subidaSueldo(double sueldo, double aumento) {
		this.setSueldo(sueldo+aumento);
	}
	public void set_empleado() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Nombre: ");
		this.setNombre(entrada.nextLine());
		System.out.println("Apellidos: ");
		this.setApellidos(entrada.nextLine());
		System.out.println("Sueldo: ");
		this.setSueldo(entrada.nextDouble());
		entrada.close();
	}
	public void despido() {
		this.setNombre(null);
		this.setApellidos(null);
		this.setSueldo(0.0);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
}
