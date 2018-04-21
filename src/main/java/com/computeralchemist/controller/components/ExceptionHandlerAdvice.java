package com.computeralchemist.controller.components;


import com.computeralchemist.controller.exception.*;
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
    @ResponseStatus(HttpStatus.NOT_MODIFIED)
    public String setTypeNotSupport() {
        return SetTypeNotSupportedException.Error.report();
    }

    @ExceptionHandler(SetNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String setNotFound() {
        return SetNotFoundException.Error.report();
    }

    @ExceptionHandler(SetListNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String setListNotFound() {
        return SetListNotFoundException.Error.report();
    }

    @ExceptionHandler(BadComponentTypeException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String componentNotCorrect() {
        return BadComponentTypeException.Error.report();
    }

}
