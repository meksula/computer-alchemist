package com.computeralchemist.domain.pickpocket.parser.xkom;

import com.computeralchemist.domain.components.cpu.Cpu;
import com.computeralchemist.domain.components.cpu.CpuParameters;
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
public class CpuHtmlParserXkomTest {
    private static AbstractHtmlParser parser;
    private static CpuParameters cpuParameters;

    private final double DELTA = 1e-15;

    private final static String URL = "https://www.x-kom.pl/p/383500-procesory-intel-core-i5-intel-i5-8400-280ghz-9mb-box.html";

    private final String PRODUCENT = "Intel";
    private final String MODEL = "i5-8400 2.80GHz 9MB BOX";
    private final String SERIES = "Intel Core i5";
    private final String SOCKET = "1151";
    private final double FREQUENCY = 2.8;
    private final int CORES = 6;
    private final int THREADS = 6;
    private final int CACHE = 9;
    private final String INTEGRATED_GPU = "Intel UHD Graphics 630";

    @BeforeClass
    public static void setUp() {
        parser = new CpuHtmlParserXkom();
        parser.parseHtmlToObject(URL);
        Cpu cpu = (Cpu) parser.getComputerComponent();
        cpuParameters = cpu.getCpuParameters();
    }

    @Test
    public void shouldCreateDocumentCorrectly() {
        assertNotNull(parser.getDocument());
    }

    @Test
    public void setProducentTest() {
        assertEquals(PRODUCENT, parser.getComputerComponent().getProducent());
    }

    @Test
    public void setModelTest() {
        assertEquals(MODEL, parser.getComputerComponent().getModel());
    }

    @Test
    public void setDescriptionTest() {
        assertTrue(parser.getComputerComponent().getDescription().length() > 0);
    }

    @Test
    public void setSeriesTest() {
        assertEquals(SERIES, cpuParameters.getSeries());
    }

    @Test
    public void setSocketTest() {
        assertTrue(cpuParameters.getSocket().contains(SOCKET));
    }

    @Test
    public void setFrequencyTest() {
        assertEquals(FREQUENCY, cpuParameters.getFrequency(), DELTA);
    }

    @Test
    public void setCoresTest() {
        assertEquals(CORES, cpuParameters.getCores());
    }

    @Test
    public void setThreadsTest() {
        assertEquals(THREADS, cpuParameters.getThreads());
    }

    @Test
    public void setCacheTest() {
        assertEquals(CACHE, cpuParameters.getCache());
    }

    @Test
    public void setGpuTest() {
        assertEquals(INTEGRATED_GPU, cpuParameters.getIntegratedGpu());
    }

}