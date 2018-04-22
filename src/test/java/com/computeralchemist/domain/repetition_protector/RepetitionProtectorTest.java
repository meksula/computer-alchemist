package com.computeralchemist.domain.repetition_protector;

import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.components.cpu.Cpu;
import com.computeralchemist.repository.RepositoryProvider;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 22-04-2018
 * */

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class RepetitionProtectorTest {

    @Autowired
    private RepetitionProtector protector;

    @Autowired
    private RepositoryProvider repositoryProvider;

    private Cpu cpu = new Cpu();
    private final String PRODUCENT = "Intel";
    private final String MODEL = "core i3";

    @Before
    public void setUp() {
        cpu.setProducent(PRODUCENT);
        cpu.setModel(MODEL);
        cpu.setComponentType(ComponentType.cpu);
    }

    @Test
    public void injectionTest() {
        assertNotNull(protector);
    }

    @Test
    public void protectorShouldReturnFalse() {
        boolean flag = protector.isComponentExist(cpu);
        assertFalse(flag);
    }

    @Test
    public void protectorShouldReturnTrue() {
        saveToDatabase();

        boolean flag = protector.isComponentExist(cpu);
        assertTrue(flag);
    }

    private void saveToDatabase() {
        long id = repositoryProvider.saveComponent(cpu);
        log.info(String.valueOf(id));
    }
}