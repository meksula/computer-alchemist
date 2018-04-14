package com.computeralchemist.domain.components.ram;

import com.computeralchemist.domain.components.ComponentType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * @Author
 * Karol Meksuła
 * 05-04-2018
 * */

public class RamTest {
    private Ram ram = new Ram();
    private final long ID = 139392;
    private RamParameters ramParameters = mock(RamParameters.class);

    @Before
    public void setUp() {
        ram.setProductId(ID);
        ram.setRamParameters(ramParameters);

        ram.setCompatibleIndex(2.3);
        ram.setComponentType(ComponentType.ram);
    }

    @Test
    public void instantiateTest() {
        assertNotNull(ram);
        assertNotNull(ram.getRamParameters());
        assertEquals(ID, ram.getProductId());
    }

    @Test
    public void setComponentFields() {
        assertEquals(2.3, ram.getCompatibleIndex(), 1e-15);
    }

    @Test
    public void componentTypeFromEnumTest() {
        assertEquals(ComponentType.ram, ram.getComponentType());
    }
}