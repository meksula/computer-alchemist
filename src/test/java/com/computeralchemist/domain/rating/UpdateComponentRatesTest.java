package com.computeralchemist.domain.rating;

import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.components.OpinionDto;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.repository.RepositoryProvider;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 24-04-2018
 * */

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class UpdateComponentRatesTest {

    @Autowired
    private UpdateComponentRates updateComponentRates;

    @Autowired
    private RepositoryProvider repositoryProvider;

    private OpinionDto opinionDto = new OpinionDto();
    private Motherboard mobo = new Motherboard();

    private final long EXPECTED_ID = 1;
    private final String TYPE = "motherboard";
    private final String PRODUCENT = "Gigabyte";
    private final String MODEL = "GT345";

    private final double RATE = 4;

    private final double DELTA = 1e-15;

    @Before
    public void setUp() {
        mobo.setProducent(PRODUCENT);
        mobo.setModel(MODEL);
        mobo.setComponentType(ComponentType.motherboard);

        opinionDto.setRate(RATE);
        opinionDto.setComponentType(ComponentType.motherboard);
        opinionDto.setProductId(EXPECTED_ID);
    }

    @Test
    public void componentExistInDatabase() {
        repositoryProvider.saveComponent(mobo);

        ComputerComponent component = repositoryProvider.findComponent(TYPE, EXPECTED_ID);
        assertNotNull(component);
    }

    @Test
    public void aspectMethodShouldModifyFieldsOfComponentAndUpdateDocument() {
        updateComponentRates.updateComponentRate(opinionDto);

        ComputerComponent updated = repositoryProvider.findComponent(TYPE, EXPECTED_ID);
        assertEquals(PRODUCENT, updated.getProducent());

        List<ComputerComponent> comps = repositoryProvider.getListOfComputerComponent("motherboard");
        assertEquals(1, comps.size());
    }

}