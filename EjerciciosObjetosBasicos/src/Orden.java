import java.text.SimpleDateFormat;
import java.util.Date;

public class Orden {
	private String nombreProducto;
	private Cliente idCliente;
	private Empleado nombreEmpleado;
	private double precio;
	private String direccion;
	private Date fechaOrden;

	public Orden (String nombreProducto, Cliente idCliente, Empleado nombreEmpleado, double precio, String direccion) {
		this.nombreProducto=nombreProducto;
		this.idCliente=idCliente;
		this.nombreEmpleado=nombreEmpleado;
		this.precio=precio;
		this.direccion=direccion;
		this.fechaOrden=new Date();
		
	}
	










	public void imprimirFechaOrden() {
		System.out.println("La orden se realizó el: "+new SimpleDateFormat("yyyy-MM-dd").format(fechaOrden));
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	public Empleado getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(Empleado nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
