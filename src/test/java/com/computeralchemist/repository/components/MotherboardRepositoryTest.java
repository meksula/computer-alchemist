package com.computeralchemist.repository.components;

import com.computeralchemist.config.RootConfig;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 02-04-2018
 * */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class MotherboardRepositoryTest {
    private final long ID = 1;

    private Motherboard motherboard = new Motherboard();

    @Autowired
    private MotherboardRepository motherboardRepository;

    @Before
    public void setUp() {
        motherboard.setProductId(ID);
    }

    @Test
    public void singletonInjectedCorrectly() {
        assertNotNull(motherboardRepository);
    }

    @Test
    public void saveAndFindQueryTest() {
        motherboardRepository.save(motherboard);

        Motherboard motherboard = motherboardRepository.findByProductId(ID);
        assertEquals(ID, motherboard.getProductId());
    }

    @After
    public void cleanDatabase() {
        motherboardRepository.deleteByProductId(ID);
    }

}