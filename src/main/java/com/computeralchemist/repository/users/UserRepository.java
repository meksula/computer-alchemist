package com.computeralchemist.repository.users;

import com.computeralchemist.domain.users.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * @Author
 * Karol Meksuła
 * 28-03-2018
 * */

public interface UserRepository extends MongoRepository<User, Long> {

    Optional<User> findById(long userId);

    Optional<User> findByUsername(String username);

    @Override
    <S extends User> S save(S user);
}
