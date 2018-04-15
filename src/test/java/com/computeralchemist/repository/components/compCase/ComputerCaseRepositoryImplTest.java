package com.computeralchemist.repository.components.compCase;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.components.computerCase.ComputerCase;
import com.computeralchemist.domain.components.computerCase.ComputerCaseParameters;
import lombok.extern.slf4j.Slf4j;
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
 * 14-04-2018
 * */

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.JVM)
public class ComputerCaseRepositoryImplTest {

    @Autowired
    private ComputerCaseRepository repository;

    private ComputerCase computerCase = new ComputerCase();
    private ComputerCaseParameters parameters = new ComputerCaseParameters();
    private final String MODEL = "Dragon-100x";
    private final String TYPE = "Midi Tower";


    @Before
    public void setUp() {
        parameters.setType(TYPE);
        computerCase.setComputerCaseParameters(parameters);
        computerCase.setModel(MODEL);
    }

    @Test
    public void beanInjectionTest() {
        assertNotNull(repository);
    }

    @Test
    public void shouldSaveAndFindById() {
        long id = repository.save(computerCase);

        ComputerCase component = repository.findByProductId(id);
        assertEquals(MODEL, component.getModel());
        assertEquals(TYPE, component.getComputerCaseParameters().getType());
    }

    @Test
    public void countTest() {
        long amount = repository.count();
        assertEquals(1, amount);

        repository.save(computerCase);
        amount = repository.count();
        assertEquals(2, amount);
    }

    @Test
    public void findByModelTest() {
        repository.save(computerCase);

        ComputerCase computerCase = repository.findByModel(MODEL);
        assertNotNull(computerCase);
        assertEquals(MODEL, computerCase.getModel());
    }

    @Test
    public void findAllComponentsTest() {
        List<ComputerCase> list = repository.findAllComponents();
        long size = repository.count();
        assertEquals(size, list.size());
    }

    @Test
    public void deleteByProductIdTest() {
        String model = "DGC6";
        ComputerComponent component = new ComputerCase();
        component.setModel(model);

        long id = repository.save(computerCase);
        repository.deleteByProductId(id);

        assertNull(repository.findByModel(model));
    }
}