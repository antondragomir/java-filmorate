package ru.yandex.practicum.filmorate.service;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.exception.NotFoundException;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.User;

import java.time.LocalDate;
import java.util.*;

@Service
public class UserService {
    private final Map<Integer, User> users = new HashMap<>();
    private Integer id = 0;

    private static final Logger log = LoggerFactory.getLogger(UserService.class);


    public Optional<User> getById(@NonNull Integer id) {
        return Optional.ofNullable(users.get(id));
    }

    public Optional<User> createNewUser(@NonNull User user) {
        if (userValidator(user)) {
            user.setId(getNewId());
        }
        users.put(user.getId(), user);
        return Optional.of(user);
    }

    public Optional<User> updateUser(User user) {
        Optional<User> optUser = getById(user.getId());
        if (optUser.isEmpty()) {
            log.error("Пользователь не найден");
            throw new NotFoundException("Пользователь не найден");
        }
        userValidator(user);
        User existUser = users.get(optUser.get().getId());
        existUser.setBirthday(user.getBirthday());
        existUser.setName(user.getName());
        existUser.setEmail(user.getEmail());
        existUser.setLogin(user.getLogin());

        log.info("Изменение пользователя. id = {}", existUser.getId());
        return Optional.of(existUser);
    }

    private Integer getNewId() {
        return ++id;
    }

    public Collection<User> getUsers() {
        return users.values();
    }

    private boolean userValidator(User user) {
        if (user.getLogin().contains(" ") || user.getLogin().isEmpty()) {
            throw new ValidationException("Ошибка валидации");
        }
        if (!user.getEmail().contains("@") || user.getEmail().isEmpty()) {
            throw new ValidationException("Ошибка валидации");
        }
        if (user.getBirthday().isAfter(LocalDate.now())) {
            throw new ValidationException("Ошибка валидации");
        }
        if (user.getName() == null) {
            user.setName(user.getLogin());
        }

        return true;
    }
}
