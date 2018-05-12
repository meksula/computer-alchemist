package com.computeralchemist.domain.creator.fitter;

import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.cpu.Cpu;
import com.computeralchemist.domain.components.cpu.CpuParameters;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.domain.components.motherboard.MotherboardParameters;
import com.computeralchemist.domain.creator.setTypes.ComputerSet;
import com.computeralchemist.domain.creator.setTypes.GamingComputerSet;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * @Author
 * Karol Meksuła
 * 21-04-2018
 * */

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class ComputerFitterImplTest {

    @Autowired
    private ComputerFitter computerFitter;

    @Test
    public void injectionTest() {
        assertNotNull(computerFitter);
    }

    private ComputerSet computerSet = new GamingComputerSet();

    private Motherboard motherboard = new Motherboard();
    private MotherboardParameters motherboardParameters = new MotherboardParameters();

    private Cpu cpu = new Cpu();
    private CpuParameters cpuParameters = new CpuParameters();

    private final String CPU_PRODUCENT = "Intel";
    private final String MOBO_PRODUCENT = "Gigabyte";

    @Before
    public void setUp() {
        computerSet.setMotherboard(motherboard);

        motherboard.setProducent(MOBO_PRODUCENT);
        cpu.setProducent(CPU_PRODUCENT);

        motherboard.setMotherboardParameters(motherboardParameters);
        cpu.setCpuParameters(cpuParameters);

        motherboard.setComponentType(ComponentType.motherboard);
        cpu.setComponentType(ComponentType.cpu);
    }

    @Test
    public void instantiateTest() {
        assertEquals(MOBO_PRODUCENT, computerSet.getMotherboard().getProducent());
        assertEquals(CPU_PRODUCENT, cpu.getProducent());
    }

    @Test
    public void computerSetShouldNotHasCpu() {
        assertNull(computerSet.getCpu());
    }

    @Test
    public void assembleShouldWorkCorrectly() {
        computerFitter.assembleComputerSet(computerSet, cpu);
        assertNotNull(computerSet.getCpu());
        assertEquals(CPU_PRODUCENT, computerSet.getCpu().getProducent());
    }

    @Test(expected = AssembleSetException.class)
    public void assembleShouldThrowException() {
        GamingComputerSet set = mock(GamingComputerSet.class);

        computerFitter.assembleComputerSet(set, null);
    }

}