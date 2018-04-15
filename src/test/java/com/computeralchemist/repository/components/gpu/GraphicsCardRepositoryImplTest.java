package com.computeralchemist.repository.components.gpu;

import com.computeralchemist.domain.components.gpu.GraphicsCard;
import com.computeralchemist.domain.components.gpu.GraphicsCardParameters;
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
public class GraphicsCardRepositoryImplTest {

    @Autowired
    private GraphicsCardRepository repository;

    private GraphicsCard gpu = new GraphicsCard();
    private GraphicsCardParameters parameters = new GraphicsCardParameters();
    private final String MODEL = "GTX500ti";
    private final String RSLTN = "7239x4522";

    @Before
    public void setUp() {
        parameters.setResolution(RSLTN);
        gpu.setGraphicsCardParameters(parameters);
        gpu.setModel(MODEL);
    }

    @Test
    public void beanInjectionTest() {
        assertNotNull(repository);
    }

    @Test
    public void shouldSaveAndFindById() {
        long id = repository.save(gpu);

        GraphicsCard graphicsCard = repository.findByProductId(id);
        assertEquals(MODEL, graphicsCard.getModel());
        assertEquals(RSLTN, graphicsCard.getGraphicsCardParameters().getResolution());
    }

    @Test
    public void countTest() {
        long amount = repository.count();
        assertEquals(1, amount);

        repository.save(gpu);
        amount = repository.count();
        assertEquals(2, amount);
    }

    @Test
    public void findByModelTest() {
        repository.save(gpu);

        GraphicsCard graphicsCard = repository.findByModel(MODEL);
        assertNotNull(graphicsCard);
        assertEquals(MODEL, graphicsCard.getModel());
    }

    @Test
    public void findAllComponentsTest() {
        List<GraphicsCard> list = repository.findAllComponents();
        long size = repository.count();
        assertEquals(size, list.size());
    }

    @Test
    public void deleteByProductIdTest() {
        String model = "Geforce 332s";
        GraphicsCard component = new GraphicsCard();
        component.setModel(model);

        long id = repository.save(component);
        repository.deleteByProductId(id);

        assertNull(repository.findByModel(model));
    }
}