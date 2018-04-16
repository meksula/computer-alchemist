package com.computeralchemist.domain.creator.compatibility;

import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.components.cpu.Cpu;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.domain.creator.setTypes.ComputerSet;
import com.computeralchemist.domain.creator.setTypes.GamingComputerSet;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertFalse;

/**
 * @Author
 * Karol Meksuła
 * 15-04-2018
 * */

//TODO po implementacji poszczególnych komponentów testować tą klasę.

@Slf4j
public class CompatibilityManagerTest {

    private ComputerSet computerSet = new GamingComputerSet();
    private ComputerComponent computerComponent = new Cpu();

    private final ComponentType TYPE = ComponentType.cpu;

    @Before
    public void setUp() {
        computerComponent.setComponentType(TYPE);
    }

}