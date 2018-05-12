package com.computeralchemist.domain.creator.compatibility.concreteCheckers;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.components.cpu.Cpu;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.domain.components.motherboard.MotherboardParameters;
import com.computeralchemist.domain.creator.compatibility.CompatibilityChecker;
import com.computeralchemist.domain.creator.setTypes.ComputerSet;

/**
 * @Author
 * Karol Meksuła
 * 15-04-2018
 * */

public class CpuChecker extends CompatibilityChecker {
    private ComputerSet computerSet;
    private Cpu computerComponent;

    @Override
    public boolean compatibilityCheck(ComputerSet set, ComputerComponent component) {
        this.computerSet = set;
        this.computerComponent = (Cpu) component;

        if (set.getMotherboard() == null)
            return true;

        else return compatibleWithMotherboard();
    }

    private boolean compatibleWithMotherboard() {
        Motherboard motherboard = computerSet.getMotherboard();
        MotherboardParameters motherboardParameters = motherboard.getMotherboardParameters();

        String cpuSocket = "empty";
        try {
            cpuSocket = computerComponent.getCpuParameters().getSocket();
        } catch (NullPointerException npe) {
            return false;
        }

        return motherboardParameters.getSocket().contains(cpuSocket);
    }


}
