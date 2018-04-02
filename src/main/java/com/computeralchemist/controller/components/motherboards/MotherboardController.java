package com.computeralchemist.controller.components.motherboards;

import com.computeralchemist.controller.exception.ComponentNotFoundException;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.repository.components.MotherboardRepository;
import com.computeralchemist.repository.others.MongoIncrement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public Motherboard postMotherboard(@RequestBody Motherboard motherboard) {
        long id = mongoIncrement.assignMotherboardId();
        motherboard.setProductId(id);
        motherboardRepository.save(motherboard);
        return motherboardRepository.findByModel(motherboard.getModel());
    }

    @GetMapping(value = "/{productId}", produces = "application/json; charset=utf-8")
    @ResponseStatus(value = HttpStatus.OK)
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
