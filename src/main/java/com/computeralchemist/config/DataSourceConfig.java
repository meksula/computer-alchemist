package com.computeralchemist.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @Author
 * Karol Meksuła
 * 28-03-2018
 * */

@Configuration
@EnableMongoRepositories(basePackages = "com.computeralchemist.repository")
public class DataSourceConfig extends AbstractMongoConfiguration {

    @Override
    public MongoClient mongoClient() {
        return new MongoClient();
    }

    @Override
    protected String getDatabaseName() {
        return "computeralchemist";
    }
}
