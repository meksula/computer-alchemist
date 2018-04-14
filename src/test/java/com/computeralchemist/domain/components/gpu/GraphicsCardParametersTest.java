package com.computeralchemist.domain.components.gpu;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 08-04-2018
 * */

public class GraphicsCardParametersTest {
    private GraphicsCardParameters parameters;
    private final String CHIPSET = "Nvidia GTX 1060 ti";
    private final int MEMORY = 6;
    private final String MEMORY_TYPE = "GDDR5";
    private final String MAIN_CONNECTOR_TYPE = "PCI Express x16";
    private final double CLOCK_FREQUENCY = 1594;
    private final String COOLER = "2x wentylator\n" + "Heat-Pipe\n" + "Radiator";
    private final double LENGHT = 789;
    private final String RESOLUTION = "7953x3552";

    private List<String> provideStandardsList() {
        List<String> list = new ArrayList<>();
        list.add("DirectX 12");
        list.add("OpenGL 4.5");
        return list;
    }

    private List<String> provideConnectorsList() {
        List<String> list = new ArrayList<>();
        list.add("1x DVI-D");
        list.add("1x HDMI");
        list.add("3x DisplayPort");
        return list;
    }

    @Before
    public void setUp() {
        parameters = new GraphicsCardParameters();
        parameters.setChipset(CHIPSET);
        parameters.setMemory(MEMORY);
        parameters.setMemoryType(MEMORY_TYPE);
        parameters.setMainConnectorType(MAIN_CONNECTOR_TYPE);
        parameters.setClockFrequency(CLOCK_FREQUENCY);
        parameters.setCooler(COOLER);
        parameters.setLength(LENGHT);
        parameters.setResolution(RESOLUTION);
        parameters.setConnectors(provideConnectorsList());
        parameters.setStandards(provideStandardsList());
    }

    @Test
    public void instantiateTest() {
        assertEquals(CHIPSET, parameters.getChipset());
        assertEquals(MEMORY, parameters.getMemory());
        assertEquals(MEMORY_TYPE, parameters.getMemoryType());
        assertEquals(MAIN_CONNECTOR_TYPE, parameters.getMainConnectorType());
        assertEquals(CLOCK_FREQUENCY, parameters.getClockFrequency(), 1e-15);
        assertEquals(COOLER, parameters.getCooler());
        assertEquals(LENGHT, parameters.getLength(), 1e-15);
        assertEquals(RESOLUTION, parameters.getResolution());
        assertEquals(2, parameters.getStandards().size());
        assertEquals(3, parameters.getConnectors().size());
    }
}