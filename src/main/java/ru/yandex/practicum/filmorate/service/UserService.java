package ru.yandex.practicum.filmorate.service;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.exception.NotFoundException;
import ru.yandex.practicum.filmorate.model.User;

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
        user.setId(getNewId());
        if (user.getName() == null || user.getName().isEmpty()) {
            user.setName(user.getLogin());
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

}
