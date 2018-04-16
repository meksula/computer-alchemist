package com.computeralchemist.domain.components;

import com.computeralchemist.repository.RepositoryProvider;
import lombok.extern.slf4j.Slf4j;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 15-04-2018
 * */

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class RepositoryMapperTest {
    private final String JSON = "{\"componentType\":\"cpu\",\"producent\":\"Intel\",\"model\":\"Celeron G3900\",\"description\":\"Dwa wydajne rdzenie fizyczne! Dedykowany do zestawów biurowych!\",\"urlToResource\":null,\"compatibleIndex\":4.0,\"votes\":0,\"productId\":2,\"cpuParameters\":{\"cores\":2,\"series\":\"Celeron\",\"socket\":\"1151\",\"threads\":2,\"bitArchitecture\":\"64bit\",\"cache\":2,\"frequency\":2.8}}";
    private final String PRODUCENT = "Intel";
    private final String MODEL = "Celeron G3900";

    @Autowired
    private RepositoryProvider repositoryMapper;

    @Test
    public void instantiateTest() {
        assertNotNull(repositoryMapper);
    }

    @Test
    public void saveComponentTest() {
        repositoryMapper.saveComponent(JSON);
    }

    @Test
    public void findComponentTest() {
        ComputerComponent component = repositoryMapper.findComponent("cpu", 1);
        assertEquals(PRODUCENT, component.getProducent());
        assertEquals(MODEL, component.getModel());
    }



}