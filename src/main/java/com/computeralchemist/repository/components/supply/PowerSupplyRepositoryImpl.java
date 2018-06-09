package com.computeralchemist.repository.components.supply;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.components.supply.PowerSupply;
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
 * 07-08-2018
 * */

@Repository
@CacheConfig(cacheNames = "componentCache")
public class PowerSupplyRepositoryImpl implements PowerSupplyRepository {
    private MongoOperations mongoOperations;
    private final String TYPE = "supply";

    @Autowired
    public void setMongoOperations(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public long count() {
        return mongoOperations.count(new Query(), PowerSupply.class, TYPE);
    }

    @Override
    public ComputerComponent save(PowerSupply computerComponent) {
        computerComponent.setProductId(nextId());
        mongoOperations.save(computerComponent, TYPE);
        return computerComponent;
    }

    @Override
    public void update(PowerSupply computerComponent) {
        mongoOperations.save(computerComponent);
    }

    @Override
    @Cacheable
    public PowerSupply findByProductId(long productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        return mongoOperations.findOne(query, PowerSupply.class, TYPE);
    }

    @Override
    @Cacheable
    public PowerSupply findByModel(String model) {
        Query query = new Query();
        query.addCriteria(Criteria.where("model").is(model));
        return mongoOperations.findOne(query, PowerSupply.class, TYPE);
    }

    @Override
    public List<PowerSupply> findAllComponents() {
        return mongoOperations.findAll(PowerSupply.class, TYPE);
    }

    @Override
    public void deleteByProductId(long productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        mongoOperations.remove(query, PowerSupply.class, TYPE);
    }
}
