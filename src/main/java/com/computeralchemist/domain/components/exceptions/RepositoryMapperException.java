package com.computeralchemist.domain.components.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * @Author
 * Karol Meksuła
 * 07-04-2018
 * */

public class RepositoryMapperException extends IOException {
    private final Logger logger = LogManager.getLogger(RepositoryMapperException.class);

    public RepositoryMapperException(String type) {
        logger.error("There is no repository: " + type);
    }

}
