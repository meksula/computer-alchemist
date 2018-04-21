package com.computeralchemist.controller.exception;

/**
 * @Author
 * Karol Meksuła
 * 21-04-2018
 * */

public class SetListNotFoundException extends RuntimeException {
    private static String type;

    public SetListNotFoundException(String type) {
        this.type = type;
    }

    public static class Error {
        public static String report() {
            return "There is no list of components like: [" + type + "]";
        }
    }
}
