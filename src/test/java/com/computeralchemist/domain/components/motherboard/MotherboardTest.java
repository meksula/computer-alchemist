package com.computeralchemist.domain.components.motherboard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * @Author
 * Karol Meksuła
 * 30-03-2018
 * */

public class MotherboardTest {
    private Motherboard motherboard;
    private MotherboardParameters componentParameters = mock(MotherboardParameters.class);

    private final double DELTA = 1e-15;

    private final String PRODUCENT = "Gigabyte";
    private final String MODEL = "B432i";
    private final String DESC = "Example of component's description.";
    private final double COMP_INDX = 3.2;
    private final String URL = "http://www.images.com/motherboard/358822";

    @Before
    public void setUp() {
        motherboard = new Motherboard();
        motherboard.setProducent(PRODUCENT);
        motherboard.setModel(MODEL);
        motherboard.setCompatibleIndex(COMP_INDX);
        motherboard.setMotherboardParameters(componentParameters);
        motherboard.setDescription(DESC);
        motherboard.setUrlToResource(URL);
    }

    @Test
    public void instantiateCorrectly() {
        assertNotNull(componentParameters);
        assertNotNull(motherboard);
    }

    @Test
    public void fieldsOfSutShouldBeEquivalent() {
        assertNotNull(motherboard.getMotherboardParameters());
        assertEquals(PRODUCENT, motherboard.getProducent());
        assertEquals(MODEL, motherboard.getModel());
        assertEquals(DESC, motherboard.getDescription());
        assertEquals(COMP_INDX, motherboard.getCompatibleIndex(), DELTA);
        assertEquals(URL, motherboard.getUrlToResource());
    }
}