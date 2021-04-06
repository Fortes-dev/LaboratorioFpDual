
public class Empleado {
	private String nombre;
	private String cedula;
	private int edad;
	private boolean casado;
	private double salario;
	
	public Empleado(String nombre, String cedula, int edad, boolean casado, double salario) {
		
		this.nombre = nombre;
		this.cedula = cedula;
		this.edad = edad;
		this.casado = casado;
		this.salario = salario;
	}
	
	Empleado() {
		
	}
	
	public String clasificadorEdad() {
		
		if (edad<=21) {
			return "Principiante";
		} else if  (edad>=22 && edad<=35) {
			return "Intermedio";
		} else {
		return "Senior";
		}
	}
	
	public void ImprimirDatos() {
		System.out.println(getNombre()+"\n");
		System.out.println(getCedula()+"\n");
		System.out.println(getEdad()+"\n");
		if (isCasado()) {
			System.out.println("Casado\n");
		} else if (!isCasado()) {
			System.out.println("Soltero\n");
		}
		System.out.println(getSalario()+"\n");
	}
	
	public double aumentarSalario(double porcentaje) {
		double aumento;
		double total;
		aumento = (porcentaje * salario)/100;
		total = salario + aumento;
		
		return total;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		if (edad < 18 || edad > 45) {
	        throw new IllegalArgumentException(edad + " La edad debe de compreder entre 18 y 45 años");
	    }
		this.edad = edad;
	}
	

	public boolean isCasado() {
		return casado;
	}

	public void setCasado(boolean casado) {
		this.casado = casado;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
}
