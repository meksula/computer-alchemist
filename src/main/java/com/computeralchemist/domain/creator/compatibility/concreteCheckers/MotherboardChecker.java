package com.computeralchemist.domain.creator.compatibility.concreteCheckers;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.domain.creator.compatibility.CompatibilityChecker;
import com.computeralchemist.domain.creator.setTypes.ComputerSet;

/**
 * @Author
 * Karol Meksuła
 * 15-04-2018
 * */

public class MotherboardChecker extends CompatibilityChecker {

    @Override
    public boolean compatibilityCheck(ComputerSet set, ComputerComponent component) {
        final Motherboard MOTHERBOARD = (Motherboard) component;

        final String CPU_SOCKET = set.getCpu().getCpuParameters().getSocket();
        final String MOTHERBOARD_SOCKET = MOTHERBOARD.getMotherboardParameters().getSocket();

        if (CPU_SOCKET.equals(MOTHERBOARD_SOCKET))
            return true;

        return false;
    }
}
