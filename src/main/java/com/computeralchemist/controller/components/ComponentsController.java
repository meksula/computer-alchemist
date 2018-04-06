package com.computeralchemist.controller.components;

import com.computeralchemist.controller.RepositoryMap;
import com.computeralchemist.domain.components.ComputerComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/components/{component}/{id}")
public class ComponentsController {
    private RepositoryMap repositoryMap;

    @Autowired
    public void setRepositoryMap(RepositoryMap repositoryMap) {
        this.repositoryMap = repositoryMap;
    }

    @GetMapping(produces = "application/json; charset:UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public ComputerComponent getComponent(@PathVariable("component")String component,
                                          @PathVariable("id")long id) {

        return repositoryMap.findComponent(component, id);
    }
}
