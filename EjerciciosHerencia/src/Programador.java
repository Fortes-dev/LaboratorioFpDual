
public class Programador extends Empleado {
	private int lineasDeCodigoPorHora;
	private String lenguajeDominante;

	
	public Programador(String nombre, String cedula, int edad, boolean casado, double salario,
			int lineasDeCodigoPorHora, String lenguajeDominante) {
		super(nombre, cedula, edad, casado, salario);
		this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
		this.lenguajeDominante = lenguajeDominante;
	}

	public String getLenguajeDominante() {
		return lenguajeDominante;
	}

	public int getLineasDeCodigoPorHora() {
		return lineasDeCodigoPorHora;
	}

	public void setLineasDeCodigoPorHora(int lineasDeCodigoPorHora) {
		this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
	}

	public void setLenguajeDominante(String lenguajeDominante) {
		this.lenguajeDominante = lenguajeDominante;
	}
	
	@Override
	public String clasificadorEdad() {
		return super.clasificadorEdad();
	}


	@Override
	public void ImprimirDatos() {
		super.ImprimirDatos();
	}


	@Override
	public double aumentarSalario(double porcentaje) {
		return super.aumentarSalario(porcentaje);
	}


	@Override
	public String getNombre() {
		return super.getNombre();
	}


	@Override
	public void setNombre(String nombre) {
		super.setNombre(nombre);
	}


	@Override
	public String getCedula() {
		return super.getCedula();
	}


	@Override
	public void setCedula(String cedula) {
		super.setCedula(cedula);
	}


	@Override
	public int getEdad() {
		return super.getEdad();
	}


	@Override
	public void setEdad(int edad) {
		super.setEdad(edad);
	}


	@Override
	public boolean isCasado() {
		return super.isCasado();
	}


	@Override
	public void setCasado(boolean casado) {
		super.setCasado(casado);
	}


	@Override
	public double getSalario() {
		return super.getSalario();
	}


	@Override
	public void setSalario(double salario) {
		super.setSalario(salario);
	}
	
}
