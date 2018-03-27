package com.computeralchemist.config;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @Author
 * Karol Meksuła
 * 27-03-2018
 * */

public class WebInitializerTest {
    private WebInitializer webInitializer = new WebInitializer();

    @Test
    public void servletMappingsTest() {
        String [] map = webInitializer.getServletMappings();
        assertEquals("/", map[0]);
    }
}
