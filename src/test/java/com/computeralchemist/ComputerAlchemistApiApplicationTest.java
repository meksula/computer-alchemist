package com.computeralchemist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ComputerAlchemistApiApplicationTest {

    @Autowired
    private CacheManager cacheManager;

    @Test
    public void instantiateBeanTest() {
        assertNotNull(cacheManager);
    }
}