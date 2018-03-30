package com.computeralchemist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author
 * Karol Meksuła
 * 29-03-2018
 * */

@RestController
@RequestMapping("/public-api")
public class PublicApiController {

    @GetMapping(produces = "application/json; charset=utf-8")
    public String publicApi() {
        return "Api publiczne";
    }
}
