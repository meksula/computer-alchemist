package com.computeralchemist.domain.pickpocket.exception;

/**
 * @Autor
 * Karol Meksuła
 * 02-05-2018
 * */

public class AddressNotSupportedException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Website address not supported! Please see in documentation available URLs.";
    }

}
