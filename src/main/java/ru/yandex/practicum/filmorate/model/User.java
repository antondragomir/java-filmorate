package ru.yandex.practicum.filmorate.model;

import lombok.Data;
import ru.yandex.practicum.filmorate.annotations.BirthdayValidation;
import ru.yandex.practicum.filmorate.annotations.EmailValidation;
import ru.yandex.practicum.filmorate.annotations.LoginValidation;

import javax.validation.constraints.Min;
import java.time.LocalDate;

@Data
public class User {
    @Min(1)
    Integer id;

    String name;
    @LoginValidation()
    String login;

    @EmailValidation()
    String email;

    @BirthdayValidation()
    LocalDate birthday;
}
