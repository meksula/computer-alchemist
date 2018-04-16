package com.computeralchemist.domain.creator.compatibility.concreteCheckers;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.components.computerCase.ComputerCase;
import com.computeralchemist.domain.components.gpu.GraphicsCard;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.domain.creator.compatibility.CompatibilityChecker;
import com.computeralchemist.domain.creator.setTypes.ComputerSet;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 15-04-2018
 * */

public class ComputerCaseChecker extends CompatibilityChecker {
    private Motherboard motherboard;
    private ComputerCase computerCase;

    @Override
    public boolean compatibilityCheck(ComputerSet set, ComputerComponent component) {
        this.motherboard = set.getMotherboard();
        this.computerCase = (ComputerCase) component;

        return checkMoboCompatibility();
    }

    private boolean checkMoboCompatibility() {
        String moboType = motherboard.getMotherboardParameters().getType();
        List<String> mobos = computerCase.getComputerCaseParameters().getCompatibilityMotherboards();

        for (String item : mobos) {
            if (item.equals(moboType))
                return true;
        }

        return false;
    }

}
