package com.computeralchemist.controller.components;

import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.ComponentTypeExtracter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 08-04-2018
 * */

public class ComponentTypeExtracterTest {
    private final String JSON_COMP = "{\"producent\":\"Adata\",\"model\":\"SU800\",\"description\":\"Dysk półprzewodnikowy SU800 zasługuje na swoją totalną nazwę Ultimate dzięki pamięci Flash NAND 3D, która zapewnia większą gęstość zapisu, wydajność oraz niezawodność niż tradycyjna pamięć NAND 2D.\",\"urlToResource\":null,\"compatibiltyIndex\":10.0,\"componentType\":\"disk\",\"productId\":1,\"diskParameters\":{\"type\":\"SSD\",\"format\":\"2,5\",\"capacity\":256,\"readSpeed\":560.0,\"writeSpeed\":520.0}}";
    private final Logger logger = LogManager.getLogger(ComponentTypeExtracterTest.class);

    private ComponentTypeExtracter extracter = ComponentTypeExtracter.getInstance();

    @Test
    public void instantiateTest() {
        assertNotNull(extracter);
    }

    @Test
    public void extractingTest() {
        String type = extracter.extractTypeFromJson(JSON_COMP);
        assertEquals("disk", type);
    }

    @Test
    public void conditionTest() {
        String type = extracter.extractTypeFromJson(JSON_COMP);
        ComponentType componentType = ComponentType.valueOf(type);
        logger.info(componentType);
    }

    @Test(expected = IllegalArgumentException.class)
    public void expectNoEnumConstant() {
        ComponentType componentType = ComponentType.valueOf("DFEX");
    }
}