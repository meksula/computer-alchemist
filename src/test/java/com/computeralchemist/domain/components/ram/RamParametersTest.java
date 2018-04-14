package com.computeralchemist.domain.components.ram;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 05-04-2018
 * */

public class RamParametersTest {
    private RamParameters ramParameters = new RamParameters();

    private final String MEMORY_TYPE = "DDR4";
    private final String COOLER = "Aluminiowy radiator, złocone styki";
    private final int MODULES = 2;
    private final int CAPACITY_GB = 8;
    private final double FREQUENCY = 2400;
    private final String SOCKET_TYPE = "UDIMM";

    @Before
    public void setUp() {
        ramParameters.setMemoryType(MEMORY_TYPE);
        ramParameters.setCooler(COOLER);
        ramParameters.setModules(MODULES);
        ramParameters.setCapacityGb(CAPACITY_GB);
        ramParameters.setFrequency(FREQUENCY);
        ramParameters.setSocketType(SOCKET_TYPE);
    }

    @Test
    public void setParametersTest() {
        assertEquals(MEMORY_TYPE, ramParameters.getMemoryType());
        assertEquals(COOLER, ramParameters.getCooler());
        assertEquals(MODULES, ramParameters.getModules());
        assertEquals(CAPACITY_GB, ramParameters.getCapacityGb());
        assertEquals(FREQUENCY, ramParameters.getFrequency(), 1e-15);
        assertEquals(SOCKET_TYPE, ramParameters.getSocketType());
    }
}