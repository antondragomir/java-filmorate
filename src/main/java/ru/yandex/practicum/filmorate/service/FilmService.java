package ru.yandex.practicum.filmorate.service;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.exception.NotFoundException;
import ru.yandex.practicum.filmorate.model.Film;

import java.util.*;

@Service
public class FilmService {
    private final Map<Integer, Film> films = new HashMap<>();
    private Integer id = 0;
    private static final Logger log = LoggerFactory.getLogger(FilmService.class);
    public Optional<Film> getById(@NonNull Integer id) {
        return Optional.ofNullable(films.get(id));
    }
    public Optional<Film> createNewFilm(@NonNull Film film) {
        film.setId(getNewId());
        films.put(film.getId(), film);
        return Optional.of(film);
    }
    public Optional<Film> updateFilm(Film film) {
        Optional<Film> optFilm = getById(film.getId());
        if (optFilm.isEmpty()) {
            log.error("Фильм не найден");
            throw new NotFoundException("Фильм не найден");
        }
        Film existFilm = films.get(optFilm.get().getId());
        existFilm.setName(film.getName());
        existFilm.setDescription(film.getDescription());
        existFilm.setDuration(film.getDuration());
        existFilm.setReleaseDate(film.getReleaseDate());

        log.info("Изменение фильма. id = {}", existFilm.getId());
        return Optional.of(existFilm);
    }
    private Integer getNewId() {
        return ++id;
    }
    public Collection<Film> getFilms() {
        return films.values();
    }

}
