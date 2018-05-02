package com.computeralchemist.controller.pickpocket;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.pickpocket.core.PickpocketCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

@RestController
@RequestMapping("/pickpocket")
public class PickpocketController {
    private PickpocketCommand pickpocketCommand;

    @Autowired
    public void setPickpocketCommand(PickpocketCommand pickpocketCommand) {
        this.pickpocketCommand = pickpocketCommand;
    }

    @PostMapping(value = "/{componentType}", produces = "application/json; charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public ComputerComponent getComponentFromHtml(@RequestBody String url,
                                                  @PathVariable("componentType")String componentType) {

        return pickpocketCommand.executeUrl(url, componentType);
    }
}
