package com.computeralchemist.repository.components.cpu;

import com.computeralchemist.domain.components.cpu.Cpu;
import com.computeralchemist.domain.components.cpu.CpuParameters;
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
public class CpuRepositoryImplTest {

    @Autowired
    private CpuRepository repository;

    private Cpu cpu = new Cpu();
    private CpuParameters parameters = new CpuParameters();
    private final String MODEL = "Core i3";
    private final String SOCKET = "1151";

    @Before
    public void setUp() {
        parameters.setSocket(SOCKET);
        cpu.setCpuParameters(parameters);
        cpu.setModel(MODEL);
    }

    @Test
    public void beanInjectionTest() {
        assertNotNull(repository);
    }

    @Test
    public void shouldSaveAndFindById() {
        long id = repository.save(cpu);

        Cpu component = repository.findByProductId(id);
        assertEquals(MODEL, component.getModel());
        assertEquals(SOCKET, component.getCpuParameters().getSocket());
    }

    @Test
    public void countTest() {
        long amount = repository.count();
        assertEquals(1, amount);

        repository.save(cpu);
        amount = repository.count();
        assertEquals(2, amount);
    }

    @Test
    public void findByModelTest() {
        repository.save(cpu);

        Cpu computerCase = repository.findByModel(MODEL);
        assertNotNull(computerCase);
        assertEquals(MODEL, computerCase.getModel());
    }

    @Test
    public void findAllComponentsTest() {
        List<Cpu> list = repository.findAllComponents();
        long size = repository.count();
        assertEquals(size, list.size());
    }

    @Test
    public void deleteByProductIdTest() {
        String model = "i7";
        Cpu component = new Cpu();
        component.setModel(model);

        long id = repository.save(component);
        repository.deleteByProductId(id);

        assertNull(repository.findByModel(model));
    }
}