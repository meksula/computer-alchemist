package com.computeralchemist.repository.components.gpu;

import com.computeralchemist.domain.components.gpu.GraphicsCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @Author
 * Karol Meksuła
 * 08-04-2018
 * */

@Repository
public class GraphicsCardRepositoryImpl implements GraphicsCardRepository {
    private MongoOperations mongoOperations;

    @Autowired
    public void setMongoOperations(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public long count() {
        return mongoOperations.count(new Query(), GraphicsCard.class, "gpu");
    }

    @Override
    public long save(GraphicsCard computerComponent) {
        computerComponent.setProducentId(nextId());
        mongoOperations.save(computerComponent ,"gpu");
        return computerComponent.getProducentId();
    }

    @Override
    public GraphicsCard findByProductId(long productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        return mongoOperations.findOne(query, GraphicsCard.class, "gpu");
    }

    @Override
    public void deleteByProductId(long productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        mongoOperations.remove(query, GraphicsCard.class, "gpu");
    }
}
