package com.computeralchemist.domain.components.cpu;

import com.computeralchemist.domain.components.ComponentType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * @Author
 * Karol Meksuła
 * 03-04-2018
 * */

public class CpuTest {
    private Cpu cpu = new Cpu();
    private final long ID = 139392;
    private CpuParameters cpuParameters = mock(CpuParameters.class);

    @Before
    public void setUp() {
        cpu.setProductId(ID);
        cpu.setCpuParameters(cpuParameters);

        cpu.setCompatibleIndex(2.3);
        cpu.setComponentType(ComponentType.cpu);
    }

    @Test
    public void instantiateTest() {
        assertNotNull(cpu);
        assertNotNull(cpu.getCpuParameters());
        assertEquals(ID, cpu.getProductId());
    }

    @Test
    public void setComponentFields() {
        assertEquals(2.3, cpu.getCompatibleIndex(), 1e-15);
    }

    @Test
    public void componentTypeFromEnumTest() {
        assertEquals(ComponentType.cpu, cpu.getComponentType());
    }
}