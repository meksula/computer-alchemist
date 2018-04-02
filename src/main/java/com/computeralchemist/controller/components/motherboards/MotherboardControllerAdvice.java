package com.computeralchemist.controller.components.motherboards;


import com.computeralchemist.controller.exception.ComponentNotFoundException;
import com.computeralchemist.controller.exception.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ControllerAdvice
@EnableWebMvc
public class MotherboardControllerAdvice {

    @ExceptionHandler(ComponentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error throwError(ComponentNotFoundException exception) {
        return new Error(4, "Component with index: " + exception.getComponentId()
                + " not exist!");
    }
}
