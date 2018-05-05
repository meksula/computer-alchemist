package com.computeralchemist.domain.pickpocket.parser.xkom;

import com.computeralchemist.domain.components.computerCase.ComputerCase;
import com.computeralchemist.domain.components.computerCase.ComputerCaseParameters;
import com.computeralchemist.domain.pickpocket.parser.AbstractHtmlParser;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 04-05-2018
 * */

public class ComputerCaseHtmlParserXkomTest {
    private static AbstractHtmlParser parser;
    private static ComputerCase computerCase;
    private static ComputerCaseParameters parameters;

    private static final String LINK = "https://www.x-kom.pl/p/381994-obudowa-do-komputera-silentiumpc-regnum-rg4tf-frosty-white.html";

    private final double DELTA = 1e15;
    private final String PRODUCENT = "SilentiumPC";
    private final String MODEL = "Regnum RG4TF Frosty White";
    private final String TYPE = "Middle Tower";
    private final double HEIGHT = 496;
    private final double WIDTH = 205;
    private final double WEIGHT = 5;
    private final int MOBO_LIST_SIZE = 3;
    private final int CONNECTORS_SIZE = 4;

    @BeforeClass
    public static void setUp() {
        parser = new ComputerCaseHtmlParserXkom();
        parser.parseHtmlToObject(LINK);
        computerCase = (ComputerCase) parser.getComputerComponent();
        parameters = computerCase.getComputerCaseParameters();
    }

    @Test
    public void setProducentTest() {
        assertEquals(PRODUCENT, computerCase.getProducent());
    }

    @Test
    public void setModelTest() {
        assertEquals(MODEL, computerCase.getModel());
    }

    @Test
    public void setDescriptionTest() {
        assertTrue(computerCase.getDescription().length() > 0);
    }

    @Test
    public void setTypeTest() {
        assertEquals(TYPE, parameters.getType());
    }

    @Test
    public void setHeightTest() {
        assertEquals(HEIGHT, parameters.getHeight(), DELTA);
    }

    @Test
    public void setWidthTest() {
        assertEquals(WIDTH, parameters.getWidth(), DELTA);
    }

    @Test
    public void setWeightTest() {
        assertEquals(WEIGHT, parameters.getWeight(), DELTA);
    }

    @Test
    public void setMotherboardsAvailableTest() {
        assertEquals(MOBO_LIST_SIZE, parameters.getCompatibilityMotherboards().size());
    }

    @Test
    public void setConnectorsTest() {
        assertEquals(CONNECTORS_SIZE, parameters.getConnectors().size());
    }

}