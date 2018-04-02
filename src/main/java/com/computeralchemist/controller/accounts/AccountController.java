package com.computeralchemist.controller.accounts;

import com.computeralchemist.domain.users.User;
import com.computeralchemist.repository.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * @Author
 * Karol Meksuła
 * 28-03-2018
 * */

@RestController
@RequestMapping("/register")
public class AccountController {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(produces = "application/json; charset=utf-8")
    public ResponseEntity<User> registerNewUser(@RequestBody User user, UriComponentsBuilder uri) {
        userRepository.save(user);

        HttpHeaders headers = new HttpHeaders();
        URI locationUri = uri.path("/user/").path(user.getUsername()).build().toUri();

        headers.setLocation(locationUri);

        return new ResponseEntity<>(user, headers, HttpStatus.CREATED);
    }
}
