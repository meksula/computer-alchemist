package com.computeralchemist.repository.opinions;

import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.OpinionDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 23-04-2018
 * */

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OpinionRepositoryTest {

    @Autowired
    private OpinionRepository opinionRepository;

    private OpinionDto opinionDto;

    private final long OPINION_ID = 200;
    private final String COMPONENT_TYPE = "motherboard";
    private final long PRODUCT_ID = 12;
    private final String AUTHOR = "Mikolaj_Kopernik";
    private final String CONTENT = "I'm really enjoy by this product! If I were you I'll take it now!";
    private final double RATE = 4;
    private final double DELTA = 1e-15;

    @Before
    public void setUp() {
        opinionDto = new OpinionDto();
        opinionDto.setOpinionId(OPINION_ID);
        opinionDto.setComponentType(ComponentType.valueOf(COMPONENT_TYPE));
        opinionDto.setProductId(PRODUCT_ID);
        opinionDto.setAuthor(AUTHOR);
        opinionDto.setContent(CONTENT);
        opinionDto.setRate(RATE);
    }

    @Test
    public void a_instantiateTest() {
        assertNotNull(opinionRepository);
        assertNotNull(opinionDto);
    }

    @Test
    public void b_opinionShouldBeSaveCorrectly() {
        OpinionDto dto = opinionRepository.save(opinionDto);
        assertNotNull(dto);
        assertEquals(AUTHOR, dto.getAuthor());
    }

    @Test
    public void c_opinionListShouldBeFetchCorrectly() {
        List<OpinionDto> justSaved = opinionRepository
                .findByComponentTypeAndProductId(ComponentType.valueOf(COMPONENT_TYPE), PRODUCT_ID);

        assertEquals(1, justSaved.size());
    }

    @Test
    public void d_opinionShouldBeRemovedByOpinionId() {
        List<OpinionDto> justSaved = opinionRepository
                .findByComponentTypeAndProductId(ComponentType.valueOf(COMPONENT_TYPE), PRODUCT_ID);

        assertEquals(1, justSaved.size());

        opinionRepository.deleteByOpinionId(OPINION_ID);

        List<OpinionDto> shouldbeEmpty = opinionRepository
                .findByComponentTypeAndProductId(ComponentType.valueOf(COMPONENT_TYPE), PRODUCT_ID);

        assertEquals(0, shouldbeEmpty.size());
    }

}