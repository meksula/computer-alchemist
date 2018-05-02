package com.computeralchemist.controller.exception;

/**
 * @Author
 * Karol Meksuła
 * 01-05-2018
 * */

public class CannotReadUrlException extends RuntimeException {
    private static String url;

    public CannotReadUrlException(String url) {
        CannotReadUrlException.url = url;
    }

    public CannotReadUrlException() {}

    @Override
    public String getMessage() {
        return "Typed URL is not correct! Check it out again! " + System.lineSeparator()
                + url;
    }
}
