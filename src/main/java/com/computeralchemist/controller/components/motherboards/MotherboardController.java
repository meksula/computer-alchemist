package com.computeralchemist.controller.components.motherboards;

import com.computeralchemist.controller.exception.ComponentNotFoundException;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.repository.components.MotherboardRepository;
import com.computeralchemist.repository.others.MongoIncrement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * @Author
 * Karol Meksuła
 * 30-03-2018
 * */

@RestController
@RequestMapping("/components/motherboards")
public class MotherboardController {
    private MotherboardRepository motherboardRepository;
    private MongoIncrement mongoIncrement;

    @Autowired
    public void setMotherboardRepository(MotherboardRepository motherboardRepository,
                                         MongoIncrement mongoIncrement) {
        this.motherboardRepository = motherboardRepository;
        this.mongoIncrement = mongoIncrement;
    }

    @PostMapping(produces = "application/json; charset=utf-8")
    public ResponseEntity<Motherboard> postMotherboard(@RequestBody Motherboard motherboard,
                                                       UriComponentsBuilder builder) {
        long id = mongoIncrement.assignMotherboardId();
        motherboard.setProductId(id);
        Motherboard justSaved = motherboardRepository.save(motherboard);

        return new ResponseEntity<>(justSaved, createHeader(builder, id) ,HttpStatus.CREATED);
    }

    private HttpHeaders createHeader(UriComponentsBuilder builder, long id) {
        HttpHeaders header = new HttpHeaders();
        URI uri = builder.path("/components/motherboards/")
                .path(String.valueOf(id)).build().toUri();
        header.setLocation(uri);
        return header;
    }

    @GetMapping(value = "/{productId}", produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public Motherboard getMotherboard(@PathVariable("productId") long productId) {
        Motherboard component = motherboardRepository.findByProductId(productId);
        if (component == null)
            throw new ComponentNotFoundException(productId);

        return component;
    }

    @PostMapping(value = "/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteComponent(@PathVariable("productId") long productId) {
        motherboardRepository.deleteByProductId(productId);
    }
}
