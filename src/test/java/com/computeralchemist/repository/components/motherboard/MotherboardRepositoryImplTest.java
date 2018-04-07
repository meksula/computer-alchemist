package com.computeralchemist.repository.components.motherboard;

import com.computeralchemist.config.RootConfig;
import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.domain.components.motherboard.MotherboardParameters;
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
public class MotherboardRepositoryImplTest {

    //TODO napisać testy z embedded database, a nie z bazą produkcyjną...

    /*@Autowired
    private MotherboardRepository motherboardRepository;

    @Test
    public void injectionTest() {
        assertNotNull(motherboardRepository);
    }

    @Test
    public void countTest() {
        long size = motherboardRepository.count();
        assertEquals(1, size);
    }

    private final long ID = 10000;
    private final String MODEL = "DVscw3";
    private final String PRODUCENT = "MACWECEJ";

    private Motherboard provideMotherboard() {
        MotherboardParameters parameters = mock(MotherboardParameters.class);

        Motherboard motherboard = new Motherboard();
        motherboard.setProductId(ID);
        motherboard.setProducent(PRODUCENT);
        motherboard.setModel(MODEL);
        motherboard.setComponentType(ComponentType.MOTHERBOARD);
        motherboard.setMotherboardParameters(parameters);

        return motherboard;
    }

    @Test
    public void saveTest() {
        motherboardRepository.save(provideMotherboard());

        Motherboard motherboard = motherboardRepository.findByProductId(ID);
        assertEquals(ID, motherboard.getProductId());
        assertEquals(PRODUCENT, motherboard.getProducent());
        assertEquals(MODEL, motherboard.getModel());
        assertTrue(motherboard.getComponentType() == ComponentType.MOTHERBOARD);
    }

    @Test
    public void ableToRemoveTest() {
        motherboardRepository.deleteByProductId(ID);

        Motherboard motherboard = motherboardRepository.findByProductId(ID);
        assertNull(motherboard);
    }*/
}