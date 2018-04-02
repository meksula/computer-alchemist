package com.computeralchemist.security;

import com.computeralchemist.config.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 02-04-2018
 * */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class UserDetailsServiceImplTest {
    private final String USERNAME = "admin";
    private final String INVALID_USERNAME = "slcmkwmxk";

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Test
    public void shouldLoadUser() {
        User user = (User) userDetailsService.loadUserByUsername(USERNAME);
        assertNotNull(user);
    }

    @Test(expected = UsernameNotFoundException.class)
    public void shouldThrowExpectedException() {
        userDetailsService.loadUserByUsername(INVALID_USERNAME);
    }

}