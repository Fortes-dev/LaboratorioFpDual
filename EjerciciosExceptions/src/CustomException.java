
public class CustomException extends Exception {
	private String mensaje="Te ha petao el programa muchacho";
	
	public CustomException (String mensaje) {
		super(mensaje);
	}
	public String mensajeError() {
		return getMensaje();
	}
	
	public String getMensaje() {
		return this.mensaje;
	}
}

