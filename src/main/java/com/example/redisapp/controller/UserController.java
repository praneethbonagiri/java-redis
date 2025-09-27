package com.example.redisapp.controller;

import com.example.redisapp.model.User;
import com.example.redisapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String saveUser(@RequestBody User user) {
        System.out.println("Received a post request");
        userService.saveUser(user);
        return "User saved to Redis";
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        System.out.println("Received a get request");
        return userService.getUser(id);
    }
}
