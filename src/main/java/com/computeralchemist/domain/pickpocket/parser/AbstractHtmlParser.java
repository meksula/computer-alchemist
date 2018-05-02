package com.computeralchemist.domain.pickpocket.parser;

import com.computeralchemist.domain.components.ComputerComponent;

import java.io.IOException;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

public abstract class AbstractHtmlParser {
    public abstract ComputerComponent parseHtmlToObject(String url);
}
