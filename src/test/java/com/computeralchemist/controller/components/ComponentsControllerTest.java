package com.computeralchemist.controller.components;

import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.ComputerComponent;
import com.computeralchemist.domain.components.motherboard.Motherboard;
import com.computeralchemist.repository.RepositoryProvider;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
import java.util.Arrays;

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
public class ComponentsControllerTest {

    private MediaType mediaType = new MediaType(MediaType.APPLICATION_JSON_UTF8.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @Autowired
    private WebApplicationContext context;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Autowired
    public void setMessageConverter(HttpMessageConverter<?>[] convs) {
        mappingJackson2HttpMessageConverter = Arrays.asList(convs)
                .stream()
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
                .andExpect(status().isOk());
    }

    @Test
    public void listOfComponentsNotFound() throws Exception {
        mockMvc.perform(get("/components/mottthheeedd"))
                .andExpect(content().contentType(mediaType))
                .andExpect(status().isNotFound());
    }



}
