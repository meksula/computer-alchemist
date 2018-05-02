package com.computeralchemist.domain.pickpocket.core;

import com.computeralchemist.controller.exception.BadComponentTypeException;
import com.computeralchemist.controller.exception.CannotReadUrlException;
import com.computeralchemist.domain.components.ComputerComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

@SpringBootTest
@RunWith(SpringRunner.class)
public class PickpocketCommandImplTest {

    @Autowired
    private PickpocketCommand pickpocketCommand;

    private final String URL = "https://www.x-kom.pl/p/317002-karta-graficzna-nvidia-msi-geforce-gtx-1060-gaming-x-6gb-gddr5.html";
    private final String INVALID_URL = "ht3tps://www.x-kom.pl/p/317002-karta-graficzna-nvidia-msi-geforce-gtx-1060-gaming-x-6gb-gddr5.html";
    private final String TYPE = "gpu";
    private final String INVALID_TYPE = "dffwe";

    @Test
    public void computerComponentShouldWorkWithCorrectly() {
        pickpocketCommand.executeUrl(URL, TYPE);
    }

    @Test(expected = BadComponentTypeException.class)
    public void shouldThrowException() {
        pickpocketCommand.executeUrl(URL, INVALID_TYPE);
    }

    @Test(expected = CannotReadUrlException.class)
    public void shouldThrowException_badUrl() {
        pickpocketCommand.executeUrl(INVALID_URL, TYPE);
    }

    @Test
    public void shouldReturnCompueterComponentCorrectly() {
        ComputerComponent computerComponent = pickpocketCommand.executeUrl(URL, TYPE);
        assertNotNull(computerComponent);
    }
}