package com.computeralchemist.domain.creator.setTypes;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 21-04-2018
 * */

@Slf4j
public class ComputerSetTest {
    private ComputerSet computerSet;
    private final String AUTHOR = "MikolajKopernik";

    @Test
    public void familyComputerSetTest() {
        computerSet = new FamilyComputerSet();
        assertTrue(computerSet instanceof FamilyComputerSet);
        computerSet.setAuthor(AUTHOR);
        assertEquals(AUTHOR, computerSet.getAuthor());
    }

    @Test
    public void gamingComputerSetTest() {
        computerSet = new GamingComputerSet();
        assertTrue(computerSet instanceof GamingComputerSet);
        computerSet.setAuthor(AUTHOR);
        assertEquals(AUTHOR, computerSet.getAuthor());
    }

    @Test
    public void workComputerSetTest() {
        computerSet = new WorkComputerSet();
        assertTrue(computerSet instanceof WorkComputerSet);
        computerSet.setAuthor(AUTHOR);
        assertEquals(AUTHOR, computerSet.getAuthor());
    }
}