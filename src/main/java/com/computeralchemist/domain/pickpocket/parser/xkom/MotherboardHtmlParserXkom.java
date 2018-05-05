package com.computeralchemist.domain.pickpocket.parser.xkom;

import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.domain.components.motherboard.MotherboardParameters;
import com.computeralchemist.domain.pickpocket.parser.AbstractHtmlParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

public class MotherboardHtmlParserXkom extends AbstractHtmlParser {
    private Motherboard motherboard;
    private MotherboardParameters parameters;

    private final int DESCRIPTION_INDEX = 63;
    private final int TYPE_INDEX = 17;
    private final int CHIPSET_INDEX = 8;
    private final int SOCKET_INDEX = 7;
    private final int RAM_SOCKETS_INDEX = 10;
    private final int MEMORY_TYPE_INDEX = 9;
    private final int MEMORY_FREQUENCY_INDEX = 9;
    private final int PROCESORS_AVAILABLE_INDEX = 6;
    private final int OTHER_SOCKETS_INDEX = 11;
    private final int OTHER_SOCKETS_INDEX_B = 12;

    public MotherboardHtmlParserXkom() {
        this.parameters = new MotherboardParameters();
        super.computerComponent = new Motherboard();
        this.motherboard = (Motherboard) computerComponent;
        motherboard.setMotherboardParameters(parameters);
    }

    @Override
    public void documentToObject() {
        motherboard.setComponentType(ComponentType.motherboard);

        setProducent();
        setModel();
        setDescription();
        setType();
        setChipset();
        setSocket();
        setRamSockets();
        setMemoryType();
        setMemoryFrequency();
        setProcessorsAvailable();
        setOtherSockets();
    }

    private void setDescription() {
        String description = document.select("p").get(DESCRIPTION_INDEX).text();
        motherboard.setDescription(description);
    }

    private void setType() {
        String type = fetchTrTags().get(TYPE_INDEX).select("td").text();
        parameters.setType(type);
    }

    private void setChipset() {
        String chipset = fetchTrTags().get(CHIPSET_INDEX).select("td").text();
        parameters.setChipset(chipset);
    }

    private void setSocket() {
        String socket = fetchTrTags().get(SOCKET_INDEX).select("td").text();
        parameters.setSocket(socket);
    }

    private void setRamSockets() {
        String ramSockets = fetchTrTags().get(RAM_SOCKETS_INDEX).select("td").text();
        int amount  = (int) extractDoubleFromString(ramSockets);
        parameters.setRamSockets(amount);
    }

    private void setMemoryType() {
        String memoryType = fetchTrTags().get(MEMORY_TYPE_INDEX).select("td").text();
        String result = "";

        Pattern pattern = Pattern.compile("DDR[0-9]{1}");
        Matcher matcher = pattern.matcher(memoryType);
        if (matcher.find())
            result = matcher.group();

        parameters.setMemoryType(result);
    }

    private void setMemoryFrequency() {
        String allProperties = fetchTrTags().get(MEMORY_FREQUENCY_INDEX).select("td").text();
        List<Double> properties = new ArrayList<>();

        Pattern pattern = Pattern.compile("[0-9]{4}");
        Matcher matcher = pattern.matcher(allProperties);

        for (int i = 0; i < allProperties.length(); i++) {
            if (matcher.find())
                properties.add(Double.parseDouble(matcher.group()));
            if (!matcher.find())
                break;
        }

        double max = Collections.max(properties);
        parameters.setMemoryFrequency(max);
    }

    private void setProcessorsAvailable() {
        String processors = fetchTrTags().get(PROCESORS_AVAILABLE_INDEX).select("td").html();
        String[] splited = processors.split("<br>");
        String treatment = splited[0].substring(16);
        splited[0] = treatment;

        parameters.setProcesorAvailables(Arrays.asList(splited));
    }

    private void setOtherSockets() {
        String otherSockets1 = fetchTrTags().get(OTHER_SOCKETS_INDEX).select("td").get(1).html();
        String otherSockets2 = fetchTrTags().get(OTHER_SOCKETS_INDEX_B).select("td").get(1).html();

        String[] splited1 = otherSockets1.split("<br>");
        String[] splited2 = otherSockets2.split("<br>");

        for (int i = 0; i < splited1.length; i++) {
            String trimed = splited1[i].trim();
            splited1[i] = trimed;
        }

        for (int i = 0; i < splited2.length; i++) {
            String trimed2 = splited2[i].trim();
            splited2[i] = trimed2;
        }

        List<String> connectors = new ArrayList<>();
        connectors.addAll(Arrays.asList(splited1));
        connectors.addAll(Arrays.asList(splited2));

        parameters.setOtherSockets(connectors);
    }


}
