package com.computeralchemist.repository.users;

import com.computeralchemist.domain.users.User;

/**
 * @Author
 * Karol Meksuła
 * 28-03-2018
 * */

public interface UserRepository {
    User findByUsername(String username);

    void save(User user);
}
