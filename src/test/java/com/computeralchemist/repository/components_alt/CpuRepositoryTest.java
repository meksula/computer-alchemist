package com.computeralchemist.repository.components_alt;

import com.computeralchemist.controller.exception.ComponentNotFoundException;
import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.components.cpu.Cpu;
import com.computeralchemist.repository.components.cpu.CpuRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CpuRepositoryTest {

    /*@Autowired
    private CpuRepository cpuRepository;

    @Autowired
    private ComponentRepositoryFacade facade;

    @Test
    public void checkIfRepositoryWorkCorrectly() {
        Cpu cpu = new Cpu();
        cpu.setComponentType(ComponentType.cpu);
        cpu.setProducent("Intel");
        cpu.setModel("i7");
        cpu.setProductId(101);

        cpuRepository.insert(cpu);

        Optional<Cpu> cpu1 = cpuRepository.findByProductId(101L);
        assertEquals("Intel", cpu1.get().getProducent());

        Optional<Cpu> cpu2 = cpuRepository.findByProductId(200L);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        cpu2.ifPresent(e -> atomicBoolean.set(true));
        assertFalse(atomicBoolean.get());
    }

    @Test(expected = ComponentNotFoundException.class)
    public void facadeTest() {
        ComputerComponent cpuOptional = facade.findComponentById("cpu", 30L);
        assertNull(cpuOptional);
    }*/
}