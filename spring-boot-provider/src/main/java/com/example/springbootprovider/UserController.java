package com.example.springbootprovider;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class UserController {

    private final AtomicLong counter = new AtomicLong();
    private final Map<Long, User> currentUsers = new HashMap<>();

    {
        counter.set(1L);
        currentUsers.put(1L, new User(1, "Toto", "Titi"));
        currentUsers.put(2L, new User(2, "Tata", "Tütü"));
    }

    @GetMapping("/api/users/{id}")
    public User getUser(@PathVariable("id") long id) {
        return currentUsers.get(id);
    }

    @GetMapping("/api/users")
    public Map<String, Collection<User>> getUsers() {
        return Map.of("users", currentUsers.values());
    }

    @PostMapping("/api/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User receivedUser) {
        User newUser = new User(counter.incrementAndGet(), receivedUser.getFirstName(), receivedUser.getLastName());
        currentUsers.put(counter.get(), newUser);
        return newUser;
    }

    @PutMapping("/api/users/{id}")
    public User updateUser(@PathVariable("id") long id, @RequestBody User updateUser) {
        return new User(id, updateUser.getFirstName(), updateUser.getLastName());
    }
}
