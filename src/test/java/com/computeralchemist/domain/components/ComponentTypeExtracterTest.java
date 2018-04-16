package com.computeralchemist.domain.components;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 15-04-2018
 * */

@Slf4j
public class ComponentTypeExtracterTest {
    private final String JSON = "{\"componentType\":\"cpu\",\"producent\":\"Intel\",\"model\":\"Celeron G3900\",\"description\":\"Dwa wydajne rdzenie fizyczne! Dedykowany do zestawów biurowych!\",\"urlToResource\":null,\"compatibleIndex\":4.0,\"votes\":0,\"productId\":2,\"cpuParameters\":{\"cores\":2,\"series\":\"Celeron\",\"socket\":\"1151\",\"threads\":2,\"bitArchitecture\":\"64bit\",\"cache\":2,\"frequency\":2.8}}";
    private ComponentTypeExtracter extracter = ComponentTypeExtracter.getInstance();
    private String EXPECTED_TYPE = "cpu";

    @Test
    public void shouldExtractTypeFromJSON() {
        String type = extracter.extractTypeFromJson(JSON);
        assertEquals(EXPECTED_TYPE, ComponentType.valueOf(type).toString());
    }

    @Test
    public void shouldExtractComputerSetTypeFromJSON() {
        String type = extracter.extractComputerTypeFromJson(JSON);
        assertEquals(EXPECTED_TYPE, type);
        log.info(type);
    }
}