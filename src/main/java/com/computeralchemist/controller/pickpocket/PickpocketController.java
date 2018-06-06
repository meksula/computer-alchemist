package com.computeralchemist.controller.pickpocket;

import com.computeralchemist.controller.components.NewComponentsController;
import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.pickpocket.core.PickpocketCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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

    @PostMapping(value = "/{componentType}")
    @ResponseStatus(HttpStatus.OK)
    public ComputerComponent getComponentFromHtml(@RequestBody String url,
                                                  @PathVariable("componentType")String componentType) {

        ComputerComponent computerComponent = pickpocketCommand.executeUrl(url, componentType);

        computerComponent.add(linkTo(methodOn(NewComponentsController.class)
                .addNewComponent(componentType))
                .withRel("save in database"));

        computerComponent.add(linkTo(methodOn(PickpocketController.class)
                .getComponentProperties(url, componentType))
                .withRel("properties"));

        return computerComponent;
    }

    @PostMapping(value = "/{componentType}/properties")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getComponentProperties(@RequestBody String url,
                                               @PathVariable("componentType")String componentType) {

        return pickpocketCommand.executeUrlForProperties(url, componentType);
    }

}
