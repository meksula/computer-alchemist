package com.computeralchemist.domain.pickpocket.parser.xkom;

import com.computeralchemist.domain.components.gpu.GraphicsCard;
import com.computeralchemist.domain.components.gpu.GraphicsCardParameters;
import com.computeralchemist.domain.pickpocket.exception.HtmlParseFailedException;
import com.computeralchemist.domain.pickpocket.parser.xkom.GraphicsCardHtmlParserXkom;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

@Slf4j
public class GraphicsCardHtmlParserTest {
    private static GraphicsCardHtmlParserXkom parser;
    private static GraphicsCardParameters gpuParams;

    private final static String VALID_LINK = "https://www.x-kom.pl/p/337463-karta-graficzna-nvidia-asus-geforce-gtx-1050-phoenix-2gb-gddr5.html";
    private final String INVALID_LINK = "httpsd://www.niepoprawny_link/1312313/131dwx";

    private final String PRODUCENT = "ASUS";
    private final String MODEL = "GeForce GTX 1050 Phoenix 2GB GDDR5";
    private final String CHIPSET = "GeForce GTX 1050";
    private final String MAIN_CONNECTOR = "PCI-E x16 3.0";
    private final int MEMORY = 2;
    private final double MEMORY_FREQUENCY = 7008;
    private final double CLOCK_FREQUENCY = 1354;
    private final String COOLER = "Aktywne";
    private final int STANDRATDS_SIZE = 2;
    private final double LENGTH = 192;

    private final double DELTA = 1e-15;

    @BeforeClass
    public static void setUp() {
        parser = new GraphicsCardHtmlParserXkom();
        parser.parseHtmlToObject(VALID_LINK);
        GraphicsCard graphicsCard = (GraphicsCard) parser.getComputerComponent();
        gpuParams = graphicsCard.getGraphicsCardParameters();
    }

    @Test(expected = HtmlParseFailedException.class)
    public void shouldThrowException() {
        parser.parseHtmlToObject(INVALID_LINK);
    }

    @Test
    public void shouldCreateDocumentCorrectly() {
        Document document = parser.getDocument();
        assertNotNull(document);
    }

    @Ignore
    @Test
    public void documentToObjectShouldCorrectlyCreateGraphicsCard() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Class<?> gpu = parser.getClass();
        Method documetToObject = gpu.getDeclaredMethod("documentToObject");
        documetToObject.setAccessible(true);

        Field computerComponent = gpu.getDeclaredField("computerComponent");
        computerComponent.setAccessible(true);

        documetToObject.invoke(parser);

        GraphicsCard graphicsCard = (GraphicsCard) computerComponent.get(parser);
        assertNotNull(graphicsCard);
    }

    @Test
    public void setProducentTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        assertEquals(PRODUCENT, parser.getComputerComponent().getProducent());
    }

    @Test
    public void setConnectorsTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> gpu = parser.getClass();
        Method documetToObject = gpu.getDeclaredMethod("setListOfConnectors");
        documetToObject.setAccessible(true);

        parser.parseHtmlToObject(VALID_LINK);
        documetToObject.invoke(parser);

        int size = gpuParams.getConnectors().size();
        assertEquals(3, size);
    }

    @Test
    public void setDescriptionTest() {
        assertTrue(parser.getComputerComponent().getDescription().length() > 1);
    }

    @Test
    public void setModelTest() {
        assertEquals(MODEL, parser.getComputerComponent().getModel());
    }

    @Test
    public void setChipsetTest() {
        assertEquals(CHIPSET, gpuParams.getChipset());
    }

    @Test
    public void setMainConnectorTest() {
        assertEquals(MAIN_CONNECTOR, gpuParams.getMainConnectorType());
    }

    @Test
    public void setMemoryTest() {
        assertEquals(MEMORY, gpuParams.getMemory());
    }

    @Test
    public void setMemoryFrequencyTest() {
        assertEquals(MEMORY_FREQUENCY, gpuParams.getMemoryFrequency(), DELTA);
    }

    @Test
    public void setClockFrequencyTest() {
        assertEquals(CLOCK_FREQUENCY, gpuParams.getClockFrequency(), DELTA);
    }

    @Test
    public void setCoolerTest() {
        assertEquals(COOLER, gpuParams.getCooler());
    }

    @Test
    public void setLengthTest() {
        assertEquals(LENGTH, gpuParams.getLength(), DELTA);
    }

    @Test
    public void setStandardsTest() {
        assertEquals(STANDRATDS_SIZE, gpuParams.getStandards().size());
    }

}