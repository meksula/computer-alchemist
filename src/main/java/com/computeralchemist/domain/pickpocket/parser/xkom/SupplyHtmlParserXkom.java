package com.computeralchemist.domain.pickpocket.parser.xkom;

import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.supply.PowerSupply;
import com.computeralchemist.domain.components.supply.PowerSupplyParameters;
import com.computeralchemist.domain.pickpocket.parser.AbstractHtmlParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

public class SupplyHtmlParserXkom extends AbstractHtmlParser {
    private PowerSupply powerSupply;
    private PowerSupplyParameters parameters;

    private final int DESC_INDEX = 59;
    private final int STANDARD_INDEX = 6;
    private final int POWER_INDEX = 5;
    private final int PFC_INDEX = 11;
    private final int MODULAR_INDEX = 12;
    private final int CONNECTORS_INDEX = 7;

    public SupplyHtmlParserXkom() {
        super.computerComponent = new PowerSupply();
        powerSupply = (PowerSupply) computerComponent;
        parameters = new PowerSupplyParameters();
        powerSupply.setPowerSupplyParameters(parameters);
    }

    @Override
    public void documentToObject() {
        powerSupply.setComponentType(ComponentType.supply);

        setProducent();
        setModel();
        setDescription();
        setStandard();
        setPower();
        setPfc();
        setModular();
        setConnectors();
    }

    private void setDescription() {
        String description = document.select("p").get(DESC_INDEX).text();
        powerSupply.setDescription(description);
    }

    private void setStandard() {
        String standard = fetchTrTags().get(STANDARD_INDEX).select("td").text();
        parameters.setStandard(standard);
    }

    private void setPower() {
        String power = fetchTrTags().get(POWER_INDEX).select("td").text();
        double powerDouble = extractDoubleFromString(power);
        parameters.setPower((int) powerDouble);
    }

    private void setPfc() {
        String pfc = fetchTrTags().get(PFC_INDEX).select("td").text();
        parameters.setPfc(pfc);
    }

    private void setModular() {
        String modular = fetchTrTags().get(MODULAR_INDEX).select("td").text();
        boolean isModular;

        if (modular.contains("Nie") || modular.contains("nie"))
            isModular = false;

        else isModular = true;

        parameters.setModularCable(isModular);
    }

    private void setConnectors() {
        String connectors = fetchTrTags().get(CONNECTORS_INDEX).select("td").html();
        String connectorsTrimed = connectors.substring(16);
        String[] splited = connectorsTrimed.split("<br>");

        for (int i = 0; i < splited.length; i++) {
            splited[i] = splited[i].trim();
        }

        List<String> list = new ArrayList<>(Arrays.asList(splited));
        parameters.setConnectors(list);
    }

}
