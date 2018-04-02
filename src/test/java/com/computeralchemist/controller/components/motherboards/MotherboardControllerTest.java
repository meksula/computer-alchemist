package com.computeralchemist.controller.components.motherboards;

import com.computeralchemist.config.RootConfig;
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
public class MotherboardControllerTest {
    private final long ID = 100;

    @Autowired
    private MotherboardController motherboardController;

    @Test
    public void injectCorrectly() {
        assertNotNull(motherboardController);
    }

    @Test
    public void deleteMethodTest() {
        motherboardController.deleteComponent(ID);
    }

}