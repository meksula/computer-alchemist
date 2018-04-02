package com.computeralchemist.controller.exception;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 02-04-2018
 * */

public class ErrorTest {
    private Error error;
    private final long id = 44124234;
    private final String message = "Some error message...";

    @Before
    public void setUp() {
        error = new Error(id, message);
    }

    @Test
    public void shouldInstantiateCorrectly() {
        assertEquals(id, error.getCode());
        assertEquals(message, error.getMessage());
    }

}