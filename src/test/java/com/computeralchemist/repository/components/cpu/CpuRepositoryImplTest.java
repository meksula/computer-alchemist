package com.computeralchemist.repository.components.cpu;

import com.computeralchemist.config.RootConfig;
import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.cpu.Cpu;
import com.computeralchemist.domain.components.cpu.CpuParameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * @Author
 * Karol Meksuła
 * 05-04-2018
 * */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class CpuRepositoryImplTest {

    //TODO napisać testy z embedded database, a nie z bazą produkcyjną...

    /*@Autowired
    private CpuRepository cpuRepository;

    @Test
    public void injectionTest() {
        assertNotNull(cpuRepository);
    }

    @Test
    public void countTest() {
        long size = cpuRepository.count();
        assertEquals(0, size);
    }

    private final long ID = 10000;
    private final String MODEL = "DVscw3";
    private final String PRODUCENT = "MACWECEJ";

    private Cpu provideCpu() {
        CpuParameters parameters = mock(CpuParameters.class);

        Cpu cpu = new Cpu();
        cpu.setProductId(ID);
        cpu.setProducent(PRODUCENT);
        cpu.setModel(MODEL);
        cpu.setComponentType(ComponentType.CPU);
        cpu.setCpuParameters(parameters);

        return cpu;
    }

    @Test
    public void saveTest() {
        cpuRepository.save(provideCpu());

        Cpu cpu = cpuRepository.findByProductId(ID);
        assertEquals(ID, cpu.getProductId());
        assertEquals(PRODUCENT, cpu.getProducent());
        assertEquals(MODEL, cpu.getModel());
        assertTrue(cpu.getComponentType() == ComponentType.CPU);
    }

    @Test
    public void ableToRemoveTest() {
        cpuRepository.deleteByProductId(ID);

        Cpu cpu = cpuRepository.findByProductId(ID);
        assertNull(cpu);
    }*/
}