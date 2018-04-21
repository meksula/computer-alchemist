package com.computeralchemist.controller.exception;

/**
 * @Author
 * Karol Meksuła
 * 21-04-2018
 * */

public class BadComponentTypeException extends RuntimeException {
    private static String badJson;

    public BadComponentTypeException(String badJson) {
        this.badJson = badJson;
    }

    public static class Error {
        public static String report() {
            return "Error: there is no component type like: [" + badJson + "]";
        }
    }
}
