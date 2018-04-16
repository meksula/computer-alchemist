package com.computeralchemist.domain.creator.compatibility.concreteCheckers;

import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.computerCase.ComputerCase;
import com.computeralchemist.domain.components.computerCase.ComputerCaseParameters;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.domain.components.motherboard.MotherboardParameters;
import com.computeralchemist.domain.creator.setTypes.GamingComputerSet;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 15-04-2018
 * */

public class ComputerCaseCheckerTest {
    private ComputerCaseChecker checker = new ComputerCaseChecker();

    private GamingComputerSet computerSet = new GamingComputerSet();
    private Motherboard mobo = new Motherboard();
    private MotherboardParameters moboParams = new MotherboardParameters();
    private final String MOBO_TYPE = "ATX";

    private ComputerCase computerCase = new ComputerCase();
    private ComputerCaseParameters caseParameters = new ComputerCaseParameters();
    private final double WIDTH = 60;

    @Before
    public void setUp() {
        computerSet.setMotherboard(mobo);

        mobo.setComponentType(ComponentType.motherboard);
        moboParams.setType(MOBO_TYPE);
        mobo.setMotherboardParameters(moboParams);

        caseParameters.setCompatibilityMotherboards(Arrays.asList(MOBO_TYPE, "mATX", "microATX"));
        caseParameters.setWidth(WIDTH);
        computerCase.setComputerCaseParameters(caseParameters);

    }

    @Test
    public void checkerShouldAllowToAssemble() {
        boolean flag = checker.compatibilityCheck(computerSet, computerCase);
        assertTrue(flag);
    }

    @Test
    public void checkerShouldNotAllowToAssemble() {
        moboParams.setType("xATX");
        boolean flag = checker.compatibilityCheck(computerSet, computerCase);
        assertFalse(flag);
    }
}