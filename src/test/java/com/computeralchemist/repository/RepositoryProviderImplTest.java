package com.computeralchemist.repository;

import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.fasterxml.jackson.core.JsonProcessingException;
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

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class RepositoryProviderImplTest {

    @Autowired
    private RepositoryProvider repositoryProvider;

    private final String COMP_TYPE = "motherboard";
    private final String MODEL = "xtra 304";
    private final long ID = 1;

    private Motherboard mobo = new Motherboard();

    @Before
    public void setUp() {
        mobo.setComponentType(ComponentType.valueOf(COMP_TYPE));
        mobo.setModel(MODEL);
    }

    @Test
    public void saveComponentTest() {
        long id = repositoryProvider.saveComponent(mobo);
        assertEquals(ID, id);
    }

    @Test
    public void findComponentTest() {
        ComputerComponent component = repositoryProvider.findComponent(COMP_TYPE, ID);
        assertNotNull(component);
    }

    @Test
    public void findComponentByProductIdAndModelTest() throws JsonProcessingException {

    }

}