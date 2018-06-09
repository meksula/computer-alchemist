package com.computeralchemist.controller.exception;

/**
 * @Author
 * Karol Meksuła
 * 18-04-2018
 * */

public class SetNotFoundException extends RuntimeException {

    private static String type;
    private static long id;

    public SetNotFoundException(String type, long id) {
        SetNotFoundException.type = type;
        SetNotFoundException.id = id;
    }

    public static class Error {
        public static String report() {
            return "Error! There is no set type: [" + type + "], or set with id: [" + id + "] not Exist!";
        }
    }
}
