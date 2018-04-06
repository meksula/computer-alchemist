package com.computeralchemist.controller;

import com.computeralchemist.config.RootConfig;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.repository.components.ComponentRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class RepositoryMapTest {
    private final long ID = 0;
    private final String REPO_NAME = "motherboard";
    private final Logger logger = LogManager.getLogger(RepositoryMapTest.class);

    @Autowired
    private RepositoryMap repositoryMap;

    @Test
    public void shouldReturnMotherboard() {
        ComponentRepository componentRepository = repositoryMap.findComponent(REPO_NAME, ID);
        assertNotNull(componentRepository);

        Motherboard motherboard = (Motherboard) componentRepository.findByProductId(ID);
        assertNotNull(motherboard);
        assertEquals("MSI", motherboard.getProducent());
    }
}