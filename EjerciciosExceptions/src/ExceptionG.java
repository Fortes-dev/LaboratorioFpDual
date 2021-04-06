
public class ExceptionG extends Exception {
	private String msg = "Pum petao G";
	
	public ExceptionG(String msg) {
		super(msg);
	}
	public String mensajeError() {
		return getMensaje();
	}
	
	public String getMensaje() {
		return this.msg;
	}
}
