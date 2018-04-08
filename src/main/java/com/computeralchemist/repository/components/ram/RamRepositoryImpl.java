package com.computeralchemist.repository.components.ram;

import com.computeralchemist.domain.components.ram.Ram;
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
public class RamRepositoryImpl implements RamRepository {
    private MongoOperations mongoOperations;

    @Autowired
    public void setMongoOperations(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public long count() {
        return mongoOperations.count(new Query(), Ram.class, "ram");
    }

    @Override
    public long save(Ram computerComponent) {
        computerComponent.setProductId(nextId());
        mongoOperations.save(computerComponent, "ram");
        return computerComponent.getProductId();
    }

    @Override
    public Ram findByProductId(long id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(id));
        return mongoOperations.findOne(query, Ram.class, "ram");
    }

    @Override
    public void deleteByProductId(long productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        mongoOperations.remove(query, Ram.class, "ram");
    }
}
