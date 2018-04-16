package com.computeralchemist.domain.creator.compatibility.concreteCheckers;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.creator.compatibility.CompatibilityChecker;
import com.computeralchemist.domain.creator.setTypes.ComputerSet;

/**
 * @Author
 * Karol Meksuła
 * 15-04-2018
 * */

public class DiskChecker extends CompatibilityChecker {

    @Override
    public boolean compatibilityCheck(ComputerSet set, ComputerComponent component) {
        return true;
    }
}
