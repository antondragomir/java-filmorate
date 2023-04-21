package ru.yandex.practicum.filmorate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotFoundException extends AppException {

    public NotFoundException(String message) {
        super(message);
    }

}
