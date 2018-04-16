package com.computeralchemist.repository.users;

import com.computeralchemist.domain.users.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author
 * Karol Meksuła
 * 28-03-2018
 * */

public interface UserRepository extends MongoRepository<User, Long> {

    User findById(long userId);

    User findByUsername(String username);

    @Override
    <S extends User> S save(S user);
}
