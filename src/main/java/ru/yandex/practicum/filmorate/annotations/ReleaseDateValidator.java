package ru.yandex.practicum.filmorate.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class ReleaseDateValidator implements ConstraintValidator<ReleaseDateValidation, LocalDate> {
    public boolean isValid(LocalDate releaseDate, ConstraintValidatorContext cxt) {
        return releaseDate.isAfter(LocalDate.of(1895, 12, 28));
    }
}
