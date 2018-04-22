package com.computeralchemist.controller.exception;

import com.computeralchemist.domain.components.ComputerComponent;

/**
 * @Author
 * Karol Meksuła
 * 22-04-2018
 * */

public class ComponentExistException extends RuntimeException {
    private static ComputerComponent computerComponent;

    public ComponentExistException(ComputerComponent component) {
        computerComponent = component;
    }

    public static String getRaport() {
        return Error.reportRepetition();
    }

    private static class Error {
        private static String reportRepetition() {
            return "Component " + computerComponent.getProducent() + ", "
                    + computerComponent.getModel() + " just exist!" + System.lineSeparator()
                    + "Please look at /components/" + computerComponent.getComponentType().toString()
                    + "/" + computerComponent.getProductId();
        }

    }

}
