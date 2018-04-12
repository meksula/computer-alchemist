package com.computeralchemist.controller.components;

import com.computeralchemist.domain.creator.ComputerSet;
import com.computeralchemist.domain.creator.ComputerSetManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 11-04-2018
 * */

@RestController
@RequestMapping(value = "/{user}/set")
public class SetCreationController {
    private ComputerSetManager computerSetManager;

    @Autowired
    public void setComputerSetManager(ComputerSetManager computerSetManager) {
        this.computerSetManager = computerSetManager;
    }

    @PostMapping(produces = "application/json; charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public ComputerSet initNewCompSet(@PathVariable("user")String user,
                                      @RequestBody String type) {

        return computerSetManager.initSet(user, type);
    }

    @GetMapping(value = "/{type}/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ComputerSet getCompSet(@PathVariable("type")String type,
                                  @PathVariable("id")long id) {

        return computerSetManager.findComputerSetById(type, id);
    }

    @GetMapping(value = "{type}/{number}")
    @ResponseStatus(HttpStatus.OK)
    public List<ComputerSet> getCompSetList(@PathVariable("type")String type,
                                            @PathVariable("number")int number) {

        return computerSetManager.getListOfCompSet(type, number);
    }
}
