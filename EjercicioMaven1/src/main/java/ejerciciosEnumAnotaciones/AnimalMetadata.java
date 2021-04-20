package ejerciciosEnumAnotaciones;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



@Retention(RetentionPolicy.RUNTIME)
@Documented

public @interface AnimalMetadata {
	String dia() default "";
	String pais() default "";

}
