
public class Numero6 {//hago la clase de un producto.
	private String nombre;
	private String marca;
	private double precio;
	private int cantidad;
	
	
	
	public Numero6(String nombre, String marca, double precio, int cantidad) {
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	
	@Override
	public String toString() {
		return "nombre=" + nombre + ", marca=" + marca + ", precio=" + precio + ", cantidad=" + cantidad;
	}



	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
