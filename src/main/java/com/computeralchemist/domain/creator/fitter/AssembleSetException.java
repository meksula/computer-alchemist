package com.computeralchemist.domain.creator.fitter;

/**
 * @Author
 * Karol Meksuła
 * 11-05-2018
 * */

public class AssembleSetException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Cannot assemble. ComputerSet or ComputerComponent not loaded correctly.";
    }

}
