package com.computeralchemist.controller.components;

import com.computeralchemist.domain.components.ComponentTypeExtracter;
import com.computeralchemist.domain.components.ComputerComponent;
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
    private RepositoryProvider repositoryProvider;

    @Autowired
    public void setRepositoryMap(RepositoryProvider repositoryProvider) {
        this.repositoryProvider = repositoryProvider;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addNewComponent(@RequestBody String json) {
        ComponentTypeExtracter.getInstance().extractTypeFromJson(json);
        ComputerComponent computerComponent = repositoryProvider.saveComponent(json);

        return ResponseEntity.created(buildUri(computerComponent.getComponentType().toString(), computerComponent.getProductId()))
                .build();
    }

    private URI buildUri(String componentType, long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{componentType}").path("/{id}")
                .buildAndExpand(componentType, id)
                .toUri();
    }

}
