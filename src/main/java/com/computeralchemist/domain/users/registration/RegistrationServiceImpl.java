package com.computeralchemist.domain.users.registration;

import com.computeralchemist.domain.users.User;
import com.computeralchemist.repository.users.UserRepository;
import org.springframework.stereotype.Service;

/**
 * @Author
 * Karol Meksuła
 * 03-06-2018
 * */

@Service
public class RegistrationServiceImpl implements RegistrationService {
    private UserValidator userValidator;
    private UserRepository userRepository;

    public RegistrationServiceImpl(UserValidator userValidator,
                                   UserRepository userRepository) {
        this.userValidator = userValidator;
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {
        if (userValidator.validateUser(user)) {
            addAuthority(user);
            return userRepository.save(user);
        }

        throw new UserValidateException();
    }

    private void addAuthority(User user) {
        user.setRoles(new String[] {"USER"});
    }
}
