package com.computeralchemist.controller;

import com.computeralchemist.domain.User;
import com.computeralchemist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/new-user")
public class RegistrationController {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(produces = "application/json;charset=UTF-8")
    public User postForUser(@RequestBody User user) {
        System.out.println(user.toString());
        userRepository.save(user);
        return user;
    }
}
