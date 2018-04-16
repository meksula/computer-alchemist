package com.computeralchemist.domain.creator.compatibility.concreteCheckers;

import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.domain.creator.setTypes.GamingComputerSet;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 15-04-2018
 * */

public class CpuCheckerTest {
    private CpuChecker cpuChecker = new CpuChecker();

    @Mock
    private GamingComputerSet set;

    @Mock
    private Motherboard motherboard;

    @Test
    public void setCpuCheckerReturnAlwaysTrue() {
        boolean decision = cpuChecker.compatibilityCheck(set, motherboard);
        assertTrue(decision);
    }
}