package ru.yandex.practicum.filmorate.model;

import lombok.Data;
import ru.yandex.practicum.filmorate.annotations.ReleaseDateValidation;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class Film {
    @Min(1)
    private Integer id;

    @NotBlank
    private String name;

    @Size(max = 200)
    private String description;

    @NotNull
    @ReleaseDateValidation()
    private LocalDate releaseDate;

    @NotNull
    @Min(1)
    private Integer duration;
}
