package ru.yandex.practicum.filmorate.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.service.FilmService;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.Collection;

@Validated
@Controller
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/film/{id:\\d+}")
    public ResponseEntity<Film> get(@PathVariable("id") @Min(0) Integer id) {
        return ResponseEntity.ok(filmService.getById(id).orElseThrow());
    }

    @GetMapping
    public ResponseEntity<Collection<Film>> getAll() {
        return ResponseEntity.ok(filmService.getFilms());
    }

    @PostMapping
    public ResponseEntity<Film> create(@Valid @RequestBody Film film) {
        return ResponseEntity.ok(filmService.createNewFilm(film));
    }

    @PutMapping
    public ResponseEntity<Film> update(
            @Valid @RequestBody Film film
    ) {
        return ResponseEntity.ok(filmService.updateFilm(film));
    }

}
