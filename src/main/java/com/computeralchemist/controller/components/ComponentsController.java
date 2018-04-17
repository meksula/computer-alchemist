package com.computeralchemist.controller.components;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.repository.RepositoryProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * @Author
 * Karol Meksuła
 * 17-04-2018
 * */

@RestController
@RequestMapping("/components/{component}")
public class ComponentsController {
    private RepositoryProvider repositoryProvider;

    @Autowired
    public void setRepositoryMap(RepositoryProvider repositoryProvider) {
        this.repositoryProvider = repositoryProvider;
    }

    @GetMapping(value = "/{id}", produces = "application/json; charset:UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public ComputerComponent getComponent(@PathVariable("component")String component,
                                          @PathVariable("id")long id) {

        ComputerComponent computerComponent = repositoryProvider.findComponent(component, id);
        computerComponent.add(linkTo(methodOn(ComponentsController.class).getComponent(component, id)).withSelfRel());
        return computerComponent;
    }

    @GetMapping(produces = "application/json; charset:UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public List<ComputerComponent> getListOfComponents(@PathVariable("component")String component) {
        return setLinks(repositoryProvider.getListOfComputerComponent(component));
    }

    private List<ComputerComponent> setLinks(List<ComputerComponent> components) {
        components.forEach(item -> {
            item.add(linkTo(methodOn(ComponentsController.class)
                    .getComponent(item.getComponentType().toString(), item.getProductId()))
                    .withSelfRel());
        });
        return components;
    }
}
