package com.computeralchemist.domain.components;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 23-04-2018
 * */

@Slf4j
public class OpinionDtoTest {
    private OpinionDto opinionDto;

    private final String COMPONENT_TYPE = "motherboard";
    private final long COMPONENT_ID = 12;

    private final String AUTHOR = "Mikolaj_Kopernik";
    private final String CONTENT = "I'm really enjoy by this product! If I were you I'll take it now!";
    private final double RATE = 4;
    private final double DELTA = 1e-15;

    @Before
    public void setUp() {
        opinionDto = new OpinionDto();
        opinionDto.setAuthor(AUTHOR);
        opinionDto.setContent(CONTENT);
        opinionDto.setRate(RATE);
        opinionDto.setComponentType(ComponentType.valueOf(COMPONENT_TYPE));
        opinionDto.setProductId(COMPONENT_ID);
        opinionDto.setDate(LocalDate.now().toString());
    }

    @Test
    public void fieldsShouldInitCorrectly() {
        assertEquals(COMPONENT_ID, opinionDto.getProductId());
        assertEquals(COMPONENT_TYPE, opinionDto.getComponentType().toString());
        assertEquals(AUTHOR, opinionDto.getAuthor());
        assertEquals(CONTENT, opinionDto.getContent());
        assertEquals(RATE, opinionDto.getRate(), DELTA);
    }

}