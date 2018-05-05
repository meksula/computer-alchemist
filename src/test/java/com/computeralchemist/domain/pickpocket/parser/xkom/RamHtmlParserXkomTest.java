package com.computeralchemist.domain.pickpocket.parser.xkom;

import com.computeralchemist.domain.components.ram.Ram;
import com.computeralchemist.domain.components.ram.RamParameters;
import com.computeralchemist.domain.pickpocket.parser.AbstractHtmlParser;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

public class RamHtmlParserXkomTest {
    private static AbstractHtmlParser parser;
    private static Ram ram;
    private static RamParameters parameters;

    private static String LINK = "https://www.x-kom.pl/p/254686-pamiec-ram-ddr4-hyperx-16gb-2400mhz-fury-black-cl15-2x8gb.html";

    private final String PRODUCENT = "HyperX";
    private final String MODEL = "16GB 2400MHz Fury Black CL15 (2x8GB)";
    private final int MODULES = 2;
    private final String MEMORY_TYPE = "DDR4";
    private final String COOLER = "Chłodzenie Heatspreader";
    private final double CAPACITY = 16;
    private final double FREQUENCY = 2400;

    @BeforeClass
    public static void setUp() {
        parser = new RamHtmlParserXkom();
        parser.parseHtmlToObject(LINK);
        ram = (Ram) parser.getComputerComponent();
        parameters = ram.getRamParameters();
    }

    @Test
    public void setProducentTest() {
        assertEquals(PRODUCENT, ram.getProducent());
    }

    @Test
    public void setModelTest() {
        assertEquals(MODEL, ram.getModel());
    }

    @Test
    public void setModulesTest() {
        assertEquals(MODULES, parameters.getModules());
    }

    @Test
    public void setMemoryType() {
        assertEquals(MEMORY_TYPE, parameters.getMemoryType());
    }

    @Test
    public void setCoolerTest() {
        assertEquals(COOLER, parameters.getCooler());
    }

    @Test
    public void setCapacityTest() {
        assertEquals(CAPACITY, parameters.getCapacityGb(), 1e-15);
    }

    @Test
    public void setFrequencyTest() {
        assertEquals(FREQUENCY, parameters.getFrequency(), 1e-15);
    }

    @Test
    public void setDescriptionTest() {
        assertTrue(ram.getDescription().length() > 0);
    }

}