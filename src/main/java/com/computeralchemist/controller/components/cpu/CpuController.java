package com.computeralchemist.controller.components.cpu;

import com.computeralchemist.controller.exception.ComponentNotFoundException;
import com.computeralchemist.domain.components.cpu.Cpu;
import com.computeralchemist.repository.components.CpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @Author
 * Karol Meksuła
 * 03-04-2018
 * */

@RestController
@RequestMapping("/components/cpu")
public class CpuController {

    private CpuRepository cpuRepository;

    @Autowired
    public void setCpuRepository(CpuRepository cpuRepository) {
        this.cpuRepository = cpuRepository;
    }

    @GetMapping(value = "/{productId}", produces = "application/json; charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Cpu getCpuByProductId(@PathVariable("productId")long productId) {
        Cpu cpu = cpuRepository.findByProductId(productId);

        if (cpu == null)
            throw new ComponentNotFoundException(productId);

        return cpu;
    }
}
