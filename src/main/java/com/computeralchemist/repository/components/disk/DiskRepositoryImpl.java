package com.computeralchemist.repository.components.disk;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.components.disk.Disk;
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
 * 07-04-2018
 * */

@Repository
@CacheConfig(cacheNames = "componentCache")
public class DiskRepositoryImpl implements DiskRepository {
    private MongoOperations mongoOperations;
    private final String TYPE = "disk";

    @Autowired
    public void setMongoOperations(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public long count() {
        return mongoOperations.count(new Query(), Disk.class, TYPE);
    }

    @Override
    public ComputerComponent save(Disk computerComponent) {
        computerComponent.setProductId(nextId());
        mongoOperations.save(computerComponent, TYPE);
        return computerComponent;
    }

    @Override
    public void update(Disk computerComponent) {
        mongoOperations.save(computerComponent);
    }

    @Override
    @Cacheable
    public Disk findByProductId(long productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        return mongoOperations.findOne(query, Disk.class, TYPE);
    }

    @Override
    @Cacheable
    public Disk findByModel(String model) {
        Query query = new Query();
        query.addCriteria(Criteria.where("model").is(model));
        return mongoOperations.findOne(query, Disk.class, TYPE);
    }

    @Override
    public List<Disk> findAllComponents() {
        return mongoOperations.findAll(Disk.class, TYPE);
    }

    @Override
    public void deleteByProductId(long productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        mongoOperations.remove(query, Disk.class, TYPE);
    }
}
