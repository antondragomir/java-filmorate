package ru.yandex.practicum.filmorate.annotations;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DescriptionValidator implements ConstraintValidator<DescriptionValidation, String> {
    public boolean isValid(String description, ConstraintValidatorContext cxt) {
        return description == null || description.length() <= 200;
    }
}
