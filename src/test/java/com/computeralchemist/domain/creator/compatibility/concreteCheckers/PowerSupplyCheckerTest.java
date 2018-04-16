package com.computeralchemist.domain.creator.compatibility.concreteCheckers;

import com.computeralchemist.domain.components.gpu.GraphicsCard;
import com.computeralchemist.domain.components.supply.PowerSupply;
import com.computeralchemist.domain.components.supply.PowerSupplyParameters;
import com.computeralchemist.domain.creator.setTypes.ComputerSet;
import com.computeralchemist.domain.creator.setTypes.WorkComputerSet;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 15-04-2018
 * */

public class PowerSupplyCheckerTest {
    private PowerSupplyChecker checker = new PowerSupplyChecker();

    private ComputerSet set = new WorkComputerSet();
    private PowerSupply powerSupply = new PowerSupply();

    private PowerSupplyParameters parameters = new PowerSupplyParameters();

    private GraphicsCard graphicsCard = new GraphicsCard();

    private final int ENAUGH_POWER = 500;
    private final int NOT_ENAUGH_POWER = 300;

    @Before
    public void setUp() {
        parameters.setPower(NOT_ENAUGH_POWER);
        powerSupply.setPowerSupplyParameters(parameters);
        set.setPowerSupply(powerSupply);
        set.setGraphicsCard(graphicsCard);
    }

    @Test
    public void allowToAssemble() {
        parameters.setPower(ENAUGH_POWER);
        boolean b = checker.compatibilityCheck(set, powerSupply);
        assertTrue(b);
    }

    @Test
    public void notAllowToAssemble() {
        boolean b = checker.compatibilityCheck(set, powerSupply);
        assertFalse(b);
    }
}