package com.computeralchemist.domain.users.registration;

import com.computeralchemist.domain.users.User;

/**
 * @Author
 * Karol Meksuła
 * 24-05-2018
 * */

public interface UserValidator {
    boolean validateUser(User user);
}
