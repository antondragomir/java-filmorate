package ru.yandex.practicum.filmorate.model;

import lombok.Data;
import ru.yandex.practicum.filmorate.annotations.BirthdayValidation;
import ru.yandex.practicum.filmorate.annotations.EmailValidation;
import ru.yandex.practicum.filmorate.annotations.LoginValidation;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class User {
    @Min(1)
    private Integer id;

    private String name;
    @LoginValidation()
    private String login;

    @Email
    @NotEmpty
    private String email;

    @NotNull
    @PastOrPresent
    private LocalDate birthday;
}
