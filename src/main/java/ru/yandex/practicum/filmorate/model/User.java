package ru.yandex.practicum.filmorate.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

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
