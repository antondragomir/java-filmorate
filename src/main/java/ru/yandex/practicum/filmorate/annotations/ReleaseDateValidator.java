package ru.yandex.practicum.filmorate.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class ReleaseDateValidator implements ConstraintValidator<ReleaseDateValidation, LocalDate> {
    private final LocalDate notBeforeDate = LocalDate.of(1895, 12, 28);

    public boolean isValid(LocalDate releaseDate, ConstraintValidatorContext cxt) {
        if (releaseDate == null) return false;
        return releaseDate.isAfter(notBeforeDate);
    }
}
