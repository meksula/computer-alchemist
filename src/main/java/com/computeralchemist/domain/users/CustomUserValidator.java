package com.computeralchemist.domain.users;

import com.computeralchemist.repository.users.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author
 * Karol Meksuła
 * 24-05-2018
 * */

@Service
public class CustomUserValidator implements UserValidator {
    private boolean pass = false;
    private User user;
    private UserRepository userRepository;

    public CustomUserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean validateUser(User user) {
        this.user = user;

        return pass;
    }

    private void isExistInDatabase() {
        AtomicBoolean decission = new AtomicBoolean(false);
        Optional<User> optional = userRepository.findByUsername(user.getUsername());
        optional.ifPresent(value -> decission.set(true));
        decission.get();
    }

    private boolean checkUsername() {
        String username = user.getUsername();
        return username.length() > 5 && username.length() < 16;
    }
}
