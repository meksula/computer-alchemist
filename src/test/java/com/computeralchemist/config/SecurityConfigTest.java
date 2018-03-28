package com.computeralchemist.config;

import org.junit.Test;

import java.lang.annotation.Annotation;

import static junit.framework.TestCase.assertTrue;

/**
 * @Author
 * Karol Meksuła
 * 28-03-2018
 * */

public class SecurityConfigTest {
    private SecurityConfig securityConfig = new SecurityConfig();

    @Test
    public void securityConfigShouldInstantiateCorrectly() {
        Annotation[] interfaces = securityConfig.getClass().getAnnotations();

        assertTrue(interfaces[0].toString().contains("Configuration"));
        assertTrue(interfaces[1].toString().contains("EnableWebSecurity"));
        assertTrue(interfaces[2].toString().contains("ComponentScan"));
    }

}