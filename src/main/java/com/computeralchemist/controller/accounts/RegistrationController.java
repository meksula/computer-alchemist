package com.computeralchemist.controller.accounts;

import com.computeralchemist.domain.users.User;
import com.computeralchemist.domain.users.registration.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @Author
 * Karol Meksuła
 * 28-03-2018
 * */

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {
    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User registerNewUser(@RequestBody User user) {
        return registrationService.registerUser(user);
    }
}
