package com.computeralchemist.repository.components.supply;

import com.computeralchemist.domain.components.supply.PowerSupply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @Author
 * Karol Meksuła
 * 07-08-2018
 * */

@Repository
public class PowerSupplyRepositoryImpl implements PowerSupplyRepository {
    private MongoOperations mongoOperations;

    @Autowired
    public void setMongoOperations(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public long count() {
        return mongoOperations.count(new Query(), PowerSupply.class, "supply");
    }

    @Override
    public long save(PowerSupply computerComponent) {
        computerComponent.setProductId(nextId());
        mongoOperations.save(computerComponent, "supply");
        return computerComponent.getProductId();
    }

    @Override
    public PowerSupply findByProductId(long productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        return mongoOperations.findOne(query, PowerSupply.class, "supply");
    }

    @Override
    public void deleteByProductId(long productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        mongoOperations.remove(query, PowerSupply.class, "supply");
    }
}
