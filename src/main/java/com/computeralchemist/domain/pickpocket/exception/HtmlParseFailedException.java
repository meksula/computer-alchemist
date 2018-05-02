package com.computeralchemist.domain.pickpocket.exception;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

public class HtmlParseFailedException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Parse is impossible, try again.";
    }
}
