package com.computeralchemist.repository.components.supply;

import com.computeralchemist.domain.components.ram.Ram;
import com.computeralchemist.domain.components.ram.RamParameters;
import com.computeralchemist.domain.components.supply.PowerSupply;
import com.computeralchemist.domain.components.supply.PowerSupplyParameters;
import com.computeralchemist.repository.components.ram.RamRepository;
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
@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringRunner.class)
@SpringBootTest
public class PowerSupplyRepositoryImplTest {

    @Autowired
    private PowerSupplyRepository repository;

    private PowerSupply powerSupply = new PowerSupply();
    private PowerSupplyParameters parameters = new PowerSupplyParameters();
    private final String MODEL = "Corsair 344k";
    private final String COOLER = "Radiator";

    @Before
    public void setUp() {
        parameters.setCooler(COOLER);
        powerSupply.setPowerSupplyParameters(parameters);
        powerSupply.setModel(MODEL);
    }

    @Test
    public void beanInjectionTest() {
        assertNotNull(repository);
    }

    @Test
    public void shouldSaveAndFindById() {
        long id = repository.save(powerSupply);

        PowerSupply component = repository.findByProductId(id);
        assertEquals(MODEL, component.getModel());
        assertEquals(COOLER, component.getPowerSupplyParameters().getCooler());
    }

    @Test
    public void countTest() {
        long amount = repository.count();
        assertEquals(1, amount);

        repository.save(powerSupply);
        amount = repository.count();
        assertEquals(2, amount);
    }

    @Test
    public void findByModelTest() {
        repository.save(powerSupply);

        PowerSupply powerSupply = repository.findByModel(MODEL);
        assertNotNull(powerSupply);
        assertEquals(MODEL, powerSupply.getModel());
    }

    @Test
    public void findAllComponentsTest() {
        List<PowerSupply> list = repository.findAllComponents();
        long size = repository.count();
        assertEquals(size, list.size());
    }

    @Test
    public void deleteByProductIdTest() {
        String model = "Seda3434";
        PowerSupply component = new PowerSupply();
        component.setModel(model);

        long id = repository.save(component);
        repository.deleteByProductId(id);

        assertNull(repository.findByModel(model));
    }
}