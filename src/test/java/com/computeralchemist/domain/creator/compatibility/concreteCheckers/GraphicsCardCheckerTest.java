package com.computeralchemist.domain.creator.compatibility.concreteCheckers;

import com.computeralchemist.domain.components.gpu.GraphicsCard;
import com.computeralchemist.domain.components.gpu.GraphicsCardParameters;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.domain.components.motherboard.MotherboardParameters;
import com.computeralchemist.domain.creator.setTypes.ComputerSet;
import com.computeralchemist.domain.creator.setTypes.GamingComputerSet;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 15-04-2018
 * */

public class GraphicsCardCheckerTest {
    private GraphicsCardChecker graphicsCardChecker = new GraphicsCardChecker();

    private ComputerSet computerSet = new GamingComputerSet();

    private GraphicsCard graphicsCard = new GraphicsCard();
    private GraphicsCardParameters graphicsCardParameters = new GraphicsCardParameters();
    private Motherboard motherboard = new Motherboard();
    private MotherboardParameters motherboardParameters = new MotherboardParameters();

    private final String CONNECTOR = "PCI express 16x";

    @Before
    public void setUp() {
        graphicsCardParameters.setMainConnectorType(CONNECTOR);
        motherboardParameters.setOtherSockets(Arrays.asList(CONNECTOR));

        graphicsCard.setGraphicsCardParameters(graphicsCardParameters);
        motherboard.setMotherboardParameters(motherboardParameters);

        computerSet.setMotherboard(motherboard);
    }

    @Test
    public void checkerShouldAllowAssemble() {
        boolean flag = graphicsCardChecker.compatibilityCheck(computerSet, graphicsCard);
        assertTrue(flag);
    }

    @Test
    public void checkerShouldNotAllowAssemble() {
        graphicsCard.getGraphicsCardParameters().setMainConnectorType(CONNECTOR + "ti");
        boolean flag = graphicsCardChecker.compatibilityCheck(computerSet, graphicsCard);
        assertFalse(flag);
    }
}