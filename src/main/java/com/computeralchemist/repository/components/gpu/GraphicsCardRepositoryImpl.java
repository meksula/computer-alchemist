package com.computeralchemist.repository.components.gpu;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.components.gpu.GraphicsCard;
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
 * 08-04-2018
 * */

@Repository
@CacheConfig(cacheNames = "componentCache")
public class GraphicsCardRepositoryImpl implements GraphicsCardRepository {
    private MongoOperations mongoOperations;
    private final String TYPE = "gpu";

    @Autowired
    public void setMongoOperations(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public long count() {
        return mongoOperations.count(new Query(), GraphicsCard.class, TYPE);
    }

    @Override
    public ComputerComponent save(GraphicsCard computerComponent) {
        computerComponent.setProductId(nextId());
        mongoOperations.save(computerComponent ,TYPE);
        return computerComponent;
    }

    @Override
    public void update(GraphicsCard computerComponent) {
        mongoOperations.save(computerComponent);
    }

    @Override
    @Cacheable
    public GraphicsCard findByProductId(long productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        return mongoOperations.findOne(query, GraphicsCard.class, TYPE);
    }

    @Override
    @Cacheable
    public GraphicsCard findByModel(String model) {
        Query query = new Query();
        query.addCriteria(Criteria.where("model").is(model));
        return mongoOperations.findOne(query, GraphicsCard.class, TYPE);
    }

    @Override
    public List<GraphicsCard> findAllComponents() {
        return mongoOperations.findAll(GraphicsCard.class, TYPE);
    }

    @Override
    public void deleteByProductId(long productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        mongoOperations.remove(query, GraphicsCard.class, TYPE);
    }
}
