package com.computeralchemist.controller.accounts;

import com.computeralchemist.domain.users.registration.UserValidateException;
import org.springframework.http.HttpStatus;
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
}
