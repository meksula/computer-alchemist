package com.computeralchemist.domain.creator;

import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.creator.setTypes.ComputerSet;
import org.springframework.stereotype.Service;

/**
 * @Author
 * Karol Meksuła
 * 13-04-2018
 * */

@Service
public class CompatibilityManagerImpl implements CompatibilityManager {

    @Override
    public boolean checkComponentsCompatibility(ComputerSet computerSet, ComputerComponent computerComponent) {
        return false;
    }
}
