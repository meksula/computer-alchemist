package com.computeralchemist.repository.components.cpu;

import com.computeralchemist.domain.components.cpu.Cpu;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CpuRepositoryImpl implements CpuRepository {
    private MongoOperations mongoOperations;
    private final String TYPE = "cpu";

    @Autowired
    public void setMongoOperations(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public long count() {
        return mongoOperations.count(new Query(), TYPE);
    }

    @Override
    public long save(Cpu computerComponent) {
        computerComponent.setProductId(nextId());
        mongoOperations.save(computerComponent, TYPE);
        return computerComponent.getProductId();
    }

    @Override
    public void update(Cpu computerComponent) {
        mongoOperations.save(computerComponent);
    }

    @Override
    public Cpu findByProductId(long id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(id));
        return mongoOperations.findOne(query, Cpu.class, TYPE);
    }

    @Override
    public Cpu findByModel(String model) {
        Query query = new Query();
        query.addCriteria(Criteria.where("model").is(model));
        return mongoOperations.findOne(query, Cpu.class, TYPE);
    }

    @Override
    public List<Cpu> findAllComponents() {
        return mongoOperations.findAll(Cpu.class, TYPE);
    }

    @Override
    public void deleteByProductId(long productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        mongoOperations.remove(query, Cpu.class, TYPE);
    }
}
