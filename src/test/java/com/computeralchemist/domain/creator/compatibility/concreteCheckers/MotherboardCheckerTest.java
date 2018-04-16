package com.computeralchemist.domain.creator.compatibility.concreteCheckers;

import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.cpu.Cpu;
import com.computeralchemist.domain.components.cpu.CpuParameters;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.domain.components.motherboard.MotherboardParameters;
import com.computeralchemist.domain.creator.setTypes.GamingComputerSet;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @Author
 * Karol Meksuła
 * 15-04-2018
 * */

@Slf4j
public class MotherboardCheckerTest {
    private MotherboardChecker motherboardChecker = new MotherboardChecker();

    private GamingComputerSet gamingComputerSet = new GamingComputerSet();
    private Motherboard motherboard = new Motherboard();
    private final MotherboardParameters motherboardParameters = new MotherboardParameters();
    private final String MOTHER_PROD = "Gigabyte";
    private final String MOTHER_MOD = "Gaming PRO 300";
    private final String MOTHER_SOCKET = "1151";

    private final Cpu cpu = new Cpu();
    private final String PROC_PROD = "Intel";
    private final String PROC_MOD = "core i5";
    private final CpuParameters cpuParameters = new CpuParameters();
    private final String PROC_SOCKET = "1151";

    @Before
    public void setUp() {
        motherboard.setProducent(MOTHER_PROD);
        motherboard.setModel(MOTHER_MOD);
        motherboardParameters.setSocket(MOTHER_SOCKET);
        motherboard.setMotherboardParameters(motherboardParameters);
        motherboard.setComponentType(ComponentType.motherboard);

        cpu.setProducent(PROC_PROD);
        cpu.setModel(PROC_MOD);
        cpuParameters.setSocket(PROC_SOCKET);
        cpu.setCpuParameters(cpuParameters);
        cpu.setComponentType(ComponentType.cpu);

        gamingComputerSet.setCpu(cpu);

    }

    @Test
    public void computerSetShouldBeCompatible() {
        boolean decision = motherboardChecker.compatibilityCheck(gamingComputerSet, motherboard);
        assertTrue(decision);
    }

    private void changeSocket() {
        this.motherboard.getMotherboardParameters().setSocket("AMD4");
    }

    @Test
    public void computerSetShouldNotBeCompatible() {
        changeSocket();
        boolean decision = motherboardChecker.compatibilityCheck(gamingComputerSet, motherboard);
        assertFalse(decision);
    }
}