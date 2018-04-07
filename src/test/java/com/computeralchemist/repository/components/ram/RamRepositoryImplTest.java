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

    //TODO napisać testy z embedded database, a nie z bazą produkcyjną...

    /*@Autowired
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

    private final String MODEL = "DVscw3";
    private final String PRODUCENT = "MACWECEJ";

    private Ram provideRam() {

    }

    @Test
    public void saveTest() {

    }

    @Test
    public void ableToRemoveTest() {

    }*/
}