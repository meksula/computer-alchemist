package com.computeralchemist.domain.creator;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.creator.setTypes.ComputerSet;

/**
 * @Author
 * Karol Meksuła
 * 13-04-2018
 * */

public interface CompatibilityManager {
    boolean checkComponentsCompatibility(ComputerSet computerSet, ComputerComponent computerComponent);
}
