package com.computeralchemist.controller.accounts;

import com.computeralchemist.domain.users.User;
import com.computeralchemist.repository.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

/**
 * @Author
 * Karol Meksuła
 * 29-03-2018
 * */

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/{username}")
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@PathVariable("username") String username) {
        return findUsername(username);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserByUserId(@PathVariable("userId") Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException(String.valueOf(userId)));
    }

    @GetMapping(value = "/{username}/account")
    @ResponseStatus(HttpStatus.OK)
    public User getUserAccount(@PathVariable("username") String username, Authentication authentication) {
        if (username.equals(authentication.getName()))
            return findUsername(username);

        else throw new AuthorizationServiceException(username);
    }

    @DeleteMapping(value = "/{username}/account")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> removeUser(@PathVariable("username") String username, Authentication authentication) {
        if (username.equals(authentication.getName())) {
            userRepository.delete(findUsername(username));
            return new ResponseEntity<>(HttpStatus.OK);
        } else throw new AuthorizationServiceException(username);
    }

    private User findUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

}
