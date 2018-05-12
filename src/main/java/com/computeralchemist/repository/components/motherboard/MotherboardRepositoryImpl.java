package com.computeralchemist.repository.components.motherboard;

import com.computeralchemist.domain.components.motherboard.Motherboard;
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
 * 05-04-2018
 * */

@Repository
@CacheConfig(cacheNames = "componentCache")
public class MotherboardRepositoryImpl implements MotherboardRepository {
    private MongoOperations mongoOperations;
    private final String TYPE = "motherboard";

    @Autowired
    public void setMongoOperations(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public long count() {
        return mongoOperations.count(new Query(), Motherboard.class, TYPE);
    }

    @Override
    public long save(Motherboard computerComponent) {
        computerComponent.setProductId(nextId());
        mongoOperations.save(computerComponent, TYPE);
        return computerComponent.getProductId();
    }

    @Override
    public void update(Motherboard computerComponent) {
        mongoOperations.save(computerComponent);
    }

    @Override
    @Cacheable
    public Motherboard findByProductId(long productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        return mongoOperations.findOne(query, Motherboard.class, TYPE);
    }

    @Override
    @Cacheable
    public Motherboard findByModel(String model) {
        Query query = new Query();
        query.addCriteria(Criteria.where("model").is(model));
        return mongoOperations.findOne(query,Motherboard.class, TYPE);
    }

    @Override
    public List<Motherboard> findAllComponents() {
        return mongoOperations.findAll(Motherboard.class, TYPE);
    }

    @Override
    public void deleteByProductId(long productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        mongoOperations.remove(query, Motherboard.class, TYPE);
    }
}
