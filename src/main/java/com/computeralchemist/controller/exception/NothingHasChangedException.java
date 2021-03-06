package com.computeralchemist.controller.exception;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.creator.setTypes.ComputerSet;

 /**
 * @Author
 * Karol Meksuła
 * 13-04-2018
 * */

public class NothingHasChangedException extends RuntimeException {
    private static ComputerSet computerSet;
    private static ComputerComponent computerComponent;

    public NothingHasChangedException(ComputerSet computerSet, ComputerComponent computerComponent) {
        NothingHasChangedException.computerSet = computerSet;
        NothingHasChangedException.computerComponent = computerComponent;
    }

    public static String getRaport() {
        return "Cannot assemble " + computerComponent.getProducent() + ", " + computerComponent.getModel()
                + ", to computer set with id = " + computerSet.getSetId();
    }
}
