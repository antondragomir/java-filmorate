package ru.yandex.practicum.filmorate.controller;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import jakarta.validation.constraints.Min;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.exception.*;
import ru.yandex.practicum.filmorate.model.ErrorMessage;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.service.FilmService;

import java.util.Collection;

@Validated
@RestController
@RequestMapping("/films")
public class FilmController {

    private static final Logger log = LoggerFactory.getLogger(FilmController.class);
    private final FilmService filmService = new FilmService();

    @GetMapping("/film/{id:\\d+}")
    public ResponseEntity<Film> get(@Valid @PathVariable("id") @Min(0) Integer id) {
        return ResponseEntity.ok(filmService.getById(id).orElseThrow());
    }

    @GetMapping
    public Collection<Film> getAll() {
        return filmService.getFilms();
    }

    @PostMapping
    public ResponseEntity<Film> create(@Valid @RequestBody Film film) {
        return ResponseEntity.ok(filmService.createNewFilm(film).orElseThrow());
    }

    @PutMapping
    public ResponseEntity<Film> update(
            @RequestBody Film film
    ) {
        return ResponseEntity.ok(filmService.updateFilm(film).orElseThrow());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorMessage handleException(NotFoundException exception) {
        return new ErrorMessage(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NotFoundException.class)
    public ErrorMessage handleException(ValidationException exception) {
        return new ErrorMessage(exception.getMessage());
    }

}
