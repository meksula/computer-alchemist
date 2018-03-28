package com.computeralchemist.config;

import org.junit.Test;

import javax.servlet.Filter;

import static junit.framework.TestCase.assertEquals;

/**
 * @Author
 * Karol Meksuła
 * 27-03-2018
 * */

public class WebInitializerTest {
    private WebInitializer webInitializer = new WebInitializer();

    @Test
    public void rootConfigClassTest() {
        Class<?>[] root = webInitializer.getRootConfigClasses();
        assertEquals("com.computeralchemist.config.RootConfig", root[0].getName());
    }

    @Test
    public void servletConfigClassesTest() {
        Class<?>[] classes = webInitializer.getServletConfigClasses();
        assertEquals("com.computeralchemist.config.WebServletConfig", classes[0].getName());
    }

    @Test
    public void servletMappingsTest() {
        String [] map = webInitializer.getServletMappings();
        assertEquals("/", map[0]);
    }

    @Test
    public void utf8FilterShouldInit() {
        Filter[] filters = webInitializer.getServletFilters();
        assertEquals("org.springframework.web.filter.CharacterEncodingFilter", filters[0].getClass().getName());
    }

}
