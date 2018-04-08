package com.computeralchemist.repository.components.disk;

import com.computeralchemist.domain.components.disk.Disk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @Author
 * Karol Meksuła
 * 07-04-2018
 * */

@Repository
public class DiskRepositoryImpl implements DiskRepository {
    private MongoOperations mongoOperations;

    @Autowired
    public void setMongoOperations(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public long count() {
        return mongoOperations.count(new Query(), Disk.class, "disk");
    }

    @Override
    public long save(Disk computerComponent) {
        computerComponent.setProductId(nextId());
        mongoOperations.save(computerComponent, "disk");
        return computerComponent.getProductId();
    }

    @Override
    public Disk findByProductId(long productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        return mongoOperations.findOne(query, Disk.class, "disk");
    }

    @Override
    public void deleteByProductId(long productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        mongoOperations.remove(query, Disk.class, "disk");
    }
}
