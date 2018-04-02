package com.computeralchemist.controller.accounts;

import com.computeralchemist.domain.users.User;
import com.computeralchemist.repository.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @Author
 * Karol Meksuła
 * 29-03-2018
 * */

@RestController
@RequestMapping("/user")
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/{username}", produces = "application/json;charset=UTF-8")
    public User getUser(@PathVariable("username")String username) {
        return userRepository.findByUsername(username);
    }
}
