package com.computeralchemist.repository.users;

import com.computeralchemist.domain.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

/**
 * @Author
 * Karol Meksuła
 * 28-03-2018
 * */

@Repository
public class UserRepositoryImpl implements UserRepository {
    private MongoOperations mongoOperations;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setMongoOperations(MongoOperations mongoOperations, PasswordEncoder passwordEncoder) {
        this.mongoOperations = mongoOperations;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByUsername(String username) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        return mongoOperations.findOne(query, User.class, "user");
    }

    @Override
    public void save(User user) {
        User updated = encode(user);
        mongoOperations.save(updated, "user");
    }

    private User encode(User user) {
        String beforeEncode = user.getPassword();
        String afterEncode = passwordEncoder.encode(beforeEncode);
        user.setPassword(afterEncode);
        return user;
    }
}
