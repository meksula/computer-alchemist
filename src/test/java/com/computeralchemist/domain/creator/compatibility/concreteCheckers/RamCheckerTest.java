package com.computeralchemist.domain.creator.compatibility.concreteCheckers;

import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.domain.components.motherboard.MotherboardParameters;
import com.computeralchemist.domain.components.ram.Ram;
import com.computeralchemist.domain.components.ram.RamParameters;
import com.computeralchemist.domain.creator.setTypes.GamingComputerSet;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 15-04-2018
 * */

public class RamCheckerTest {
    private RamChecker ramChecker = new RamChecker();

    private GamingComputerSet set = new GamingComputerSet();
    private Motherboard motherboard = new Motherboard();
    private MotherboardParameters motherboardParameters = new MotherboardParameters();

    private Ram ram = new Ram();
    private RamParameters ramParameters = new RamParameters();

    private final double FREQ_A = 4567;
    private final double FREQ_B = 5567;
    private final String MEM_TYPE = "DDR4";

    @Before
    public void setUp() {
        motherboardParameters.setMemoryFrequency(FREQ_A);
        motherboardParameters.setMemoryType(MEM_TYPE);
        motherboard.setMotherboardParameters(motherboardParameters);

        ramParameters.setMemoryType(MEM_TYPE);
        ramParameters.setFrequency(FREQ_A);
        ram.setRamParameters(ramParameters);

        set.setMotherboard(motherboard);
    }

    @Test
    public void compatibitilyCheckShouldReturnTrue() {
        boolean flag = ramChecker.compatibilityCheck(set, ram);
        assertTrue(flag);
    }

    @Test
    public void compatibilityCheckShouldReturnFalse() {
        ramParameters.setFrequency(FREQ_B);
        boolean flag = ramChecker.compatibilityCheck(set, ram);
        assertFalse(flag);
    }
}