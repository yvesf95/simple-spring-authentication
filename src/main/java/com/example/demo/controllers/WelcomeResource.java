package com.example.demo.controllers;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class WelcomeResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index() {
        return "Welcome";
    }

    @RequestMapping(value = "/authenticate")
    public Principal authenticate(Principal user) {
        return user;
    }

    @GetMapping("/user")
    public String user() {
        return "Welcome user";
    }

    @GetMapping("/admin")
    public List<User> admin() {
        return userRepository.findAll();
    }
}
