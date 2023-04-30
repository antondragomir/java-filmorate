package ru.yandex.practicum.filmorate.annotations;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<NameValidation, String> {
    public boolean isValid(String login, ConstraintValidatorContext cxt) {
        return (login != null) && !(login.isEmpty());
    }
}
