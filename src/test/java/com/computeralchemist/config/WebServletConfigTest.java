package com.computeralchemist.config;

import org.junit.Test;

import java.lang.annotation.Annotation;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * @Author
 * Karol Meksuła
 * 27-03-2018
 * */

public class WebServletConfigTest {
    private WebServletConfig webServletConfig = new WebServletConfig();

    @Test
    public void webServletConfigInstantiateCorrectly() {
        Annotation[] interfaces = webServletConfig.getClass().getAnnotations();
        assertEquals(3, interfaces.length);

        assertTrue(interfaces[0].toString().contains("Configuration"));
        assertTrue(interfaces[1].toString().contains("EnableWebMvc"));
        assertTrue(interfaces[2].toString().contains("ComponentScan"));
    }
}