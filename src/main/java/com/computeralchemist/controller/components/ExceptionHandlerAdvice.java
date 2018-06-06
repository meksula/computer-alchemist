package com.computeralchemist.controller.components;


import com.computeralchemist.controller.exception.*;
import com.computeralchemist.controller.exception.NothingHasChangedException;
import com.computeralchemist.domain.pickpocket.exception.HtmlParseFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;

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

    @ExceptionHandler(ComponentExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String componentExist() {
        return ComponentExistException.getRaport();
    }

    @ExceptionHandler(NothingHasChangedException.class)
    @ResponseStatus(HttpStatus.NOT_MODIFIED)
    public String computerSetNotModified() {
        return NothingHasChangedException.getRaport();
    }

    @ExceptionHandler(CannotReadUrlException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String cannotReadUri() {
        return new CannotReadUrlException().getMessage();
    }

    @ExceptionHandler(HtmlParseFailedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String parserError() {
        return new HtmlParseFailedException().getMessage();
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String pickpocketFailure() {
        return "Something went wrong: Pickpocket cannot parse some values.";
    }

    @ExceptionHandler(AuthorizationServiceException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String authenticationFailure() {
        return "Bad credentials. Cannot authentication.";
    }
}
