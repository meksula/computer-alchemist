package com.computeralchemist.controller.components;

import com.computeralchemist.controller.exception.ComponentListNotFoundException;
import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.controller.exception.ComponentNotFoundException;
import com.computeralchemist.domain.components.OpinionDto;
import com.computeralchemist.repository.RepositoryProvider;
import com.computeralchemist.repository.opinions.OpinionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Comparator;
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
    private OpinionRepository opinionRepository;

    @Autowired
    public void setRepositoryMap(RepositoryProvider repositoryProvider,
                                 OpinionRepository opinionRepository) {
        this.repositoryProvider = repositoryProvider;
        this.opinionRepository = opinionRepository;
    }

    @GetMapping(value = "/{id}", produces = "application/json; charset:UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public ComputerComponent getComponent(@PathVariable("component") String component,
                                          @PathVariable("id") long id) {

        ComputerComponent computerComponent = repositoryProvider.findComponent(component, id);

        if (computerComponent == null)
            throw new ComponentNotFoundException(component, id);

        computerComponent.add(linkTo(methodOn(ComponentsController.class)
                .getComponent(component, id)).withSelfRel());

        computerComponent.add(linkTo(methodOn(ComponentsController.class)
                .getListOfComponents(computerComponent.getComponentType().toString()))
                .withRel("collection"));

        return computerComponent;
    }

    @GetMapping(produces = "application/json; charset:UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public List<ComputerComponent> getListOfComponents(@PathVariable("component")String component) {
        List<ComputerComponent> componentList;
        try {
            componentList = repositoryProvider.getListOfComputerComponent(component);
        } catch (NullPointerException e) {
            throw new ComponentListNotFoundException(component);
        }

        componentList.sort(Comparator.comparing(ComputerComponent::getVotes).reversed());

        return setLinks(componentList);
    }

    private List<ComputerComponent> setLinks(List<ComputerComponent> components) {
        components.forEach(item -> {
            item.add(linkTo(methodOn(ComponentsController.class)
                    .getComponent(item.getComponentType().toString(), item.getProductId()))
                    .withSelfRel());
        });
        return components;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeComponent(@PathVariable("component")String component,
                                @PathVariable("id")long id) {

        boolean removed = repositoryProvider.removeComponent(component, id);

        if (!removed)
            throw new ComponentNotFoundException(component, id);
    }

    @PostMapping(value = "/{id}/opinions")
    @ResponseStatus(HttpStatus.CREATED)
    public OpinionDto putOpinionOfComponent(@PathVariable("component")String component,
                                            @PathVariable("id")long id,
                                            @RequestBody OpinionDto opinionDto) {

        opinionDto.setComponentType(ComponentType.valueOf(component));
        opinionDto.setProductId(id);
        opinionDto.setDate(LocalDate.now().toString());
        opinionDto.setOpinionId(opinionRepository.assignId());

        return opinionRepository.save(opinionDto);
    }

    @GetMapping(value = "/{id}/opinions")
    @ResponseStatus(HttpStatus.OK)
    public List<OpinionDto> getOpinionsOfComponent(@PathVariable("component")String component,
                                                   @PathVariable("id")long id) {

        return opinionRepository.findByComponentTypeAndProductId(ComponentType.valueOf(component), id);
    }

}
