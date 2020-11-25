package com.example.demo;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User admin = new User("admin", "admin", "John", "Doe", "ROLE_ADMIN");
        User user = new User("user", "pass", "John", "Doe 2", "ROLE_USER");

        userRepository.save(admin);
        userRepository.save(user);

    }
}
