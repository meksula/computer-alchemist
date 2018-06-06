package com.computeralchemist.controller.accounts;

import com.computeralchemist.configuration.UserDetailsServiceImpl;
import com.computeralchemist.repository.users.UserRepository;
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
    private UserDetailsServiceImpl userDetailsService;

    public LoginController(UserRepository userRepository, PasswordEncoder passwordEncoder,
                           UserDetailsServiceImpl userDetailsService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }


}
