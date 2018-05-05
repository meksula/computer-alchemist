package com.computeralchemist.domain.pickpocket.parser.xkom;

import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.computerCase.ComputerCase;
import com.computeralchemist.domain.components.computerCase.ComputerCaseParameters;
import com.computeralchemist.domain.pickpocket.parser.AbstractHtmlParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

public class ComputerCaseHtmlParserXkom extends AbstractHtmlParser {
    private ComputerCase computerCase;
    private ComputerCaseParameters parameters;

    private final int DESC_INDEX = 59;
    private final int TYPE_INDEX = 4;
    private final int HEIGHT_INDEX = 20;
    private final int WIDTH_INDEX = 21;
    private final int WEIGHT_INDEX = 23;
    private final int MOTHERBOARDS_INDEX = 5;
    private final int CONNECTORS_INDEX = 16;

    public ComputerCaseHtmlParserXkom() {
        super.computerComponent = new ComputerCase();
        computerCase = (ComputerCase) computerComponent;
        parameters = new ComputerCaseParameters();
        computerCase.setComputerCaseParameters(parameters);
    }

    @Override
    public void documentToObject() {
        computerCase.setComponentType(ComponentType.computercase);

        setProducent();
        setModel();
        setDescription();
        setType();
        setHeight();
        setWidth();
        setWeight();
        setMotherboardsAvailable();
        setConnectors();
    }

    private void setDescription() {
        String description = document.select("p").get(DESC_INDEX).text();
        computerCase.setDescription(description);
    }

    private void setType() {
        String type = fetchTrTags().get(TYPE_INDEX).select("td").text();
        parameters.setType(type);
    }

    private void setHeight() {
        String toExtract = fetchTrTags().get(HEIGHT_INDEX).select("td").text();
        double height = extractDoubleFromString(toExtract);
        parameters.setHeight(height);
    }

    private void setWidth() {
        String toExtract = fetchTrTags().get(WIDTH_INDEX).select("td").text();
        double width = extractDoubleFromString(toExtract);
        parameters.setWidth(width);
    }

    private void setWeight() {
        String toExtract = fetchTrTags().get(WEIGHT_INDEX).select("td").text();
        double weight = extractDoubleFromString(toExtract);
        parameters.setWeight(weight);
    }

    private void setMotherboardsAvailable() {
        String toExtract = fetchTrTags().get(MOTHERBOARDS_INDEX).select("td").text();
        String[] splited = toExtract.split("\\s");

        List<String> mobos = new ArrayList<>(Arrays.asList(splited));
        parameters.setCompatibilityMotherboards(mobos);
    }

    private void setConnectors() {
        String toExtract = fetchTrTags().get(CONNECTORS_INDEX).select("td").html();
        String[] splited = toExtract.split("<br>");

        splited[0] = splited[0].substring(16).trim();

        List<String> connectors = new ArrayList<>(Arrays.asList(splited));
        parameters.setConnectors(connectors);
    }

}
