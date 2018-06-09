package com.computeralchemist.domain.users.registration;

import com.computeralchemist.domain.users.User;
import com.computeralchemist.repository.users.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @Author
 * Karol Meksuła
 * 24-05-2018
 * */

@Service
public class CustomUserValidator implements UserValidator {
    private User user;
    private UserRepository userRepository;
    private ArrayList<Boolean> flags;

    public CustomUserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.flags = new ArrayList<>();
    }

    @Override
    public boolean validateUser(User user) {
        this.user = user;

        try {
            flags.add(isExistInDatabase());
            flags.add(checkUsername());
            flags.add(checkName());
            flags.add(checkSurname());
            flags.add(checkEmail());
            flags.add(checkPassword());
            flags.add(checkBornYear());
            flags.add(checkAddress());
        } catch (NullPointerException npo) {
            throw new UserValidateException();
        }

        return isAllowOrNot();
    }

    private boolean isExistInDatabase() {
        Optional<User> optional = userRepository.findByUsername(user.getUsername());
        return !optional.isPresent();
    }

    private boolean checkUsername() {
        String username = user.getUsername();
        return username.length() > 5 && username.length() < 16;
    }

    private boolean checkName() {
        String name = user.getName();
        return name.length() > 2 && name.length() < 16;
    }

    private boolean checkSurname() {
        String surname = user.getSurname();
        return surname.length() > 2 && surname.length() < 16;
    }

    private boolean checkEmail() {
        String email = user.getEmail();
        return email.contains("@")
                && email.contains(".")
                && email.length() > 5
                && email.length() < 40;
    }

    private boolean checkPassword() {
        String password = user.getPassword();
        return password.length() > 6
                && password.length() < 30;
    }

    private boolean checkBornYear() {
        int bornyear = user.getBornyear();
        return bornyear > 1930 && bornyear < 2018;
    }

    private boolean checkAddress() {
        return true;
    }

    private boolean isAllowOrNot() {
        for (Boolean flag : flags) {
            System.out.println(flag);
            if (!flag)
                return false;
        }
        return true;
    }

}
