package com.computeralchemist.domain.creator.compatibility.concreteCheckers;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.components.gpu.GraphicsCard;
import com.computeralchemist.domain.components.supply.PowerSupply;
import com.computeralchemist.domain.creator.compatibility.CompatibilityChecker;
import com.computeralchemist.domain.creator.setTypes.ComputerSet;

/**
 * @Author
 * Karol Meksuła
 * 15-04-2018
 * */

public class PowerSupplyChecker extends CompatibilityChecker {
    private ComputerSet set;
    private PowerSupply powerSupply;

    @Override
    public boolean compatibilityCheck(ComputerSet set, ComputerComponent component) {
        this.set = set;
        this.powerSupply = (PowerSupply) component;
        return checkIfSupplyPowerIsEnaugh();
    }

    private boolean checkIfSupplyPowerIsEnaugh() {
        if (set.getGraphicsCard() != null
                && powerSupply.getPowerSupplyParameters().getPower() < 400)
            return false;

        return true;
    }
}
