package com.computeralchemist.domain.components.computerCase;

import com.computeralchemist.domain.components.ComponentType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * @Author
 * Karol Meksuła
 * 09-04-2018
 * */

public class ComputerCaseTest {
    private ComputerCase computerCase = new ComputerCase();
    private ComputerCaseParameters parameters = mock(ComputerCaseParameters.class);
    private long ID = 1231241;
    private final String MODEL = "SilentiumPC";
    private final String TYPE = "computercase";

    @Before
    public void setUp() {
        computerCase.setProductId(ID);
        computerCase.setComputerCaseParameters(parameters);
        computerCase.setComponentType(ComponentType.valueOf(TYPE));
        computerCase.setModel(MODEL);
    }

    @Test
    public void instantiateTest() {
        assertEquals(ID, computerCase.getProductId());
        assertEquals(MODEL, computerCase.getModel());
        assertEquals(TYPE, computerCase.getComponentType().toString());
        assertNotNull(computerCase.getComputerCaseParameters());
    }
}