package com.computeralchemist.domain.pickpocket.parser.xkom;

import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.ram.Ram;
import com.computeralchemist.domain.components.ram.RamParameters;
import com.computeralchemist.domain.pickpocket.parser.AbstractHtmlParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

public class RamHtmlParserXkom extends AbstractHtmlParser {
    private Ram ram;
    private RamParameters parameters;

    private final int MODULES_DEFAULT = 1;

    private final int DESC_INDEX = 63;
    private final int MEMORY_TYPE_INDEX = 6;
    private final int COOLER_INDEX = 11;
    private final int CAPACITY_INDEX = 7;
    private final int FREQUENCY_INDEX = 8;

    public RamHtmlParserXkom() {
        super.computerComponent = new Ram();
        this.ram = (Ram) computerComponent;
        parameters = new RamParameters();
        ram.setRamParameters(parameters);
    }

    @Override
    public void documentToObject() {
        ram.setComponentType(ComponentType.ram);

        setDescription();
        setProducent();
        setModel();
        setModules();
        setMemoryType();
        setCooler();
        setCapacity();
        setFrequency();
    }

    private void setDescription() {
        String description = document.select("p").get(DESC_INDEX).text();
        ram.setDescription(description);
    }

    private void setModules() {
        String modulesString = document.select("h1").text();

        String result = "";
        Pattern pattern = Pattern.compile("[0-9]{1}x");
        Matcher matcher = pattern.matcher(modulesString);

        if (matcher.find()) {
            result = matcher.group();
            double modules = extractDoubleFromString(result);
            parameters.setModules((int) modules);
        }

        else parameters.setModules(MODULES_DEFAULT);
    }

    private void setMemoryType() {
        String memoryType = fetchTrTags().get(MEMORY_TYPE_INDEX).select("td").text();
        parameters.setMemoryType(memoryType);
    }

    private void setCooler() {
        String cooler = fetchTrTags().get(COOLER_INDEX).select("td").text();
        parameters.setCooler(cooler);
    }

    private void setCapacity() {
        String capacityString = fetchTrTags().get(CAPACITY_INDEX).select("td").text();
        double capacity = extractDoubleFromString(capacityString);
        parameters.setCapacityGb((int) capacity);
    }

    private void setFrequency() {
        String frequencyString = fetchTrTags().get(FREQUENCY_INDEX).select("td").text();
        double frequency = extractDoubleFromString(frequencyString);
        parameters.setFrequency(frequency);
    }

}
