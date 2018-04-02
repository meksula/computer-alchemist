package com.computeralchemist.config;

import org.junit.Test;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 02-04-2018
 * */

public class SecurityInitializerTest {
    private SecurityInitializer securityInitializer = new SecurityInitializer();

    @Test
    public void shouldBeInstanceOf() {
        assertTrue(securityInitializer instanceof AbstractSecurityWebApplicationInitializer);
    }

}