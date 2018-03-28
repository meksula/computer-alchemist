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
@RequestMapping("/user")
public class UserAuthController {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(produces = "application/json;charset=UTF-8")
    public User postForUser(@RequestBody User user) {
        userRepository.save(user);
        return user;
    }
}
