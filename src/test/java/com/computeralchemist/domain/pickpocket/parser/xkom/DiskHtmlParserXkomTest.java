package com.computeralchemist.domain.pickpocket.parser.xkom;

import com.computeralchemist.domain.components.disk.Disk;
import com.computeralchemist.domain.components.disk.DiskParameters;
import com.computeralchemist.domain.pickpocket.parser.AbstractHtmlParser;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

public class DiskHtmlParserXkomTest {
    private static AbstractHtmlParser parser;
    private static Disk disk;
    private static DiskParameters parameters;

    private static final String LINK = "https://www.x-kom.pl/p/405758-dysk-ssd-samsung-250gb-25-sata-ssd-860-evo.html";

    private final String PRODUCENT = "Samsung";
    private final String MODEL = "250GB 2,5'' SATA SSD 860 EVO";
    private final String TYPE = "SSD";
    private final String FORMAT = "2.5\"";
    private final int CAPACITY = 250;
    private final double WRITE_SPEED = 520;
    private final double READ_SPEED = 550;
    private final double DELTA = 1e-15;

    @BeforeClass
    public static void setUp() {
        parser = new DiskHtmlParserXkom();
        parser.parseHtmlToObject(LINK);
        disk = (Disk) parser.getComputerComponent();
        parameters = disk.getDiskParameters();
    }

    @Test
    public void setProducentTest() {
        assertEquals(PRODUCENT, disk.getProducent());
    }

    @Test
    public void setModelTest() {
        assertEquals(MODEL, disk.getModel());
    }

    @Test
    public void setTypeTest() {
        assertEquals(TYPE, parameters.getType().toString());
    }

    @Test
    public void setFormatTest() {
        assertEquals(FORMAT, parameters.getFormat());
    }

    @Test
    public void setCapacityTest() {
        assertEquals(CAPACITY, parameters.getCapacity());
    }

    @Test
    public void setReadSpeedTest() {
        assertEquals(READ_SPEED, parameters.getReadSpeed(), DELTA);
    }

    @Test
    public void setWriteSpeedTest() {
        assertEquals(WRITE_SPEED, parameters.getWriteSpeed(), DELTA);
    }

}