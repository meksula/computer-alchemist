package com.computeralchemist.security;

import org.junit.Test;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 28-03-2018
 * */

public class AuthenticationSuccessHandlerTest {
    private AuthenticationSuccessHandlerImpl authenticationSuccessHandler = new AuthenticationSuccessHandlerImpl();

    @Test
    public void authenticationSuccessHandlerShouldInstantiateCorrectly() {
        assertTrue(authenticationSuccessHandler instanceof AuthenticationSuccessHandler);
    }

    @Test
    public void shouldHaveRequestCache() throws NoSuchFieldException {
        Class<?> handler = authenticationSuccessHandler.getClass();
        Field field = handler.getDeclaredField("requestCache");
        field.setAccessible(true);
        assertNotNull(field);
    }

}