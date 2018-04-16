package com.computeralchemist.domain.creator.fitter;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.creator.setTypes.ComputerSet;

/**
 * @Author
 * Karol Meksuła
 * 13-04-2018
 * */

public interface ComputerFitter {

    ComputerSet assembleComputerSet(ComputerSet computerSet, ComputerComponent computerComponent);

}
