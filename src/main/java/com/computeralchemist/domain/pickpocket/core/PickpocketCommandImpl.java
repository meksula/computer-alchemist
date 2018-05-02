package com.computeralchemist.domain.pickpocket.core;

import com.computeralchemist.controller.exception.CannotReadUrlException;
import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.pickpocket.parser.AbstractHtmlParser;
import com.computeralchemist.domain.pickpocket.parser.HtmlParserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

@Component
public class PickpocketCommandImpl implements PickpocketCommand {
    private HtmlParserFactory parserFactory;

    @Autowired
    public void setParserFactory(HtmlParserFactory parserFactory) {
        this.parserFactory = parserFactory;
    }

    @Override
    public ComputerComponent executeUrl(String url, String componentType) {
        AbstractHtmlParser htmlParser = parserFactory.createOne(componentType);

        if (isUrlCorrect(url))
            return htmlParser.parseHtmlToObject(url);

        else throw new CannotReadUrlException(url);
    }

    private boolean isUrlCorrect(String url) {
        try {
            new URL(url);
        } catch (MalformedURLException e) {
            return false;
        }
        return true;
    }
}
