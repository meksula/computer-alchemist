package com.computeralchemist.controller.components;

import com.computeralchemist.domain.components.OpinionDto;
import com.computeralchemist.repository.opinions.OpinionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author
 * Karol Meksuła
 * 10-05-2018
 * */

@RestController
@RequestMapping("/opinion")
public class OpinionsController {
    private OpinionRepository opinionRepository;

    @Autowired
    public void setOpinionRepository(OpinionRepository opinionRepository) {
        this.opinionRepository = opinionRepository;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getOpinion(@PathVariable("id") long id) {
        OpinionDto opinionDto = opinionRepository.findByOpinionId(id);
        return new ResponseEntity<>(opinionDto, HttpStatus.OK);
    }

}
