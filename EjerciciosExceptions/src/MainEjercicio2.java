
public class MainEjercicio2 {
	public static void main(String[] args) {

		try {
			validarEdad(13);
		} catch (CustomException e) {
			System.out.println("Ha ocurrido una excepción " + e.mensajeError());
			e.printStackTrace();
		} finally {

		System.out.println("Esto se ejecuta siempre da igual que pete");
		}
	}

	public static void validarEdad(int age) throws CustomException {
		if (age < 18) {
			throw new CustomException("La edad no es válidad para votar.");
		} else {
			System.out.println("Eres mayor de edad, felicidades.");
		}
	}
}
