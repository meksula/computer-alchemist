package com.computeralchemist.security;

import org.junit.Test;
import org.springframework.security.web.AuthenticationEntryPoint;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 28-03-2018
 * */

public class EntryPointTest {
    private EntryPoint entryPoint = new EntryPoint();

    @Test
    public void entryPointShouldInstantiateCorrectly() {
        assertTrue(entryPoint instanceof AuthenticationEntryPoint);
    }
}