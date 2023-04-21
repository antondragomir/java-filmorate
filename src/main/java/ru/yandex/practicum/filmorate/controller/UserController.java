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
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.service.UserService;

import java.util.Collection;

@Validated
@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService = new UserService();

    @GetMapping("/user/{id:\\d+}")
    public ResponseEntity<User> getUser(@Valid @PathVariable("id") @Min(0) Integer id) {
        return ResponseEntity.ok(userService.getById(id).orElseThrow());
    }

    @GetMapping
    public Collection<User> getAllUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.createNewUser(user).orElseThrow());
    }

    @PutMapping
    public ResponseEntity<User> updateUser(
            @RequestBody User user
    ) {
        return ResponseEntity.ok(userService.updateUser(user).orElseThrow());
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
