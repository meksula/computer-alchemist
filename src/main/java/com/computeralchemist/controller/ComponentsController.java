package com.computeralchemist.controller;

import com.computeralchemist.domain.components.Motherboard;
import com.computeralchemist.repository.components.MotherboardRepository;
import com.computeralchemist.repository.others.MongoIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author
 * Karol Meksuła
 * 30-03-2018
 * */

@RestController
@RequestMapping("/components")
public class ComponentsController {
    private MotherboardRepository motherboardRepository;
    private MongoIterator mongoIterator;

    @Autowired
    public void setMotherboardRepository(MotherboardRepository motherboardRepository,
                                         MongoIterator mongoIterator) {
        this.motherboardRepository = motherboardRepository;
        this.mongoIterator = mongoIterator;
    }

    @PostMapping(produces = "application/json; charset=utf-8")
    public Motherboard postMotherboard(@RequestBody Motherboard motherboard) {
        motherboard.setProductId(mongoIterator.getId());
        motherboardRepository.save(motherboard);
        return motherboardRepository.findByModel(motherboard.getModel());
    }

    @GetMapping(value = "/{model}", produces = "application/json; charset=utf-8")
    public Motherboard getMotherboard(@PathVariable("model")String model) {
        return motherboardRepository.findByModel(model);
    }
}
