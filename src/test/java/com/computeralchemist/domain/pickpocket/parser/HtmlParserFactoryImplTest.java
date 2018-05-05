package com.computeralchemist.domain.pickpocket.parser;

import com.computeralchemist.controller.exception.BadComponentTypeException;
import com.computeralchemist.domain.pickpocket.parser.xkom.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

/*@SpringBootTest
@RunWith(SpringRunner.class)*/
public class HtmlParserFactoryImplTest {

    private HtmlParserFactory htmlParserFactory;

    @Before
    public void setUp() {
        htmlParserFactory = new HtmlParserFactoryXkom();
    }

    @Test
    public void incjectionTest() {
        assertNotNull(htmlParserFactory);
    }

    private final String TYPE_CPU = "cpu";
    private final String TYPE_RAM = "ram";
    private final String TYPE_DISK = "disk";
    private final String TYPE_SUPPLY = "supply";
    private final String TYPE_CASE = "computercase";
    private final String TYPE_GPU = "gpu";
    private final String TYPE_MOBO = "motherboard";

    private final String INVALID_TYPE = "cpiu";

    @Test
    public void factoryShouldReturnSuitableParser() {
        AbstractHtmlParser parser = htmlParserFactory.createOne(TYPE_CPU);
        assertNotNull(parser);
        assertTrue(parser instanceof CpuHtmlParserXkom);

        AbstractHtmlParser parser1 = htmlParserFactory.createOne(TYPE_RAM);
        assertNotNull(parser1);
        assertTrue(parser1 instanceof RamHtmlParserXkom);

        AbstractHtmlParser parser2 = htmlParserFactory.createOne(TYPE_DISK);
        assertNotNull(parser2);
        assertTrue(parser2 instanceof DiskHtmlParserXkom);

        AbstractHtmlParser parser3 = htmlParserFactory.createOne(TYPE_SUPPLY);
        assertNotNull(parser3);
        assertTrue(parser3 instanceof SupplyHtmlParserXkom);

        AbstractHtmlParser parser4 = htmlParserFactory.createOne(TYPE_CASE);
        assertNotNull(parser4);
        assertTrue(parser4 instanceof ComputerCaseHtmlParserXkom);

        AbstractHtmlParser parser5 = htmlParserFactory.createOne(TYPE_MOBO);
        assertNotNull(parser5);
        assertTrue(parser5 instanceof MotherboardHtmlParserXkom);

        AbstractHtmlParser parser6 = htmlParserFactory.createOne(TYPE_GPU);
        assertNotNull(parser6);
        assertTrue(parser6 instanceof GraphicsCardHtmlParserXkom);
    }

    @Test(expected = BadComponentTypeException.class)
    public void factoryShouldThrowException() {
        htmlParserFactory.createOne(INVALID_TYPE);
    }
}