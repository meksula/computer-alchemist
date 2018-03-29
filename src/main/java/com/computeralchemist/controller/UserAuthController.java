package com.computeralchemist.controller;

import com.computeralchemist.domain.User;
import com.computeralchemist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author
 * Karol Meksuła
 * 28-03-2018
 * */

@RestController
@RequestMapping("/api/user")
public class UserAuthController {
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

    @GetMapping(value = "/denied", produces = "application/json;charset=UTF-8")
    public String showError() {
        return "Access to resource denied!";
    }
}
