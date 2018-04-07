package com.computeralchemist.domain.components.disk;

import org.junit.Test;

import static com.computeralchemist.domain.components.disk.DriveType.HDD;
import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 07-04-2018
 * */

public class DiskParametersTest {
    private final DriveType TYPE = HDD;
    private final String FORMAT = "2.5";
    private final int CAPACITY_GB = 256;
    private final double READ_SPEED_MBS = 560;
    private final double WRITE_SPEED_MBS = 520;

    private DiskParameters provideParameters() {
        DiskParameters diskParameters = new DiskParameters();
        diskParameters.setType(TYPE);
        diskParameters.setFormat(FORMAT);
        diskParameters.setCapacity(CAPACITY_GB);
        diskParameters.setReadSpeed(READ_SPEED_MBS);
        diskParameters.setWriteSpeed(WRITE_SPEED_MBS);
        return diskParameters;
    }

    private final double DELTA = 1e-15;

    @Test
    public void instantiateTest() {
        DiskParameters diskParameters = provideParameters();

        assertEquals(TYPE, diskParameters.getType());
        assertEquals(FORMAT, diskParameters.getFormat());
        assertEquals(CAPACITY_GB, diskParameters.getCapacity());
        assertEquals(READ_SPEED_MBS, diskParameters.getReadSpeed(), DELTA);
        assertEquals(WRITE_SPEED_MBS, diskParameters.getWriteSpeed(), DELTA);
    }
}