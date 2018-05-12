package com.computeralchemist.controller.components;

import com.computeralchemist.controller.exception.SetNotFoundException;
import com.computeralchemist.controller.others.ComponentBasicData;
import com.computeralchemist.controller.exception.SetListNotFoundException;
import com.computeralchemist.domain.creator.setTypes.ComputerSet;
import com.computeralchemist.domain.creator.ComputerSetManager;
import com.computeralchemist.repository.RepositoryProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * @Author
 * Karol Meksuła
 * 11-04-2018
 * */

@RestController
@RequestMapping(value = "/set")
public class CreatorController {
    private ComputerSetManager computerSetManager;
    private RepositoryProvider repositoryProvider;

    @Autowired
    public void setComputerSetManager(ComputerSetManager computerSetManager,
                                      RepositoryProvider repositoryProvider) {
        this.computerSetManager = computerSetManager;
        this.repositoryProvider = repositoryProvider;
    }

    private String type;
    private long id;

    @PostMapping(value = "/{user}")
    @ResponseStatus(HttpStatus.CREATED)
    public ComputerSet initNewCompSet(@PathVariable("user") String user,
                                            @RequestBody String type) {

        ComputerSet computerSet = computerSetManager.initSet(user, type);

        this.type = computerSet.getType().toString();
        this.id = computerSet.getSetId();

        buildHateoasLinks(computerSet);

        computerSetManager.updateSet();

        return computerSet;
    }

    @GetMapping(value = "/{type}/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ComputerSet getCompSet(@PathVariable("type") String type,
                                  @PathVariable("id") long id) {

        ComputerSet computerSet = computerSetManager.loadExistComputerSet(type, id);
        return buildHateoasLinks(computerSet);
    }

    @GetMapping(value = "/{type}")
    @ResponseStatus(HttpStatus.OK)
    public List<ComputerSet> getCompSetList(@PathVariable("type")String type) {
        List<ComputerSet> list;
        try {
            list = computerSetManager.getComputerSetList(type);
        } catch (NullPointerException npo) {
            throw new SetListNotFoundException(type);
        }

        return list;
    }

    @PutMapping(value = "/{type}/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ComputerSet assembleComponentToSet(@PathVariable("type")String type,
                                              @PathVariable("id")long id,
                                              @RequestBody ComponentBasicData basicData) {

        computerSetManager.loadExistComputerSet(type, id);
        computerSetManager.prepareComponentToAssembling(basicData.getComponentType(), basicData.getId());
        computerSetManager.assembleComponent();
        ComputerSet updatedSet = computerSetManager.updateSet();
        return buildHateoasLinks(updatedSet);
    }

    @DeleteMapping(value = "/{type}/{id}")
    public ResponseEntity<?> removeComputerSet(@PathVariable("type") String type,
                                            @PathVariable("id") long id) {

        Boolean removed = repositoryProvider.removeSet(type, id);

        if (!removed)
            throw new SetNotFoundException(type, id);

        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    private ComputerSet buildHateoasLinks(ComputerSet computerSet) {
        computerSet.add(linkTo(methodOn(CreatorController.class)
                .getCompSet(this.type, id))
                .withSelfRel());

        computerSet.add(linkTo(methodOn(CreatorController.class)
                .getCompSet(this.type, id))
                .withRel("collection"));

        computerSet.add(linkTo(methodOn(CreatorController.class)
                .removeComputerSet(this.type, id))
                .withRel("delete"));

        computerSet.add(linkTo(methodOn(CreatorController.class)
                .assembleComponentToSet(this.type, id, new ComponentBasicData()))
                .withRel("assemble component"));

        return computerSet;
    }

}
