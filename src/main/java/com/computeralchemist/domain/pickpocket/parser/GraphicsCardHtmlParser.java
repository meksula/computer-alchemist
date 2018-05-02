package com.computeralchemist.domain.pickpocket.parser;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.components.gpu.GraphicsCard;
import com.computeralchemist.domain.pickpocket.exception.HtmlParseFailedException;
import lombok.Getter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

@Getter
public class GraphicsCardHtmlParser extends AbstractHtmlParser {
    private String url;
    private Document document;
    private GraphicsCard computerComponent;
    private Elements elementsText;
    private Elements parametersHtml;
    private Elements trTags;

    private final int DESCRIPTION_INDEX = 59;

    @Override
    public ComputerComponent parseHtmlToObject(String url) {
        this.url = url;

        connect();
        documentToObject();

        if (computerComponent == null)
            throw new HtmlParseFailedException();

        return computerComponent;
    }

    private void connect() {
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException | IllegalArgumentException exception) {
            throw new HtmlParseFailedException();
        }
    }

    private void documentToObject() {
        computerComponent = new GraphicsCard();
        elementsText = document.select("p");

        setDescription();
        setProducent();

        parametersHtml = document.select("tbody");
    }

    private void setDescription() {
        List<String> descList = elementsText.eachText();
        computerComponent.setDescription(descList.get(DESCRIPTION_INDEX));
    }

    private void setProducent() {

    }

    private void setModel() {

    }

    private Elements fetchTrTags() {
        return document.select("tr");
    }

}
