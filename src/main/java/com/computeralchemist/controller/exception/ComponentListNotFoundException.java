package com.computeralchemist.controller.exception;

/**
 * @Author
 * Karol Meksuła
 * 17-04-2018
 * */

public class ComponentListNotFoundException extends RuntimeException {

    private static String component;

    public ComponentListNotFoundException(String component) {
        this.component = component;
    }

    public static class Error {
        public static String reportList() {
            return "There is no component like: " + component;
        }
    }
}
