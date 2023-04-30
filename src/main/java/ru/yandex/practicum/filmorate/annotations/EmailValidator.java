package ru.yandex.practicum.filmorate.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailValidation, String> {
    public boolean isValid(String email, ConstraintValidatorContext cxt) {
        return email.contains("@");
    }
}
