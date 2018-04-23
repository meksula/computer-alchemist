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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sun.security.provider.certpath.OCSPResponse;

import java.net.URI;
import java.util.List;


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

    @PostMapping(value = "/{user}", produces = "application/json; charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> initNewCompSet(@PathVariable("user") String user,
                                      @RequestBody String type) {

        ComputerSet computerSet = computerSetManager.initSet(user, type);

        this.type = computerSet.getType().toString();
        this.id = computerSet.getSetId();

        computerSetManager.updateSet();

        return ResponseEntity.created(URI.create(buildUri())).build();
    }

    private String buildUri() {
        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/set").path("/{type}").path("/{id}")
                .buildAndExpand(type, id)
                .toUriString();
    }

    @GetMapping(value = "/{type}/{id}", produces = "application/json; charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public ComputerSet getCompSet(@PathVariable("type") String type,
                                  @PathVariable("id") long id) {

        return computerSetManager.loadExistComputerSet(type, id);
    }

    @GetMapping(value = "/{type}", produces = "application/json; charset=UTF-8")
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

    @PutMapping(value = "/{type}/{id}", produces = "application/json; charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public ComputerSet assembleComponentToSet(@PathVariable("type")String type,
                                              @PathVariable("id")long id,
                                              @RequestBody ComponentBasicData basicData) {

        computerSetManager.loadExistComputerSet(type, id);
        computerSetManager.prepareComponentToAssembling(basicData.getComponentType(), basicData.getId());
        computerSetManager.assembleComponent();
        return computerSetManager.updateSet();
    }

    @DeleteMapping(value = "/{type}/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeComputerSet(@PathVariable("type") String type,
                                  @PathVariable("id") long id) {

        boolean removed = repositoryProvider.removeSet(type, id);

        if (!removed)
            throw new SetNotFoundException(type, id);
    }

}
