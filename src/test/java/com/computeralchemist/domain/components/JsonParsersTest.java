package com.computeralchemist.domain.components;

import com.computeralchemist.domain.components.cpu.Cpu;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.domain.components.ram.Ram;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 06-04-2018
 * */

public class JsonParsersTest {
    private final String PRODUCENT = "Intel";
    private final String MODEL = "8th gen i7";
    private final String CPU_JSON = "{\"producent\":\"Intel\", \"model\":\"8th gen i7\"}";
    private final Logger logger = LogManager.getLogger(JsonParsersTest.class);

    @Test
    public void jsonParserCpuTest() throws IOException {
        Cpu cpu = (Cpu) JsonParsers.valueOf("cpu").parseStringToComponent(CPU_JSON);
        logger.info(CPU_JSON);

        assertEquals(PRODUCENT, cpu.getProducent());
        assertEquals(MODEL, cpu.getModel());
    }

    private final String MOTHERBOARD_MODEL = "420 TI";
    private final String MOTHERBOARD_SOCKET = "B250";
    private final String MOTHERBOARD_JSON =
            "{\"model\":\"420 TI\", \"motherboardParameters\":{\"socket\":\"B250\"}}";

    @Test
    public void jsonParserMotherboardTest() throws IOException {
        Motherboard motherboard = (Motherboard) JsonParsers.valueOf("motherboard").parseStringToComponent(MOTHERBOARD_JSON);

        logger.info(MOTHERBOARD_JSON);

        assertEquals(MOTHERBOARD_MODEL, motherboard.getModel());
        assertEquals(MOTHERBOARD_SOCKET, motherboard.getMotherboardParameters().getSocket());
    }

    private final String RAM_PRODUCENT = "Corsair";
    private final double RAM_FREQUENCY = 4.53;
    private final String RAM_JSON = "{\"producent\":\""+ RAM_PRODUCENT +"\", \"ramParameters\":{\"frequency\":\""+RAM_FREQUENCY+"\"}}";

    @Test
    public void jsonParserRamTest() throws IOException {
        Ram ram = (Ram) JsonParsers.valueOf("ram").parseStringToComponent(RAM_JSON);

        logger.info(RAM_JSON);

        assertEquals(RAM_PRODUCENT, ram.getProducent());
        assertEquals(RAM_FREQUENCY, ram.getRamParameters().getFrequency(), 1e-15);
    }
}