package ru.yandex.practicum.filmorate.model;

import jakarta.validation.constraints.Min;
import lombok.Data;

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
