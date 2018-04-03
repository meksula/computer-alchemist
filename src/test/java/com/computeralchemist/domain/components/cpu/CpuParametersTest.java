package com.computeralchemist.domain.components.cpu;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 03-04-2018
 * */

public class CpuParametersTest {
    private CpuParameters cpuParameters = new CpuParameters();

    private final int CORES = 4;
    private final String SERIES = "Core i3 (Coffee Lake)";
    private final String SOCKET = "1151 (Coffee Lake)";
    private final int THREADS = 4;
    private final String BIT_ARCHITECTURE = "64 bit";
    private final int CACHE = 8;
    private final double FREQUENCY = 4;

    @Before
    public void setUp() {
        cpuParameters.setCores(CORES);
        cpuParameters.setSeries(SERIES);
        cpuParameters.setSocket(SOCKET);
        cpuParameters.setThreads(THREADS);
        cpuParameters.setBitArchitecture(BIT_ARCHITECTURE);
        cpuParameters.setCache(CACHE);
        cpuParameters.setFrequency(FREQUENCY);
    }

    @Test
    public void sutShouldHasPredefinedValues() {
        assertEquals(CORES, cpuParameters.getCores());
        assertEquals(SERIES, cpuParameters.getSeries());
        assertEquals(SOCKET, cpuParameters.getSocket());
        assertEquals(THREADS, cpuParameters.getThreads());
        assertEquals(BIT_ARCHITECTURE, cpuParameters.getBitArchitecture());
        assertEquals(CACHE, cpuParameters.getCache());
        assertEquals(FREQUENCY, cpuParameters.getFrequency(), 1e-15);
    }
}