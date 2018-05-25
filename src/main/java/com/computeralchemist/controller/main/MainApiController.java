package com.computeralchemist.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author
 * Karol Meksuła
 * 29-03-2018
 * */

@Controller
public class MainApiController {

    @GetMapping("/")
    public String welcome() {
        return "home";
    }

    @GetMapping("/doc")
    public String documentation() {
        return "documentation";
    }

    @GetMapping("/types")
    public String types() {
        return "types";
    }

    @GetMapping("/basic")
    public String basic() {
        return "basic";
    }

    @GetMapping("/builder")
    public String builder() {
        return "builder";
    }

    @GetMapping("/pickpocket")
    public String pickpocket() {
        return "pickpocket";
    }

}
