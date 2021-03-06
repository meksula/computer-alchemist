package com.computeralchemist.repository.components.compCase;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.components.computerCase.ComputerCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 09-04-2018
 * */

@Repository
@CacheConfig(cacheNames = "componentCache")
public class ComputerCaseRepositoryImpl implements ComputerCaseRepository {
    private MongoOperations mongoOperations;
    private final String TYPE = "computercase";

    @Autowired
    public void setMongoOperations(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public long count() {
        return mongoOperations.count(new Query(), TYPE);
    }

    @Override
    public ComputerComponent save(ComputerCase computerComponent) {
        computerComponent.setProductId(nextId());
        mongoOperations.save(computerComponent, TYPE);
        return computerComponent;
    }

    @Override
    public void update(ComputerCase computerComponent) {
        mongoOperations.save(computerComponent);
    }

    @Override
    @Cacheable(value = "componentCache")
    public ComputerCase findByProductId(long productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        return mongoOperations.findOne(query, ComputerCase.class, TYPE);
    }

    @Override
    @Cacheable(value = "componentCache")
    public ComputerCase findByModel(String model) {
        Query query = new Query();
        query.addCriteria(Criteria.where("model").is(model));
        return mongoOperations.findOne(query, ComputerCase.class, TYPE);
    }

    @Override
    @Cacheable(value = "componentCache")
    public List<ComputerCase> findAllComponents() {
        return mongoOperations.findAll(ComputerCase.class, TYPE);
    }

    @Override
    public void deleteByProductId(long productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        mongoOperations.remove(query, ComputerCase.class, TYPE);
    }

}
