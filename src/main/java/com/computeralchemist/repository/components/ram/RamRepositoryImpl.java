package com.computeralchemist.repository.components.ram;

import com.computeralchemist.domain.components.ram.Ram;
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
public class RamRepositoryImpl implements RamRepository {
    private MongoOperations mongoOperations;
    private final String TYPE = "ram";

    @Autowired
    public void setMongoOperations(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public long count() {
        return mongoOperations.count(new Query(), Ram.class, TYPE);
    }

    @Override
    public long save(Ram computerComponent) {
        computerComponent.setProductId(nextId());
        mongoOperations.save(computerComponent, TYPE);
        return computerComponent.getProductId();
    }

    @Override
    public void update(Ram computerComponent) {

    }

    @Override
    public Ram findByProductId(long id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(id));
        return mongoOperations.findOne(query, Ram.class, TYPE);
    }

    @Override
    public Ram findByModel(String model) {
        Query query = new Query();
        query.addCriteria(Criteria.where("model").is(model));
        return mongoOperations.findOne(query,Ram.class, TYPE);
    }

    @Override
    public List<Ram> findAllComponents() {
        return mongoOperations.findAll(Ram.class, TYPE);
    }

    @Override
    public void deleteByProductId(long productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        mongoOperations.remove(query, Ram.class, TYPE);
    }

}
