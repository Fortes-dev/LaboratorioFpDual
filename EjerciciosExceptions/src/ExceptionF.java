
public class ExceptionF extends Exception {
	private String msg = "Pum petao F";
	
	public ExceptionF(String msg) {
		super(msg);
	}
	public String mensajeError() {
		return getMensaje();
	}
	
	public String getMensaje() {
		return this.msg;
	}
}
