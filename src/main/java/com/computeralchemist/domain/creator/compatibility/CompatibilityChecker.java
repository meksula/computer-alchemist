package com.computeralchemist.domain.creator.compatibility;

import com.computeralchemist.domain.components.exceptions.NoComponentTypeException;
import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.creator.compatibility.concreteCheckers.*;
import com.computeralchemist.domain.creator.setTypes.ComputerSet;
import lombok.Getter;

/**
 * @Author
 * Karol Meksuła
 * 15-04-2018
 * */

@Getter
public abstract class CompatibilityChecker {

    public abstract boolean compatibilityCheck(final ComputerSet set, final ComputerComponent component);

    public static CompatibilityChecker build(ComponentType type) {
        if (type.equals(ComponentType.motherboard))
            return new MotherboardChecker();
        if (type.equals(ComponentType.cpu))
            return new CpuChecker();
        if (type.equals(ComponentType.ram))
            return new RamChecker();
        if (type.equals(ComponentType.disk))
            return new DiskChecker();
        if (type.equals(ComponentType.gpu))
            return new GraphicsCardChecker();
        if (type.equals(ComponentType.supply))
            return new PowerSupplyChecker();
        if (type.equals(ComponentType.computercase))
            return new ComputerCaseChecker();

        else throw new NoComponentTypeException();
    }

}
