package com.computeralchemist.domain.creator.setTypes;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 21-04-2018
 * */

public class ComputerSetTypesTest {

    private final long ID = 344;

    @Test
    public void computerSetTypesShouldReturnCreatedSpecifiedObjectWork() {
        ComputerSet computerSet = ComputerSetTypes.work.createSet(ID);
        assertTrue(computerSet instanceof WorkComputerSet);
        assertEquals(ID, computerSet.getSetId());
    }

    @Test
    public void computerSetTypesShouldReturnCreatedSpecifiedObjectGaming() {
        ComputerSet computerSet = ComputerSetTypes.gaming.createSet(ID);
        assertTrue(computerSet instanceof GamingComputerSet);
        assertEquals(ID, computerSet.getSetId());
    }

    @Test
    public void computerSetTypesShouldReturnCreatedSpecifiedObjectFamily() {
        ComputerSet computerSet = ComputerSetTypes.family.createSet(ID);
        assertTrue(computerSet instanceof FamilyComputerSet);
        assertEquals(ID, computerSet.getSetId());
    }
}