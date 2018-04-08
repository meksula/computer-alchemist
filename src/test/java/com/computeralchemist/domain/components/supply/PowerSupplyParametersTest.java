package com.computeralchemist.domain.components.supply;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 07-08-2018
 * */

public class PowerSupplyParametersTest {
    private final String STANDARD = "ATX";
    private final int PWR = 650;
    private final String PFC = "active";
    private final String COOLER = "active-fan";
    private final boolean MODULAR = false;

    private List<String> prepareConnectorList() {
        List<String> connectors = new ArrayList<>();
        connectors.add("ATX 24-pin (20+4)");
        connectors.add("PCI-E 8-pin (6+2)");
        connectors.add("PCI-E 8-pin");
        return connectors;
    }

    private PowerSupplyParameters param;

    @Before
    public void setUp() {
        param = new PowerSupplyParameters();
        param.setConnectors(prepareConnectorList());
        param.setStandard(STANDARD);
        param.setPower(PWR);
        param.setPfc(PFC);
        param.setCooler(COOLER);
        param.setModularCable(MODULAR);
    }

    @Test
    public void instantiateTest() {
        assertEquals(STANDARD, param.getStandard());
        assertEquals(PWR, param.getPower());
        assertEquals(PFC, param.getPfc());
        assertEquals(COOLER, param.getCooler());
        assertEquals(MODULAR, param.isModularCable());
        assertEquals(3, param.getConnectors().size());
    }
}