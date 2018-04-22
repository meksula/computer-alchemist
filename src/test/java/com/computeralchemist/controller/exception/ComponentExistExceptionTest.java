package com.computeralchemist.controller.exception;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.Inet4Address;
import java.net.URI;
import java.net.UnknownHostException;

import static org.junit.Assert.*;

@Slf4j
public class ComponentExistExceptionTest {

    @Test
    public void uriTest() throws UnknownHostException {
        String local = UriComponentsBuilder.newInstance().build().toUriString();
        String host = Inet4Address.getLocalHost().toString();
        log.info(host);
    }
}