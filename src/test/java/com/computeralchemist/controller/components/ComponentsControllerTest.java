package com.computeralchemist.controller.components;

import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.components.OpinionDto;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.repository.RepositoryProvider;
import com.computeralchemist.repository.opinions.OpinionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @Author
 * Karol Meksuła
 * 18-04-2018
 * */

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@FixMethodOrder(value = MethodSorters.JVM)
public class ComponentsControllerTest {

    private MediaType mediaType = new MediaType(MediaType.APPLICATION_JSON_UTF8.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @Autowired
    private WebApplicationContext context;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Autowired
    public void setMessageConverter(HttpMessageConverter<?>[] convs) {
        mappingJackson2HttpMessageConverter = Arrays.stream(convs)
                .filter(converter -> converter instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse(null);
    }

    private MockMvc mockMvc;

    private Motherboard motherboard = new Motherboard();
    private final String PRODUCENT = "Gigabyte";
    private final String MODEL = "GT3994";

    @Autowired
    private RepositoryProvider repositoryProvider;

    @Autowired
    private OpinionRepository opinionRepository;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();

        motherboard.setComponentType(ComponentType.motherboard);
        motherboard.setProducent(PRODUCENT);
        motherboard.setModel(MODEL);
    }

    @Test
    public void beanInjectionTest() {
        assertNotNull(context);
        assertNotNull(mappingJackson2HttpMessageConverter);
        assertNotNull(mockMvc);
        assertNotNull(repositoryProvider);
        assertNotNull(opinionRepository);
    }

    @Test
    public void componentShouldBeFound() throws Exception {
        long productId = repositoryProvider.saveComponent(motherboard);
        ComputerComponent computerComponent =
                repositoryProvider.findComponent("motherboard", productId);
        assertNotNull(computerComponent);

        log.info("ProductId: " + productId);
        mockMvc.perform(get("/components/" +
                computerComponent.getComponentType().toString() + "/" + productId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.producent", is(PRODUCENT)))
                .andExpect(jsonPath("$.model", is(MODEL)))
                .andExpect(content().contentType(mediaType));
    }

    private long INVALID_ID = 3443;

    @Test
    public void componentShouldNotBeFound() throws Exception {
        mockMvc.perform(get("/components/motherboard/" + INVALID_ID))
                .andExpect(content().contentType(mediaType))
                .andExpect(status().isNotFound());
    }

    @Test
    public void listOfComponentsShouldBeFound() throws Exception {
        mockMvc.perform(get("/components/motherboard"))
                .andExpect(content().contentType(mediaType))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void listOfComponentsNotFound() throws Exception {
        mockMvc.perform(get("/components/mottthheeedd"))
                .andExpect(content().contentType(mediaType))
                .andExpect(status().isNotFound());
    }

    private String expectedType = "motherboard";
    private long expectedId = 1;

    @Test
    public void opinionAboutProductShouldBeAdded() throws Exception {
        Motherboard motherboard = (Motherboard) repositoryProvider.findComponent(expectedType, expectedId);
        assertNotNull(motherboard);

        long id = motherboard.getProductId();

        mockMvc.perform(put("/components/motherboard/" + id + "/opinions")
                .content(opinionJson())
                .contentType(mediaType)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    private final String AUTHOR = "Mikolaj_Kopernik";
    private final String CONTENT = "I'm really enjoy by this product! If I were you I'll take it now!";
    private final double RATE = 4;

    private String opinionJson() throws JsonProcessingException {
        OpinionDto opinionDto = new OpinionDto();
        opinionDto.setComponentType(ComponentType.valueOf(expectedType));
        opinionDto.setAuthor(AUTHOR);
        opinionDto.setContent(CONTENT);
        opinionDto.setRate(RATE);
        opinionDto.setDate(LocalDate.of(2014,3, 20).toString());

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(opinionDto);
    }

    @Test
    public void opinionsListAboutProductShouldBeLoaded() throws Exception {
        mockMvc.perform(get("/components/motherboard/" + expectedId + "/opinions"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    public void opinionsListAboutProductShouldNotBe_Empty() throws Exception {
        mockMvc.perform(get("/components/motherboard/" + INVALID_ID + "/opinions"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void requestShouldRemoveComponent() throws Exception {
        ComputerComponent component = repositoryProvider.findComponent(expectedType, expectedId);
        assertNotNull(component);

        mockMvc.perform(delete("/components/" + expectedType + "/" + expectedId))
                .andDo(print())
                .andExpect(status().isOk());

        ComputerComponent shouldNotExistNow = repositoryProvider.findComponent(expectedType, expectedId);
        assertNull(shouldNotExistNow);
    }

    @Test
    public void requestShoundCannotRemoveBecauseThereIsNoComponent() throws Exception {
        mockMvc.perform(delete("/components/" + expectedType + "/" + expectedId))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
