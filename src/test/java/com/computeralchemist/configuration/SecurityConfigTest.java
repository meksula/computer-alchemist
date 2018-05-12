package com.computeralchemist.configuration;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class SecurityConfigTest {
    private final String myPassword = "karol2018";

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void encodePasswordForTesting() {
        String encoded = passwordEncoder.encode(myPassword);
        log.info(encoded);
    }

}