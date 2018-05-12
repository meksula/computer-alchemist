package com.computeralchemist.domain.creator.compatibility.concreteCheckers;

import com.computeralchemist.domain.components.cpu.Cpu;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.domain.creator.setTypes.GamingComputerSet;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 15-04-2018
 * */

public class CpuCheckerTest {
    private CpuChecker cpuChecker = new CpuChecker();

    private GamingComputerSet set = new GamingComputerSet();
    private Motherboard motherboard = new Motherboard();

    private Cpu cpu = new Cpu();

    @Test
    public void setCpuCheckerReturnAlwaysTrue() {
        assertNull(set.getMotherboard());

        boolean decision = cpuChecker.compatibilityCheck(set, cpu);
        assertTrue(decision);
    }

    @Test
    public void checkerShouldNotAllowToAssemble() {
        set.setMotherboard(motherboard);

        assertNotNull(motherboard);

        boolean flag = cpuChecker.compatibilityCheck(set, cpu);
        assertFalse(flag);
    }

}