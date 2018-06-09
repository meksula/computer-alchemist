package com.computeralchemist.controller.accounts;

import com.computeralchemist.domain.users.User;
import com.computeralchemist.repository.users.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * @Author
 * Karol Meksuła
 * 03-06-2018
 * */

@RestController
@RequestMapping(path = "/api/v1/login")
public class LoginController {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public LoginController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public User getForUser(@RequestBody BasicCredentials basicCredentials) {
       User user = userRepository.findByUsername(basicCredentials.getUsername())
                .orElseThrow(() -> new AuthorizationServiceException("user not exist"));

        if (passwordEncoder.matches(basicCredentials.getPassword(), user.getPassword()))
            return user;

        else throw new AuthorizationServiceException("password not matches");
    }

}

