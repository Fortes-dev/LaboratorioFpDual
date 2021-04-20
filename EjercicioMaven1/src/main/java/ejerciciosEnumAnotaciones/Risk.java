package ejerciciosEnumAnotaciones;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

@Documented
@Retention(RUNTIME)
public @interface Risk {
	String riesgo() default""; //niveles de riesgo del 1 al 10
	String tiporiesgo() default"";
}
