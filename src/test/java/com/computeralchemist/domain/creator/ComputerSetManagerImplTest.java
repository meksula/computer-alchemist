package com.computeralchemist.domain.creator;

import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.domain.components.motherboard.MotherboardParameters;
import com.computeralchemist.domain.creator.setTypes.ComputerSet;
import com.computeralchemist.repository.components.motherboard.MotherboardRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * @Author
 * Karol Meksuła
 * 15-04-2018
 * */

//TODO kurwa... nie na się w ogóle testować tej klasy...
public class ComputerSetManagerImplTest {

    private ComputerSetManager manager = new ComputerSetManagerImpl();

    @Mock
    private MotherboardRepository motherboardRepository;

    private Motherboard motherboard = new Motherboard();
    private MotherboardParameters motherboardParameters = new MotherboardParameters();
    private final String MOTHER_SOCKET = "1151";

    @Before
    public void setUp() {
        motherboardParameters.setSocket(MOTHER_SOCKET);
        motherboard.setMotherboardParameters(motherboardParameters);

    }

    @Test
    public void injectionCorrect() {
        assertNotNull(manager);
        assertNotNull(motherboardRepository);

    }

    private final String TYPE = "motherboard";

    @Test
    public void assembleShouldBeAble() throws NothingHasChangedException {
        ComputerSet updatedSet = manager.assembleComponent(TYPE, 1);
    }

}