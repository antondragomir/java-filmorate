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
        checkName(user);
        users.put(user.getId(), user);
        return Optional.of(user);
    }

    public Optional<User> updateUser(User user) {
        User existUser = getById(user.getId()).orElseThrow(() -> {
            throw new NotFoundException("Пользователь не найден");
        });
        checkName(user);
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

    private void checkName(User user) {
        if (user.getName() == null || user.getName().isBlank()) {
            user.setName(user.getLogin());
            log.info("Изменение имени пользователя. login = {}", user.getLogin());
        }
    }

    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

}
