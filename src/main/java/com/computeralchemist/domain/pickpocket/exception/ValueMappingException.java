package com.computeralchemist.domain.pickpocket.exception;

/**
 * @Author
 * Karol Meksuła
 * 05-05-2018
 * */

public class ValueMappingException extends RuntimeException {
    private String fieldName;

    public ValueMappingException(String fieldName) {
            this.fieldName = fieldName;
    }

    @Override
    public String getMessage() {
        return "Cannot assign to the value named: `" + fieldName + "`";
    }
}
