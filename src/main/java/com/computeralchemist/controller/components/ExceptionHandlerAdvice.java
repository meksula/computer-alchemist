package com.computeralchemist.controller.components;


import com.computeralchemist.controller.exception.ComponentListNotFoundException;
import com.computeralchemist.controller.exception.ComponentNotFoundException;
import com.computeralchemist.controller.exception.SetNotFoundException;
import com.computeralchemist.controller.exception.SetTypeNotSupportedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author
 * Karol Meksuła
 * 17-04-2018
 * */

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ComponentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String componentNotFound() {
        return ComponentNotFoundException.Error.reportOne();
    }

    @ExceptionHandler(ComponentListNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String listNotFound() {
        return ComponentListNotFoundException.Error.reportList();
    }

    @ExceptionHandler(SetTypeNotSupportedException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String setTypeNotSupport() {
        return SetTypeNotSupportedException.Error.report();
    }

    @ExceptionHandler(SetNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private String setNotFound() {
        return SetNotFoundException.Error.report();
    }

}
