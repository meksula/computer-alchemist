package com.computeralchemist.controller.exception;

/**
 * @Author
 * Karol Meksuła
 * 02-04-2018
 * */

public class ComponentNotFoundException extends RuntimeException {
    private long componentId;

    public ComponentNotFoundException(long componentId) {
        this.componentId = componentId;
    }

    public long getComponentId() {
        return componentId;
    }
}
