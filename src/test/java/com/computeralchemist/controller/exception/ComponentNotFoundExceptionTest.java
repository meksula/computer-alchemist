package com.computeralchemist.controller.exception;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 02-04-2018
 * */

public class ComponentNotFoundExceptionTest {
    private ComponentNotFoundException exception;
    private final long COMP_ID = 35234234;

    @Before
    public void setUp() {
        exception = new ComponentNotFoundException(COMP_ID);
    }

    @Test
    public void shouldBeInstanceOfRuntimeException() {
        assertTrue(exception instanceof RuntimeException);
    }

    @Test
    public void shouldReturnEquivalent() {
        assertEquals(COMP_ID, exception.getComponentId());
    }
}