package com.computeralchemist.repository.components.ram;

import com.computeralchemist.domain.components.disk.Disk;
import com.computeralchemist.domain.components.disk.DiskParameters;
import com.computeralchemist.domain.components.disk.DriveType;
import com.computeralchemist.domain.components.ram.Ram;
import com.computeralchemist.domain.components.ram.RamParameters;
import com.computeralchemist.repository.components.disk.DiskRepository;
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
public class RamRepositoryImplTest {

    @Autowired
    private RamRepository repository;

    private Ram ram = new Ram();
    private RamParameters parameters = new RamParameters();
    private final String MODEL = "Cr 543";
    private final String COOLER = "Radiator";

    @Before
    public void setUp() {
        parameters.setCooler(COOLER);
        ram.setRamParameters(parameters);
        ram.setModel(MODEL);
    }

    @Test
    public void beanInjectionTest() {
        assertNotNull(repository);
    }

    @Test
    public void shouldSaveAndFindById() {
        long id = repository.save(ram);

        Ram component = repository.findByProductId(id);
        assertEquals(MODEL, component.getModel());
        assertEquals(COOLER, component.getRamParameters().getCooler());
    }

    @Test
    public void countTest() {
        long amount = repository.count();
        assertEquals(1, amount);

        repository.save(ram);
        amount = repository.count();
        assertEquals(2, amount);
    }

    @Test
    public void findByModelTest() {
        repository.save(ram);

        Ram ram = repository.findByModel(MODEL);
        assertNotNull(ram);
        assertEquals(MODEL, ram.getModel());
    }

    @Test
    public void findAllComponentsTest() {
        List<Ram> list = repository.findAllComponents();
        long size = repository.count();
        assertEquals(size, list.size());
    }

    @Test
    public void deleteByProductIdTest() {
        String model = "Sea34";
        Ram component = new Ram();
        component.setModel(model);

        long id = repository.save(component);
        repository.deleteByProductId(id);

        assertNull(repository.findByModel(model));
    }
}