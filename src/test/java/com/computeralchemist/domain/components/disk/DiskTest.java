package com.computeralchemist.domain.components.disk;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * @Author
 * Karol Meksuła
 * 07-04-2018
 * */

public class DiskTest {

    private final String PRODUCENT = "Kingston";
    private final String MODEL = "SU800";
    private final String DESC = "Bardzo wydajny dysk SSD na pewno dobrze zastąpi wysłużony HDD";
    private final double INDEX = 4.0;
    private final long ID = 32424;

    private final DiskParameters diskParameters = mock(DiskParameters.class);

    private Disk provideComponent() {
        Disk disk = new Disk();
        disk.setProductId(ID);
        disk.setProducent(PRODUCENT);
        disk.setModel(MODEL);
        disk.setDescription(DESC);
        disk.setCompatibiltyIndex(INDEX);
        disk.setDiskParameters(diskParameters);
        return disk;
    }

    @Test
    public void instantiateCorrectlyTest() {
        Disk disk = provideComponent();

        assertEquals(ID, disk.getProductId());
        assertEquals(PRODUCENT, disk.getProducent());
        assertEquals(MODEL, disk.getModel());
        assertEquals(DESC, disk.getDescription());
        assertEquals(INDEX, disk.getCompatibiltyIndex(), 1e-15);
        assertNotNull(disk.getDiskParameters());
    }

}