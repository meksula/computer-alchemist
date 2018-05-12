package com.computeralchemist.domain.creator.compatibility.concreteCheckers;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.components.gpu.GraphicsCard;
import com.computeralchemist.domain.creator.compatibility.CompatibilityChecker;
import com.computeralchemist.domain.creator.setTypes.ComputerSet;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 15-04-2018
 * */

public class GraphicsCardChecker extends CompatibilityChecker {

    @Override
    public boolean compatibilityCheck(ComputerSet set, ComputerComponent component) {
        GraphicsCard graphicsCard = (GraphicsCard) component;
        final String MAIN_CONNECTOR = graphicsCard.getGraphicsCardParameters().getMainConnectorType();

        final List<String> MOBO_CONNECTORS = set.getMotherboard().getMotherboardParameters().getOtherSockets();

        for (String connector : MOBO_CONNECTORS) {
            if (connector.contains(MAIN_CONNECTOR))
                return true;
        }

        return false;
    }
}
