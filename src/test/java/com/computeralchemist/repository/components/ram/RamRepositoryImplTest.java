package com.computeralchemist.repository.components.ram;

import com.computeralchemist.config.RootConfig;
import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.ram.Ram;
import com.computeralchemist.domain.components.ram.RamParameters;
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
 * 06-04-2018
 * */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class RamRepositoryImplTest {

    @Autowired
    private RamRepository ramRepository;

    @Test
    public void injectionTest() {
        assertNotNull(ramRepository);
    }

    @Test
    public void countTest() {
        long size = ramRepository.count();
        assertEquals(0, size);
    }

    private final long ID = 10000;
    private final String MODEL = "DVscw3";
    private final String PRODUCENT = "MACWECEJ";

    private Ram provideRam() {
        RamParameters parameters = mock(RamParameters.class);

        Ram ram = new Ram();
        ram.setProductId(ID);
        ram.setProducent(PRODUCENT);
        ram.setModel(MODEL);
        ram.setComponentType(ComponentType.RAM);
        ram.setRamParameters(parameters);

        return ram;
    }

    @Test
    public void saveTest() {
        ramRepository.save(provideRam());

        Ram ram = ramRepository.findByProductId(ID);
        assertEquals(ID, ram.getProductId());
        assertEquals(PRODUCENT, ram.getProducent());
        assertEquals(MODEL, ram.getModel());
        assertTrue(ram.getComponentType() == ComponentType.RAM);
    }

    @Test
    public void ableToRemoveTest() {
        ramRepository.deleteByProductId(ID);

        Ram ram = ramRepository.findByProductId(ID);
        assertNull(ram);
    }
}