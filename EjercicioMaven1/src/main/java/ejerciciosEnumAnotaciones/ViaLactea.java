package ejerciciosEnumAnotaciones;
import lombok.Getter;

 @Getter

public enum ViaLactea {

	MERCURIO("true", "false", "230000.56km"), VENUS("true", "true", "880000.25km"),
	TIERRA("true", "true", "1000000.33km"), MARTE("true", "true", "1700000.56km"),
	JUPITER("false", "true", "1238790000.128km"), SATURNO("false", "true", "1236781220000.389km"),
	URANO("false", "true", "4238927830000.5999km"), NEPTUNO("false", "true", "22138782230000.8776km");

	private String asteroidRing;
	private String atmosphere;
	private String distanceSun;

	private ViaLactea(String asteroidRing, String atmosphere, String distanceSun) {
		this.asteroidRing = asteroidRing;
		this.atmosphere = atmosphere;
		this.distanceSun = distanceSun;
	}

	public String isInsideAnAsteroid(ViaLactea planeta) {
		if (planeta.getAsteroidRing().matches("true"))
			return planeta.asteroidRing;
		else
			return null;

	}

	public String hasAnAtmosphere(ViaLactea planeta) {

		if (planeta.getAtmosphere().matches("true"))
			return planeta.atmosphere;
		else
			return null;

	}

	public String distanceFromSun(ViaLactea planeta) {

		if (planeta.ordinal()==0)
			return planeta.distanceSun;
		else
			return null;


	}

}
