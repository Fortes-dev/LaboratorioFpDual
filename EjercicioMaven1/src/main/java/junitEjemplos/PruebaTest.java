package junitEjemplos;

import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class PruebaTest {

	private String[] nombres;

	@BeforeEach
	public void init() {
		nombres = new String[] { "Cruz", "Jairo", "Juanpe", "Marco", "Jesus", "Miguel", "Alberto", "Juan" };
	}

	@Test
	public void testCase() {
		Stream.of(nombres).filter(data -> data.contains("J")).forEach(dato -> System.out.println(dato));
	}

	@Test
	public void testCase_TimeOut() throws InterruptedException {
		assertTimeout(Duration.ofMillis(1000), () -> Stream.of(nombres)
				.filter(data -> data.contains("A") || data.contains("a")).collect(Collectors.toList()));

	}

}