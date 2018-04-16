package com.computeralchemist.domain.creator.compatibility.concreteCheckers;

import com.computeralchemist.domain.components.cpu.Cpu;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.domain.creator.setTypes.GamingComputerSet;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.security.core.parameters.P;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.booleanThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;

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