package com.computeralchemist.controller.accounts;

import com.computeralchemist.domain.users.registration.UserValidateException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author
 * Karol Meksuła
 * 03-06-2018
 * */

@RestControllerAdvice
public class ExceptionAccountsHandler {

    @ExceptionHandler(UserValidateException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String cannotRegister() {
        return new UserValidateException().getMessage();
    }

    @ExceptionHandler(AuthorizationServiceException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String authenticationFailure() {
        return "Bad credentials. Cannot authentication.";
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String usernameNotFound() {
        return "Username or userId not found in databaase.";
    }

}
