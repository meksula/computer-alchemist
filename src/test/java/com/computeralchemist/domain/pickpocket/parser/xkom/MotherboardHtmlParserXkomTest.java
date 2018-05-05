package com.computeralchemist.domain.pickpocket.parser.xkom;

import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.domain.components.motherboard.MotherboardParameters;
import com.computeralchemist.domain.pickpocket.parser.AbstractHtmlParser;
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

@Slf4j
public class MotherboardHtmlParserXkomTest {
    private static AbstractHtmlParser parser;
    private static Motherboard motherboard;
    private static MotherboardParameters parameters;

    private final static String MOBO_URL = "https://www.x-kom.pl/p/393638-plyta-glowna-socket-1151-gigabyte-z370p-d3.html";

    private final String PRODUCENT = "Gigabyte";
    private final String MODEL = "Z370P D3";
    private final String TYPE = "ATX";
    private final String CHIPSET = "Intel Z370";
    private final String SOCKET = "1151";
    private final int RAM_SOCKETS = 4;
    private final String MEMORY_TYPE = "DDR4";
    private final double MEMORY_FREQUENCY = 4000;
    private final int PROCESORS_AVAILABLE_SIZE = 3;
    private final int OTHER_SOCKETS_SIZE = 14;

    @BeforeClass
    public static void setUp() {
        parser = new MotherboardHtmlParserXkom();
        parser.parseHtmlToObject(MOBO_URL);
        motherboard = (Motherboard) parser.getComputerComponent();
        parameters = motherboard.getMotherboardParameters();
    }

    @Test
    public void setProducentTest() {
        assertEquals(PRODUCENT, motherboard.getProducent());
    }

    @Test
    public void setModelTest() {
        assertEquals(MODEL, motherboard.getModel());
    }

    @Test
    public void setDescriptionTest() {
        assertTrue(motherboard.getDescription().length() > 0);
    }

    @Test
    public void setTypeTest() {
        assertEquals(TYPE, parameters.getType());
    }

    @Test
    public void setChipset() {
        assertEquals(CHIPSET, parameters.getChipset());
    }

    @Test
    public void setSocket() {
        assertTrue(parameters.getSocket().contains(SOCKET));
    }

    @Test
    public void setRamSocketsTest() {
        assertEquals(RAM_SOCKETS, parameters.getRamSockets());
    }

    @Test
    public void setMemoryTypeTest() {
        assertEquals(MEMORY_TYPE, parameters.getMemoryType());
    }

    @Test
    public void setMemoryFrequencyTest() {
        assertEquals(MEMORY_FREQUENCY, parameters.getMemoryFrequency(), 1e-15);
    }

    @Test
    public void setProcessorsAvailableTest() {
        assertEquals(PROCESORS_AVAILABLE_SIZE, parameters.getProcesorAvailables().size());
    }

    @Test
    public void setOthersocketsTest() {
        assertEquals(OTHER_SOCKETS_SIZE, parameters.getOtherSockets().size());
    }
}