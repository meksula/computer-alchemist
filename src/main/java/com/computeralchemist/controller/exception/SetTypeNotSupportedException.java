package com.computeralchemist.controller.exception;

/**
 * @Author
 * Karol Meksuła
 * 18-04-2018
 * */

public class SetTypeNotSupportedException extends RuntimeException {
    private static String type;

    public SetTypeNotSupportedException(String type) {
        this.type = type;
    }

    public static class Error {
        public static String report() {
            return "Error - type [" + type + "] is not support!";
        }
    }
}
