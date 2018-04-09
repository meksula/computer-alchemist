package com.computeralchemist.controller.components;

/**
 * @Author
 * Karol Meksuła
 * 08-04-2018
 * */

public class NoSuchComponentException extends RuntimeException {

    public NoSuchComponentException(String result) {
        System.out.println(result + " - there is not Computer component like this!");
    }

    private String notKnown(String result) {
        return result;
    }

}
