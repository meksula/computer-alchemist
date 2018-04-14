package com.computeralchemist.domain.components.supply;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * @Author
 * Karol Meksuła
 * 07-08-2018
 * */

public class PowerSupplyTest {
    private PowerSupply powerSupply = new PowerSupply();
    private PowerSupplyParameters param = mock(PowerSupplyParameters.class);
    private final long ID = 129441;

    @Before
    public void setUp() {
        powerSupply.setPowerSupplyParameters(param);
        powerSupply.setProductId(ID);
    }

    @Test
    public void instantiateTest() {
        assertNotNull(powerSupply.getPowerSupplyParameters());
        assertEquals(ID, powerSupply.getProductId());
    }
}