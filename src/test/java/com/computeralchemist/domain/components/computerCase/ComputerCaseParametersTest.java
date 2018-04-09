package com.computeralchemist.domain.components.computerCase;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.List.*;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 09-04-2018
 * */

public class ComputerCaseParametersTest {
    private ComputerCaseParameters parameters;
    private final String TYPE = "Midi Tower";
    private final double HEIGHT = 123.1;
    private final double WEIGHT = 4;
    private final double WIDTH = 32;
    private final String[] motherboards = {"ATX", "micro ATX"};
    private final String[] connectors = {"USB 2.0 x4", "USB 3.0 x2", "mic", "phones"};
    private final double DELTA = 1e-15;

    @Before
    public void setUp() {
        parameters = new ComputerCaseParameters();
        parameters.setType(TYPE);
        parameters.setHeight(HEIGHT);
        parameters.setWeight(WEIGHT);
        parameters.setWidth(WIDTH);
        parameters.setCompatibilityMotherboards(Arrays.asList(motherboards));
        parameters.setConnectors(Arrays.asList(connectors));
    }

    @Test
    public void instantiateTest() {
        assertEquals(TYPE, parameters.getType());
        assertEquals(HEIGHT, parameters.getHeight(), DELTA);
        assertEquals(WEIGHT, parameters.getWeight(), DELTA);
        assertEquals(motherboards.length, parameters.getCompatibilityMotherboards().size());
        assertEquals(WIDTH, parameters.getWidth(), DELTA);
        assertEquals(connectors.length, parameters.getConnectors().size());
    }

}