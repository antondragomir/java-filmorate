package ru.yandex.practicum.filmorate.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class User {
    @Min(1)
    Integer id;

    String name;

    @NotBlank
    @NotNull
    String login;

    @NotNull
    @Email
    String email;

    @NotNull
    LocalDate birthday;
}
