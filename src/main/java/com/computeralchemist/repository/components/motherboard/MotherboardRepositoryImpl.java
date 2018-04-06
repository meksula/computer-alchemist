package com.computeralchemist.repository.components.motherboard;

import com.computeralchemist.domain.components.motherboard.Motherboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @Author
 * Karol Meksuła
 * 05-04-2018
 * */

@Repository
public class MotherboardRepositoryImpl implements MotherboardRepository {
    private MongoOperations mongoOperations;

    @Autowired
    public void setMongoOperations(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public long count() {
        return mongoOperations.count(new Query(), Motherboard.class, "motherboard");
    }

    @Override
    public Motherboard save(Motherboard computerComponent) {
        computerComponent.setProductId(nextId());
        mongoOperations.save(computerComponent, "motherboard");
        return computerComponent;
    }

    @Override
    public Motherboard findByProductId(long productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        return mongoOperations.findOne(query, Motherboard.class, "motherboard");
    }

    @Override
    public void deleteByProductId(long productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        mongoOperations.remove(query, Motherboard.class, "motherboard");
    }
}
