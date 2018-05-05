package com.computeralchemist.domain.pickpocket.core;

import com.computeralchemist.controller.exception.BadComponentTypeException;
import com.computeralchemist.controller.pickpocket.PickpocketController;
import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.pickpocket.exception.AddressNotSupportedException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
    private PickpocketCommandImpl pickpocketCommand;

    private final String URL = "https://www.x-kom.pl/p/317002-karta-graficzna-nvidia-msi-geforce-gtx-1060-gaming-x-6gb-gddr5.html";
    private final String INVALID_URL = "ht3tps://www.pl/p/317002-karta-graficzna-nvidia-msi-geforce-gtx-1060-gaming-x-6gb-gddr5.html";
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

    @Test(expected = AddressNotSupportedException.class)
    public void shouldThrowException_badUrl() {
        pickpocketCommand.executeUrl(INVALID_URL, TYPE);
    }

    @Test
    public void shouldReturnCompueterComponentCorrectly() {
        ComputerComponent computerComponent = pickpocketCommand.executeUrl(URL, TYPE);
        assertNotNull(computerComponent);
    }

    @Test
    public void shouldInitializeFactoryCorrectly() throws NoSuchFieldException, IllegalAccessException {
        pickpocketCommand.executeUrl(URL, TYPE);

        Class<?> pickpocket = pickpocketCommand.getClass();
        Field field = pickpocket.getDeclaredField("parserFactory");
        field.setAccessible(true);

        assertNotNull(field.get(pickpocketCommand));
    }

    private final String JSON_URL = "{\"url\":\"https://www.x-kom.pl/p/337463-karta-graficzna-nvidia-asus-geforce-gtx-1050-phoenix-2gb-gddr5.html\"}";
    private final String EXTRACTED_URL = "https://www.x-kom.pl/p/337463-karta-graficzna-nvidia-asus-geforce-gtx-1050-phoenix-2gb-gddr5.html";

    @Test
    public void regexTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> pickpocketObject = pickpocketCommand.getClass();
        Method extractUrlFromString = pickpocketObject.getDeclaredMethod("extractUrlFromString", String.class);
        extractUrlFromString.setAccessible(true);

        String extracted = (String) extractUrlFromString.invoke(pickpocketCommand, JSON_URL);

        assertEquals(EXTRACTED_URL, extracted);
    }
}