package com.example.springbootprovider;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class UserController {

    private final AtomicLong counter = new AtomicLong();
    private final Map<Long, User> currentUsers = new HashMap<>();

    {
        counter.set(1L);
        currentUsers.put(1L, new User(1, "MrFirst", "Tester"));
        currentUsers.put(42L, new User(42, "MrsSecond", "Developer"));
    }

    @GetMapping("/api/user/{id}")
    public User getUser(@PathVariable("id") long id) {
        return currentUsers.get(id);
    }

    @PostMapping("/api/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User receivedUser) {
        User newUser = new User(counter.incrementAndGet(), receivedUser.getFirstName(), receivedUser.getLastName());
        currentUsers.put(counter.get(), newUser);
        return newUser;
    }

    @PutMapping("/api/user/{id}")
    public User updateUser(@PathVariable("id") long id, @RequestBody User updateUser) {
        return new User(id, updateUser.getFirstName(), updateUser.getLastName());
    }
}