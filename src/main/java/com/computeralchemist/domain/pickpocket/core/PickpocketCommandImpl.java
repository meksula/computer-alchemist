package com.computeralchemist.domain.pickpocket.core;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.pickpocket.exception.AddressNotSupportedException;
import com.computeralchemist.domain.pickpocket.parser.AbstractHtmlParser;
import com.computeralchemist.domain.pickpocket.parser.HtmlParserFactory;
import com.computeralchemist.domain.pickpocket.parser.morele.HtmlParserFactoryMorele;
import com.computeralchemist.domain.pickpocket.parser.xkom.HtmlParserFactoryXkom;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

@Component
public class PickpocketCommandImpl implements PickpocketCommand {
    private HtmlParserFactory parserFactory;
    private AbstractHtmlParser htmlParser;
    private String url;

    @Override
    public ComputerComponent executeUrl(String url, String componentType) {
        this.url = extractUrlFromString(url);

        parserFactory = initializeFactory();

        if (isUrlCorrect())
            htmlParser = parserFactory.createOne(componentType);

        return htmlParser.parseHtmlToObject(this.url);
    }

    private HtmlParserFactory initializeFactory() {
        if (url.contains("morele"))
            return new HtmlParserFactoryMorele();
        else if (url.contains("x-kom"))
            return new HtmlParserFactoryXkom();

        else throw new AddressNotSupportedException();
    }

    private boolean isUrlCorrect() {
        try {
            new URL(url);
        } catch (MalformedURLException e) {
            return false;
        }
        return true;
    }

    private String extractUrlFromString(String urlJson) {
        Pattern pattern = Pattern.compile("(http)+.+(html)");
        Matcher matcher = pattern.matcher(urlJson);

        if (matcher.find())
            return matcher.group();

        else throw new AddressNotSupportedException();
    }

}
