
public class Ejercicio7 {
	public static void main(String[] args) {
	
		try {
			metodoEjercicio7(2);
		} catch (Ejercicio7.BrokenAFException | Ejercicio7.BrutalErrorException | Ejercicio7.ExceptionKO e) {
			e.printStackTrace();
		}
	}
		
	

	public static void metodoEjercicio7(int x) throws Ejercicio7.BrokenAFException, Ejercicio7.BrutalErrorException, Ejercicio7.ExceptionKO  {
		if (x>4) {
			throw new Ejercicio7.BrokenAFException("BrokenAF");
		} 
		if (x<4) {
			throw new Ejercicio7.BrutalErrorException("Brutal"); 
			
		}
		if (x==4) {
			throw new Ejercicio7.ExceptionKO("KO");
		}
	}

	public static class BrokenAFException extends Exception {

		private String msg = "Petada con BrokenAFException";

		public BrokenAFException(String msg) {
			super(msg);
		}

		public String mensajeError() {
			return getMensaje();
		}

		public String getMensaje() {
			return this.msg;
		}
	}

	public static class ExceptionKO extends Exception {

		private String msg = "Petada con ExceptionKO";

		public ExceptionKO(String msg) {
			super(msg);
		}

		public String mensajeError() {
			return getMensaje();
		}

		public String getMensaje() {
			return this.msg;
		}
	}

	public static class BrutalErrorException extends Exception {

		private String msg = "Petada con BrutalErrorException";

		public BrutalErrorException(String msg) {
			super(msg);
		}

		public String mensajeError() {
			return getMensaje();
		}

		public String getMensaje() {
			return this.msg;
		}
	}
}

