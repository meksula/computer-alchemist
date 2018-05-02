package com.computeralchemist.domain.pickpocket.parser;

import org.junit.Before;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

public class CpuHtmlParserTest {
    private AbstractHtmlParser cpuHtmlParser;

    @Before
    public void setUp() {
        cpuHtmlParser = new CpuHtmlParser();
    }
}