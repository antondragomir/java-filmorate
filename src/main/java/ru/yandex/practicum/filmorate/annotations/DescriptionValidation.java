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
@Constraint(validatedBy = DescriptionValidator.class)
public @interface DescriptionValidation {
    String message() default "Invalid description: the description cannot be more than 200 characters";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}