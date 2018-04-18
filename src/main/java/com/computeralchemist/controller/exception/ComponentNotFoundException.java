package com.computeralchemist.controller.exception;

/**
 * @Author
 * Karol Meksuła
 * 17-04-2018
 * */

public class ComponentNotFoundException extends RuntimeException {

    private static String component;
    private static long productId;

    public ComponentNotFoundException(String component, long id) {
        this.component = component;
        this.productId = id;
    }

    public static class Error {
        public static String reportOne() {
            return "Error. Component: [" + component + "], productId:[" + productId + "] not Exist!";
        }
    }
}
