package com.computeralchemist.repository.others;

import com.computeralchemist.config.RootConfig;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.repository.components.MotherboardRepository;
import org.junit.After;
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
public class MongoIncrementTest {

    @Autowired
    private MongoIncrement mongoIncrement;

    @Autowired
    private MotherboardRepository motherboardRepository;

    @Test
    public void instantiateTest() {
        assertNotNull(mongoIncrement);
    }

    @Test
    public void sutShouldAssignNextLongNumberMotherboards() {
        long id = mongoIncrement.assignMotherboardId();
        long id_expected = motherboardRepository.count();

        assertEquals(id, id_expected + 1);
    }

}