package ru.yandex.practicum.filmorate.model;

import lombok.Data;

import javax.validation.constraints.Min;
import java.time.LocalDate;

@Data
public class Film {
    @Min(1)
    Integer id;
    String name;
    String description;
    LocalDate releaseDate;
    Integer duration;
}
