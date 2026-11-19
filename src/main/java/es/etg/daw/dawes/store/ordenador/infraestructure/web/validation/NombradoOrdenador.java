package es.etg.daw.dawes.store.ordenador.infraestructure.web.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NombradoOrdenadorValidator.class)
@Documented

public @interface NombradoOrdenador {
    //Definimos el mensaje por defecto
    String message() default "{es.etg.daw.dawes.store.ordenador.infraestructure.web.validation.NombradoOrdenador}";

    //Permite agrupar validaciones. Es útil cuando quieres validar solo un subconjunto de reglas 
    //(por ejemplo, validar un ordenador para "Creación" vs. para "Actualización"). 
    //El valor por defecto es para todos los casos.
    Class<?>[] groups() default {};
    
    //Una propiedad avanzada que permite definir metadatos  o códigos de error específicos al resultado de la validación.
    Class<? extends Payload>[] payload() default {};
}
