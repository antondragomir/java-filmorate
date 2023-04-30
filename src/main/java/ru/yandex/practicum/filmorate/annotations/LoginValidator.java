package ru.yandex.practicum.filmorate.annotations;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LoginValidator implements ConstraintValidator<LoginValidation, String>
{
    public boolean isValid(String login, ConstraintValidatorContext cxt) {
        return (login != null) && !(login.isEmpty()) && !(login.contains(" "));
    }
}
