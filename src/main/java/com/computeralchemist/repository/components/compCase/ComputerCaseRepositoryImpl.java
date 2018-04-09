package com.computeralchemist.repository.components.compCase;

import com.computeralchemist.domain.components.computerCase.ComputerCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @Author
 * Karol Meksuła
 * 09-04-2018
 * */

@Repository
public class ComputerCaseRepositoryImpl implements ComputerCaseRepository {
    private MongoOperations mongoOperations;

    @Autowired
    public void setMongoOperations(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public long count() {
        return mongoOperations.count(new Query(), "computercase");
    }

    @Override
    public long save(ComputerCase computerComponent) {
        computerComponent.setProductId(nextId());
        mongoOperations.save(computerComponent, "computercase");
        return computerComponent.getProductId();
    }

    @Override
    public ComputerCase findByProductId(long productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        return mongoOperations.findOne(query, ComputerCase.class, "computercase");
    }

    @Override
    public void deleteByProductId(long productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        mongoOperations.remove(query, ComputerCase.class, "computercase");
    }
}
