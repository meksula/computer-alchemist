package com.computeralchemist.config;

import com.mongodb.MongoClient;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 02-04-2018
 * */

public class DataSourceConfigTest {
    private DataSourceConfig dataSourceConfig = new DataSourceConfig();
    private final String DB_NAME = "computeralchemist";

    @Test
    public void mongoClientInstantiateCorrectly() {
        MongoClient mongoClient = dataSourceConfig.mongoClient();
        assertNotNull(mongoClient);
    }

    @Test
    public void shouldReturnNameOfDatabase() {
        assertEquals(DB_NAME, dataSourceConfig.getDatabaseName());
    }
}