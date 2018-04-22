package com.computeralchemist.controller.components;

import com.computeralchemist.domain.components.ComponentTypeExtracter;
import com.computeralchemist.repository.RepositoryProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * @Author
 * Karol Meksuła
 * 06-04-2018
 * */

@RestController
@RequestMapping("/components")
public class NewComponentsController {
    private RepositoryProvider repositoryMap;

    @Autowired
    public void setRepositoryMap(RepositoryProvider repositoryMap) {
        this.repositoryMap = repositoryMap;
    }

    private long id;
    private String componentType;

    @PostMapping(consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addNewComponent(@RequestBody String json) {
        this.componentType = ComponentTypeExtracter.getInstance().extractTypeFromJson(json);
        this.id = repositoryMap.saveComponent(json);

        return ResponseEntity.created(buildUri()).build();
    }

    private URI buildUri() {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{componentType}").path("/{id}")
                .buildAndExpand(componentType, id)
                .toUri();
    }

}
