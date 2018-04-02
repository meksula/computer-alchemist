package com.computeralchemist.domain.components.motherboard;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 02-04-2018
 * */

public class MotherboardParametersTest {
    private MotherboardParameters motherboardParameters = new MotherboardParameters();

    private final String CHIPSET = "B250";
    private final String SOCKET = "1151 Coffe Lake";
    private final int RAM_SOCKETS = 4;
    private final String BIOS = "AMI UEFI";
    private List<String> PROC_AV;
    private List<String> OTH_SOCK;

    private void fillLists() {
        PROC_AV = new ArrayList<>();
        OTH_SOCK = new ArrayList<>();

        PROC_AV.add("Intel Core i3");
        PROC_AV.add("Intel Core i5");
        PROC_AV.add("Intel Core i7");

        OTH_SOCK.add("M.2 slot x2");
        OTH_SOCK.add("PCI Express x1 (4 szt.)");
        OTH_SOCK.add("PCI Express x16 (1 szt.)");
    }

    @Before
    public void setUp() {
        fillLists();

        motherboardParameters.setChipset(CHIPSET);
        motherboardParameters.setSocket(SOCKET);
        motherboardParameters.setRamSockets(RAM_SOCKETS);
        motherboardParameters.setBios(BIOS);
        motherboardParameters.setProcesorAvailables(PROC_AV);
        motherboardParameters.setOtherSockets(OTH_SOCK);
    }

    @Test
    public void instantiateTest() {
        assertTrue(motherboardParameters instanceof MotherboardParameters);
    }

    @Test
    public void listsTest() {
        assertEquals(3, motherboardParameters.getProcesorAvailables().size());
        assertEquals(3, motherboardParameters.getOtherSockets().size());
    }

}