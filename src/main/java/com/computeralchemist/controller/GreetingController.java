package com.computeralchemist.controller;

import com.computeralchemist.domain.Greeting;
import com.computeralchemist.domain.SystemUser;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class GreetingController {

    @RequestMapping("/")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(1,"Hello Karol! " + LocalDate.now());
    }

    @RequestMapping(value = "/name", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getYourText(@RequestParam("name")String name) {
        System.out.println("Sended value: " + name);
        return name;
    }

    @RequestMapping(value = "/aboutautor", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public SystemUser autorData() {
        SystemUser user = new SystemUser();
        user.setBornYear(1993);
        user.setEmail("karol.meksula@onet.pl");
        user.setName("Karol");
        user.setSurname("Meksuła");
        user.setUserId(1);
        return user;
    }
}