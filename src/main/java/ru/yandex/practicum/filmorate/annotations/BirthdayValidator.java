package ru.yandex.practicum.filmorate.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class BirthdayValidator implements ConstraintValidator<BirthdayValidation, LocalDate> {
    public boolean isValid(LocalDate birthday, ConstraintValidatorContext cxt) {
        return birthday.isBefore(LocalDate.now());
    }
}
