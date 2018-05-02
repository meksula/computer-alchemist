package com.computeralchemist.domain.pickpocket.parser;

import com.computeralchemist.domain.components.gpu.GraphicsCard;
import com.computeralchemist.domain.pickpocket.exception.HtmlParseFailedException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
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
    private GraphicsCardHtmlParser parser;

    private final String VALID_LINK = "https://www.x-kom.pl/p/337463-karta-graficzna-nvidia-asus-geforce-gtx-1050-phoenix-2gb-gddr5.html";
    private final String INVALID_LINK = "httpsd://www.niepoprawny_link/1312313/131dwx";

    @Before
    public void setUp() {
        parser = new GraphicsCardHtmlParser();
    }

    @Test(expected = HtmlParseFailedException.class)
    public void shouldThrowException() {
        parser.parseHtmlToObject(INVALID_LINK);
    }

    @Test
    public void shouldCreateDocumentCorrectly() throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> gpu = parser.getClass();
        Method connect = gpu.getDeclaredMethod("connect");
        connect.setAccessible(true);

        Field document = gpu.getDeclaredField("document");
        document.setAccessible(true);

        parser.parseHtmlToObject(VALID_LINK);
        connect.invoke(parser);

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
    public void descriptionSetTest() {
        parser.parseHtmlToObject(VALID_LINK);

        GraphicsCard graphicsCard = parser.getComputerComponent();
        log.info(graphicsCard.getDescription());
    }

    @Test
    public void setProducentTest() {
        parser.parseHtmlToObject(VALID_LINK);
        parser.setProducent();
    }

}