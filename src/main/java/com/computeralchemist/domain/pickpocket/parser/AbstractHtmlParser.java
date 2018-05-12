package com.computeralchemist.domain.pickpocket.parser;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.pickpocket.exception.HtmlParseFailedException;
import lombok.Getter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

@Getter
public abstract class AbstractHtmlParser {
    protected Document document;
    protected String url;
    protected ComputerComponent computerComponent;

    public ComputerComponent parseHtmlToObject(String url) {
        this.url = url;

        connect();
        documentToObject();

        if (computerComponent == null)
            throw new HtmlParseFailedException();

        return computerComponent;
    }

    public List<String> parseHtmlToList(String url) {
        this.url = url;
        connect();

        List<String> list = fetchAllProperties();

        return list.subList(6, list.size() - 1);
    }

    private void connect() {
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException | IllegalArgumentException exception) {
            throw new HtmlParseFailedException();
        }
    }

    public abstract void documentToObject();

    protected double extractDoubleFromString(String property) {
        double resultDouble = 0;
        String result = "";
        Pattern pattern = Pattern.compile("[0-9.]+");
        Matcher matcher = pattern.matcher(property);

        if (matcher.find())
            result = matcher.group();

        if (!result.isEmpty())
            resultDouble = Double.parseDouble(result);

        return resultDouble;
    }

    protected Elements fetchTrTags() {
        return document.select("tr");
    }

    private List<String> fetchAllProperties() {
        List<String> properties = new ArrayList<>();
        Elements elements = fetchTrTags();

        for (int i = 0; i < elements.size(); i++) {
            String element = elements.get(i).text();
            properties.add(element);
        }

        return properties;
    }

    protected void setProducent() {
        String producent = document.select("h1").text();
        String[] splited = producent.split("\\s");
        computerComponent.setProducent(splited[0].trim());
    }

    protected void setModel() {
        String model = document.select("h1").text();
        String[] splited = model.split("\\s");

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < splited.length; i++) {
            if (i > 0)
                builder.append(splited[i]);
            if (i != 0 && i < splited.length - 1)
                builder.append(" ");
        }

        computerComponent.setModel(builder.toString().trim());
    }

}
