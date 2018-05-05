package com.computeralchemist.domain.pickpocket.parser.xkom;

import com.computeralchemist.domain.components.supply.PowerSupply;
import com.computeralchemist.domain.components.supply.PowerSupplyParameters;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

public class SupplyHtmlParserXkomTest {
    private static SupplyHtmlParserXkom parser;
    private static PowerSupply powerSupply;
    private static PowerSupplyParameters parameters;

    private static final String LINK = "https://www.x-kom.pl/p/206809-zasilacz-do-komputera-corsair-vs650-650w-80plus-box.html";

    private final String PRODUCENT = "Corsair";
    private final String MODEL = "VS650 650W 80PLUS BOX";
    private final int POWER = 650;
    private final String STANDARD = "ATX";
    private final String PFC = "Aktywny";
    private final int CONNECTORS = 6;

    @BeforeClass
    public static void setUp() {
        parser = new SupplyHtmlParserXkom();
        parser.parseHtmlToObject(LINK);
        powerSupply = (PowerSupply) parser.getComputerComponent();
        parameters = powerSupply.getPowerSupplyParameters();
    }

    @Test
    public void setProducentTest() {
        assertEquals(PRODUCENT, powerSupply.getProducent());
    }

    @Test
    public void setModelTest() {
        assertEquals(MODEL, powerSupply.getModel());
    }

    @Test
    public void setDescriptionTest() {
        assertTrue(powerSupply.getDescription().length() > 0);
    }

    @Test
    public void setPowerTest() {
        assertEquals(POWER, parameters.getPower());
    }

    @Test
    public void setStandardTest() {
        assertEquals(STANDARD, parameters.getStandard());
    }

    @Test
    public void setPfcTest() {
        assertEquals(PFC, parameters.getPfc());
    }

    @Test
    public void setModularTest() {
        assertFalse(parameters.isModularCable());
    }

    @Test
    public void setConnectorTest() {
        assertEquals(CONNECTORS, parameters.getConnectors().size());
    }

}