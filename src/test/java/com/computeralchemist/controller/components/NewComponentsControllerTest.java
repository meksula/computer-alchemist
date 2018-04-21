package com.computeralchemist.controller.components;

import com.computeralchemist.domain.components.ComponentType;
import com.computeralchemist.domain.components.ram.Ram;
import com.computeralchemist.domain.components.ram.RamParameters;
import com.computeralchemist.repository.RepositoryProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
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
 * 21-04-2018
 * */

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class NewComponentsControllerTest {

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

    @Autowired
    private RepositoryProvider repositoryProvider;

    @Autowired
    private ObjectMapper objectMapper;

    private Ram ram = new Ram();
    private RamParameters ramParameters = new RamParameters();
    private final ComponentType TYPE = ComponentType.ram;
    private final String PRODUCENT = "Crucial";
    private final String MODEL = "md343";
    private final double FREQUENCY = 3444;
    private final String MEMORY_TYPE = "DDR4";

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();

        ramParameters.setFrequency(FREQUENCY);
        ramParameters.setMemoryType(MEMORY_TYPE);
        ram.setRamParameters(ramParameters);
        ram.setProducent(PRODUCENT);
        ram.setModel(MODEL);
        ram.setComponentType(TYPE);
    }

    @Test
    public void beanInjectionTest() {
        assertNotNull(context);
        assertNotNull(mappingJackson2HttpMessageConverter);
        assertNotNull(mockMvc);
        assertNotNull(repositoryProvider);
        assertNotNull(objectMapper);
    }

    @Test
    public void addNewComponentTest_shouldAddCorrectly() throws Exception {
        String ramJson = objectMapper.writeValueAsString(ram);

        mockMvc.perform(post("/components")
                .content(ramJson)
                .contentType(mediaType)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated())
                .andExpect(header().string("location",
                        containsString("http://localhost/components/" + TYPE + "/")));
    }

    @Test
    public void addNewComponentTest_shouldNotAddCorrectly() throws Exception {
        String ramJson = objectMapper.writeValueAsString(ram).toUpperCase();

        mockMvc.perform(post("/components")
                .content(ramJson)
                .contentType(mediaType)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isConflict());
    }
}