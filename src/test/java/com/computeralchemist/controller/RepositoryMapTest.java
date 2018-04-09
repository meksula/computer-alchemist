package com.computeralchemist.controller;

import com.computeralchemist.config.RootConfig;
import com.computeralchemist.domain.components.cpu.Cpu;
import com.computeralchemist.domain.components.exceptions.RepositoryMapperException;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.domain.components.ram.Ram;
import com.computeralchemist.repository.components.ComponentRepository;
import com.computeralchemist.repository.components.cpu.CpuRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 05-04-2018
 * */

//TODO poprawić to razem z repozytoriami, ma być embedded DB, bo jebie bazę produkcyjną!!!!
    //todo po przeniesieniu na Boota zrobić embeded i potem to poprawić...

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class RepositoryMapTest {

    @Autowired
    private RepositoryMapper repositoryMapper;

    @Autowired
    private CpuRepository cpuRepository;

    @Test
    public void singletonInjectTest() {
        assertNotNull(repositoryMapper);
        assertNotNull(cpuRepository);
    }

    private final String INVALID_COMPONENT_TYPE = "cpufg";
    private final String CPU_JSON = "{\"producent\":\"Intel\", \"model\":\"8th gen i7\"}";

    @Ignore
    @Test(expected = RepositoryMapperException.class)
    public void saveComponentTest() throws IOException {
        repositoryMapper.saveComponent(CPU_JSON);
    }

    private final String VALID_COMPONENT_TYPE = "cpu";
    private long id;

    @Ignore
    @Test
    public void saveComponentValidTest() throws RepositoryMapperException {
        repositoryMapper.saveComponent(CPU_JSON);
        id = cpuRepository.count();
        Cpu cpu = cpuRepository.findByProductId(id);

        assertNotNull(cpu);
    }

    @Ignore
    @Test
    public void findComponentTest() throws RepositoryMapperException {
        repositoryMapper.saveComponent(CPU_JSON);
        id = cpuRepository.count();

        Cpu cpu = (Cpu) repositoryMapper.findComponent("cpu", id);
        assertNotNull(cpu);
    }

    @After
    public void cleanUp() {
        cpuRepository.deleteByProductId(id);
    }
}