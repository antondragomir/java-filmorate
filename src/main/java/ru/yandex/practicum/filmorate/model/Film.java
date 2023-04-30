package ru.yandex.practicum.filmorate.model;

import lombok.Data;
import ru.yandex.practicum.filmorate.annotations.DescriptionValidation;
import ru.yandex.practicum.filmorate.annotations.NameValidation;
import ru.yandex.practicum.filmorate.annotations.ReleaseDateValidation;

import javax.validation.constraints.Min;
import java.time.LocalDate;

@Data
public class Film {
    @Min(1)
    Integer id;

    @NameValidation()
    String name;

    @DescriptionValidation()
    String description;
    @ReleaseDateValidation()
    LocalDate releaseDate;

    @Min(0)
    Integer duration;
}
