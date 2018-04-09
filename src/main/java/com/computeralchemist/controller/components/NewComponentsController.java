package com.computeralchemist.controller.components;

import com.computeralchemist.controller.RepositoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @Author
 * Karol Meksuła
 * 06-04-2018
 * */

@RestController
@RequestMapping("/components")
public class NewComponentsController {
    private RepositoryMapper repositoryMap;

    @Autowired
    public void setRepositoryMap(RepositoryMapper repositoryMap) {
        this.repositoryMap = repositoryMap;
    }

    @PostMapping(consumes = "application/json; charset=UTF-8", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public String addNewComponent(@RequestBody String json) {
        repositoryMap.saveComponent(json);
        return repositoryMap.getPathToLastAddedComponent();
    }
}
