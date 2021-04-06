
public class Cliente {
	
	private String nombre;
	private String apellidos;
	private int idCliente;
	private int dni;
	private int edad;
	
	public Cliente(String nombre, String apellidos, int idCliente, int dni, int edad) {
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.idCliente=idCliente;
		this.dni=dni;
		this.edad=edad;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setApellidos(String apellidos) {
		this.apellidos=apellidos;
	}
	public String getApellidos() {
		return this.apellidos;
	}
	public void setDni (int dni) {
		this.dni=dni;
	}
	public int getDni() {
		return this.dni;
	}
	public void setidCliente (int idCliente) {
		this.idCliente=idCliente;
	}
	public int getidCliente() {
		return this.idCliente;
	}
	public void setEdad (int edad) {
		this.edad=edad;
	}
	public int getEdad() {
		return this.edad;
	}
	
	public void imprimirCliente() {
		System.out.println("Nombre: "+getNombre());
		System.out.println("Apellidos: "+getApellidos());
		System.out.println("Dni: "+getDni());
		System.out.println("idCliente: "+getidCliente());
		System.out.println("Edad: "+getEdad());
	}
	
}
