package ru.yandex.practicum.filmorate.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

@Target({FIELD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NameValidator.class)
public @interface NameValidation {
    String message() default "Invalid name: the name cannot be empty";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}