public class Ejercicio6 {

	public static void main (String[]args) throws ExceptionF {
		f();
	}
	
	public static void f() throws ExceptionF {
		try {
			try {
				g();
			} catch (ExceptionG e) {
				e.mensajeError();
				throw new ExceptionF("Excepci�n de F"); // Lo que ocurre en el programa es que no catchea esta
														// excepci�n.
			}
		} catch (RuntimeException ex) {
			ex.printStackTrace();
		}
	}
	public static void g() throws ExceptionG{
		throw new ExceptionG("Excepci�n de G");
	}
}