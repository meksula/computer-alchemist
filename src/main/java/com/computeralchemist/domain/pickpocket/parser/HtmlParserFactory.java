package com.computeralchemist.domain.pickpocket.parser;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

public interface HtmlParserFactory {
    AbstractHtmlParser createOne(String componentType);
}
