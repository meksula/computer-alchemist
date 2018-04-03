package com.computeralchemist.controller.components;

import com.computeralchemist.controller.exception.ComponentNotFoundException;
import com.computeralchemist.controller.exception.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Author
 * Karol Meksuła
 * 03-04-2018
 * */

@ControllerAdvice
@EnableWebMvc
public class ComponentsControllerAdvice {

    @ExceptionHandler(ComponentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody Error throwError(ComponentNotFoundException exception) {
        return new Error(4, "Component with index: " + exception.getComponentId()
                + " not exist!");
    }
}
