package com.computeralchemist.domain.creator.compatibility.concreteCheckers;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.domain.components.ram.Ram;
import com.computeralchemist.domain.creator.compatibility.CompatibilityChecker;
import com.computeralchemist.domain.creator.setTypes.ComputerSet;

/**
 * @Author
 * Karol Meksuła
 * 15-04-2018
 * */

public class RamChecker extends CompatibilityChecker {

    @Override
    public boolean compatibilityCheck(final ComputerSet set, final ComputerComponent component) {
        Motherboard motherboard = set.getMotherboard();

        if (motherboard == null)
            return false;

        final double MOTH_FREQ = motherboard.getMotherboardParameters().getMemoryFrequency();
        final String MOTH_MEM_TYPE = motherboard.getMotherboardParameters().getMemoryType();

        Ram ram = (Ram) component;
        String RAM_MEM_TYPE = ram.getRamParameters().getMemoryType();
        double RAM_FREQ = ram.getRamParameters().getFrequency();

        return MOTH_MEM_TYPE.equals(RAM_MEM_TYPE) && RAM_FREQ <= MOTH_FREQ;
    }

}
