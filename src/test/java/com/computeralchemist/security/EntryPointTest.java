package com.computeralchemist.security;

import org.junit.Test;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * @Author
 * Karol Meksuła
 * 28-03-2018
 * */

public class EntryPointTest {
    private EntryPoint entryPoint = mock(EntryPoint.class);

    @Test
    public void entryPointShouldInstantiateCorrectly() {
        assertTrue(entryPoint instanceof AuthenticationEntryPoint);
    }

    @Test
    public void commenceTest() throws IOException, ServletException {

    }

}