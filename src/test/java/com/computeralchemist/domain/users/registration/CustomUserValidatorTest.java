package com.computeralchemist.domain.users.registration;

import com.computeralchemist.domain.users.Address;
import com.computeralchemist.domain.users.User;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 24-05-2018
 * */

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class CustomUserValidatorTest {

    @Autowired
    private CustomUserValidator customUserValidator;

    private final String USERNAME = "MikołajKopernik";
    private final String NAME = "Mikołaj";
    private final String SURNAME = "Kopernik";
    private final String EMAIL = "Kopernik@Mikołaj.com";
    private final String PASSWORD = "Kopernik22222";
    private final int BORN = 1994;

    private User prepareValidUser() {
        User user = new User();
        user.setUsername(USERNAME);
        user.setName(NAME);
        user.setSurname(SURNAME);
        user.setEmail(EMAIL);
        user.setPassword(PASSWORD);
        user.setBornyear(BORN);
        user.setAddress(new Address());

        return user;
    }

    private User prepareInvalidUser() {
        User user = prepareValidUser();
        user.setBornyear(2019);
        return user;
    }

    @Test
    public void shouldAllowUserCreation() {
        boolean flag = customUserValidator.validateUser(prepareValidUser());
        assertTrue(flag);
    }

    @Test(expected = UserValidateException.class)
    public void shouldNOTAllowUserCreation() {
        customUserValidator.validateUser(new User());
    }

    @Test
    public void shouldNotAllowUserCreationNotValidData() {
        boolean flag = customUserValidator.validateUser(prepareInvalidUser());
        assertFalse(flag);
    }

}