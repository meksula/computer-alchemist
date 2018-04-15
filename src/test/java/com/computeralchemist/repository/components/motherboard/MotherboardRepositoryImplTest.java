package com.computeralchemist.repository.components.motherboard;

import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.domain.components.motherboard.MotherboardParameters;
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

@Slf4j
@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringRunner.class)
@SpringBootTest
public class MotherboardRepositoryImplTest {

    @Autowired
    private MotherboardRepository repository;

    private Motherboard motherboard = new Motherboard();
    private MotherboardParameters parameters = new MotherboardParameters();
    private final String MODEL = "Gigabyte 4312";
    private final String SOCKET = "1151";

    @Before
    public void setUp() {
        parameters.setSocket(SOCKET);
        motherboard.setMotherboardParameters(parameters);
        motherboard.setModel(MODEL);
    }

    @Test
    public void beanInjectionTest() {
        assertNotNull(repository);
    }

    @Test
    public void shouldSaveAndFindById() {
        long id = repository.save(motherboard);

        Motherboard motherboard = repository.findByProductId(id);
        assertEquals(MODEL, motherboard.getModel());
        assertEquals(SOCKET, motherboard.getMotherboardParameters().getSocket());
    }

    @Test
    public void countTest() {
        long amount = repository.count();
        assertEquals(1, amount);

        repository.save(motherboard);
        amount = repository.count();
        assertEquals(2, amount);
    }

    @Test
    public void findByModelTest() {
        repository.save(motherboard);

        Motherboard motherboard = repository.findByModel(MODEL);
        assertNotNull(motherboard);
        assertEquals(MODEL, motherboard.getModel());
    }

    @Test
    public void findAllComponentsTest() {
        List<Motherboard> list = repository.findAllComponents();
        long size = repository.count();
        assertEquals(size, list.size());
    }

    @Test
    public void deleteByProductIdTest() {
        String model = "MSI 332s";
        Motherboard component = new Motherboard();
        component.setModel(model);

        long id = repository.save(component);
        repository.deleteByProductId(id);

        assertNull(repository.findByModel(model));
    }
}