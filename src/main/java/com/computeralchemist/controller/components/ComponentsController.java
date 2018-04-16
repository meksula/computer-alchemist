package com.computeralchemist.controller.components;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.repository.RepositoryProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/components/{component}/{id}")
public class ComponentsController {
    private RepositoryProviderImpl repositoryProvider;

    @Autowired
    public void setRepositoryMap(RepositoryProviderImpl repositoryProvider) {
        this.repositoryProvider = repositoryProvider;
    }

    @GetMapping(produces = "application/json; charset:UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public ComputerComponent getComponent(@PathVariable("component")String component,
                                          @PathVariable("id")long id) {

        return repositoryProvider.findComponent(component, id);
    }
}
