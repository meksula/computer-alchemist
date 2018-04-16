package com.computeralchemist.domain.creator.compatibility.concreteCheckers;

import com.computeralchemist.domain.components.disk.Disk;
import com.computeralchemist.domain.creator.setTypes.WorkComputerSet;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 15-04-2018
 * */

public class DiskCheckerTest {
    private DiskChecker diskChecker = new DiskChecker();

    @Test
    public void shouldBeAbleToAssembleDisk() {
        boolean flag = diskChecker.compatibilityCheck(new WorkComputerSet(), new Disk());
        assertTrue(flag);
    }
}