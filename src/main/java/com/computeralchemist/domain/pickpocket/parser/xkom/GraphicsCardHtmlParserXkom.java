package com.computeralchemist.domain.pickpocket.parser.xkom;

import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.gpu.GraphicsCard;
import com.computeralchemist.domain.components.gpu.GraphicsCardParameters;
import com.computeralchemist.domain.pickpocket.parser.AbstractHtmlParser;
import lombok.Getter;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

@Getter
public class GraphicsCardHtmlParserXkom extends AbstractHtmlParser {
    private GraphicsCardParameters parameters;
    private Elements elementsText;
    private Elements parametersHtml;

    private final int DESCRIPTION_INDEX = 59;
    private final int CONNECTORS_INDEX = 14;
    private final int CHIPSET_INDEX = 6;
    private final int MAIN_CONNECTOR_INDEX = 7;
    private final int MEMORY_INDEX = 8;
    private final int MEMORY_TYPE_INDEX = 9;
    private final int MEMORY_FREQUENCY_INDEX = 11;
    private final int CLOCK_FREQUENCY_INDEX = 12;
    private final int COOLER_INDEX = 13;
    private final int STANDARDS_INDEX = 15;
    private final int LENGHT_INDEX = 17;

    public GraphicsCardHtmlParserXkom() {
        parameters = new GraphicsCardParameters();
        computerComponent = new GraphicsCard();
        GraphicsCard graphicsCard = (GraphicsCard) computerComponent;
        graphicsCard.setGraphicsCardParameters(parameters);
    }

    @Override
    public void documentToObject() {
        elementsText = document.select("p");
        parametersHtml = document.select("tbody");

        setComponentType();
        setDescription();
        setProducent();
        setModel();
        setChipset();
        setListOfConnectors();
        setMainConnector();
        setMemory();
        setMemoryFrequency();
        setClockFrequency();
        setCooler();
        setLength();
        setListOfStandards();
    }

    private void setComponentType() {
        computerComponent.setComponentType(ComponentType.gpu);
    }

    private void setDescription() {
        List<String> descList = elementsText.eachText();
        computerComponent.setDescription(descList.get(DESCRIPTION_INDEX));
    }

    private void setChipset() {
        String chipset = fetchTrTags().get(CHIPSET_INDEX).select("td").text();
        parameters.setChipset(chipset);
    }

    private void setMainConnector() {
        String mainConnector = fetchTrTags().get(MAIN_CONNECTOR_INDEX).select("td").text();
        parameters.setMainConnectorType(mainConnector);
    }

    private void setMemory() {
        String memory = fetchTrTags().get(MEMORY_INDEX).select("td").text();
        int memoryInt = (int) extractDoubleFromString(memory);

        parameters.setMemory(memoryInt);
    }

    private void setMemoryFrequency() {
        String frequency = fetchTrTags().get(MEMORY_FREQUENCY_INDEX).select("td").text();
        double frequencyDouble = extractDoubleFromString(frequency);

        parameters.setMemoryFrequency(frequencyDouble);
    }

    private void setClockFrequency() {
        String frequency = fetchTrTags().get(CLOCK_FREQUENCY_INDEX).select("td").text();
        double frequencyDouble = extractDoubleFromString(frequency);

        parameters.setClockFrequency(frequencyDouble);
    }

    private void setCooler() {
        String cooler = fetchTrTags().get(COOLER_INDEX).select("td").text();

        parameters.setCooler(cooler);
    }

    private void setLength() {
        String lengthString = fetchTrTags().get(LENGHT_INDEX).select("td").text();
        double length = extractDoubleFromString(lengthString);

        parameters.setLength(length);
    }

    private void setListOfConnectors() {
        final int BEGIN_INDEX = 14;

        String extracted = fetchTrTags().get(CONNECTORS_INDEX).text();
        extracted = extracted.substring(BEGIN_INDEX);

        String[] prepared = extracted.split("\\.\\s");

        parameters.setConnectors(Arrays.asList(prepared));
    }

    private void setListOfStandards() {
        String standards = fetchTrTags().get(STANDARDS_INDEX).select("td").text();
        String[] splited = standards.split("\\s");

        StringBuilder builder;

        List<String> standardsList = new ArrayList<>();

        for (int i = 0; i < splited.length; i++) {
            try {
                builder = new StringBuilder();
                builder.append(splited[i * 2]).append(" ").append(splited[(i * 2) + 1]);
                standardsList.add(builder.toString());
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }

        }

        parameters.setStandards(standardsList);
    }

}
