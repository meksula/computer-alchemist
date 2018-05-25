package com.computeralchemist.controller.accounts;

import com.computeralchemist.domain.users.User;
import com.computeralchemist.repository.users.UserRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Validation;

/**
 * @Author
 * Karol Meksuła
 * 28-03-2018
 * */

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    private UserRepository userRepository;

    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<User> registerNewUser(@RequestBody User user) {
        userRepository.save(user);
        HttpHeaders headers = new HttpHeaders();
        //URI locationUri = uri.path("/user/").path(user.getUsername()).build().toUri();

        //headers.setLocation(locationUri);

        return new ResponseEntity<>(user, headers, HttpStatus.CREATED);
    }
}
